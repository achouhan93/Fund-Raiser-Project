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
               name="first name"
               label="First name"
               placeholder="your first name"
               v-validate="'required'"
               v-model="firstName"></v-text-field>
             <span v-show="errors.has('first name')" class="error--text" >{{ errors.first('first name') }}</span>
             <br>
             <v-text-field
               label="Last name"
               name="last name"
               placeholder="your last name"
               v-validate="'required'"
               v-model="lastName"></v-text-field>
             <span v-show="errors.has('last name')" class="error--text" >{{ errors.first('last name') }}</span>
             <br>
             <v-select
               :items="genders"
               name="gender"
               v-validate="'required'"
               label="Gender"
               v-model="genders"></v-select>
             <span v-show="errors.has('gender')" class="error--text" >{{ errors.first('gender') }}</span>
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
               name="Email"
               ref="Email"
               placeholder="Email"
               v-validate="'required|email'"
               v-model="email"></v-text-field>
             <span v-show="errors.has('Email')" class="error--text" >{{ errors.first('Email') }}</span>
             <br>
             <v-text-field
               label="Confirm Email"
               name="cnfemail"
               data-vv-as="Email"
               placeholder="re-enter email"
               v-validate="'required|email|confirmed:Email'"
               v-model="cnfEmail"></v-text-field>
             <span v-show="errors.has('cnfemail')" class="error--text">{{ errors.first('cnfemail') }}</span>
             <br>
             <v-text-field
               :append-icon="show3 ? 'visibility' : 'visibility_off'"
               :rules="[rules.required, rules.min]"
               :type="show3 ? 'text' : 'password'"
               name="aPassword"
               ref="apwd"
               v-validate="'required'"
               label="Password"
               hint="At least 8 characters"
               class="input-group--focused"
               @click:append="show3 = !show3"
             ></v-text-field>
             <span v-show="errors.has('aPassword')" class="error--text">{{ errors.first('aPassword') }}</span>
             <br>
             <v-text-field
               :append-icon="show3 ? 'visibility' : 'visibility_off'"
               :rules="[rules.required, rules.min]"
               :type="show3 ? 'text' : 'password'"
               name="cnfPassword"
               data-vv-as="Password"
               v-validate="'required|confirmed:apwd'"
               label="Re-Enter Password"
               hint="At least 8 characters"
               class="input-group--focused"
               @click:append="show3 = !show3"
             ></v-text-field>
             <span v-show="errors.has('cnfPassword')" class="error--text">{{ errors.first('cnfPassword') }}</span>
             <br>
             <VuePhoneNumberInput v-model="phNum" />
             <br>
            <v-btn @click="regi1" class="cyan btn-register">Register</v-btn>
         </div>
        </div>
      </v-flex>
  </v-layout>
</template>

<script>
import AuthenticationService from '@/services/AuthenticationService'
import axios from 'axios'
import VueTelInput from 'vue-tel-input'
import VuePhoneNumberInput from 'vue-phone-number-input'

export default {
  components: {
    VueTelInput,
    VuePhoneNumberInput
  },
  data () {
    return {
      firstName: '',
      lastName: '',
      email: '',
      cnfEmail: '',
      password: '',
      error: null,
      phNum: '',
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
        emailMatch: () => ('The email and password you entered dont match')
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
    },
    regi1: function () {
      console.log(this.firstName, this.lastName)
      var currDate = new Date()
      var month = ('0' + (currDate.getMonth() + 1)).slice(-2)
      var date = ('0' + currDate.getDate()).slice(-2)
      var year = currDate.getFullYear()
      var DateToPass = year + '-' + month + '-' + date
      console.log(DateToPass)

      const userBody = {
        'firstName': this.firstName,
        'lastName': this.lastName,
        'emailId': this.email,
        'dob': this.date,
        'gender': this.genders,
        'isActive': true,
        'userType': 'user',
        'phNo': this.phNum,
        'creation_date': DateToPass
      }
      axios.post(`http://localhost:8085/user/registerUser`, userBody
      )
        .then(response => {
        })
        .catch(e => {
          this.errors.push(e)
        })
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
.btn-register{
  color: white;
}
</style>
