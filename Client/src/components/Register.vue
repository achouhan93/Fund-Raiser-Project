/* eslint-disable */
<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-layout aria-rowcount="center">
      <v-flex xs6 offset-xs3>
        <div class="white elevation-2">
           <v-toolbar flat dense class="cyan" dark>
             <v-toolbar-title>Register</v-toolbar-title>
           </v-toolbar>
           <div class="pl-4 pr-4 pb-2 pt-2">
            <br>
             <v-text-field
               label="First name"
               placeholder="your first name"
               v-model="fname"></v-text-field>
             <br>
             <v-text-field
               label="Last name"
               placeholder="your last name"
               v-model="lname"></v-text-field>
            <div class="error" v-html="error"></div>
             <br>
             <v-select
               :items="genders"
               label="Gender"></v-select>
             <br>
             <v-menu
               ref="menu"
               v-model="menu"
               :close-on-content-click="false"
               :nudge-right="40"
               lazy
               transition="scale-transition"
               offset-y
               full-width
               min-width="290px"
             >
               <template v-slot:activator="{ on }">
                 <v-text-field
                   v-model="date"
                   label="Birthday date"
                   prepend-icon="event"
                   readonly
                   v-on="on"
                 ></v-text-field>
               </template>
               <v-date-picker
                 ref="picker"
                 v-model="date"
                 :max="new Date().toISOString().substr(0, 10)"
                 min="1950-01-01"
                 @change="save"
               ></v-date-picker>
             </v-menu>
             <br>
             <v-text-field
               label="Email"
               placeholder="email"
               v-model="email"></v-text-field>
             <br>
             <v-text-field
               label="Confirm Email"
               placeholder="re-enter email"
               v-model="cnf_email"></v-text-field>
             <br>
               <v-text-field
                 :append-icon="show3 ? 'visibility' : 'visibility_off'"
                 :rules="[rules.required, rules.min]"
                 :type="show3 ? 'text' : 'password'"
                 name="input-10-2"
                 label="Password"
                 hint="At least 8 characters"
                 class="input-group--focused"
                 @click:append="show3 = !show3"
               ></v-text-field>
             <br>
             <v-text-field
               :append-icon="show3 ? 'visibility' : 'visibility_off'"
               :rules="[rules.required, rules.min]"
               :type="show3 ? 'text' : 'password'"
               name="input-10-2"
               label="Re-Enter Password"
               hint="At least 8 characters"
               class="input-group--focused"
               @click:append="show3 = !show3"
             ></v-text-field>
             <br>
            <v-btn @click="register" class="cyan">Register</v-btn>
         </div>
        </div>
      </v-flex>
  </v-layout>
</template>

<script>
import AuthenticationService from '@/services/AuthenticationService'
export default {
  data () {
    return {
      fname: '',
      lname: '',
      email: '',
      cnf_email: '',
      password: '',
      error: null,
      genders: ['Male', 'Female'],
      date: null,
      menu: false,
      show1: false,
      show2: true,
      show3: false,
      show4: false,
      rules: {
        required: value => !!value || 'Required.',
        min: v => v.length >= 8 || 'Min 8 characters',
        emailMatch: () => ('The email and password you entered don\'t match')
      }
    }
  },
  methods: {
    register: async function () {
      try {
        const response = await AuthenticationService.register({
          email: this.email,
          password: this.password
        })
        console.log(response.data)
      } catch (error) {
        this.error = error.response.data.error
      }
    },
    save (date) {
      this.$refs.menu.save(date)
    }
  },
  watch: {
    menu (val) {
      val && setTimeout(() => (this.$refs.picker.activePicker = 'YEAR'))
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.error{
    color: red;
}
.registerInput{
  padding: inherit;
}
</style>
