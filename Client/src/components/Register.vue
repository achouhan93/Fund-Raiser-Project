/* eslint-disable */
<template>
  <v-layout aria-rowcount="center">
      <v-flex xs6 offset-xs3>
        <div class="white elevation-2">
           <v-toolbar flat dense class="cyan" dark>
             <v-toolbar-title>Register</v-toolbar-title>
           </v-toolbar>
           <div class="pl-4 pr-4 pb-2 pt-2">
               <v-text-field
               label="Email"
               placeholder="email"
               v-model="email"/>
             <br>
               <v-text-field
               label="Password"
               placeholder="password"
               v-model="passowrd"/>
            <br>
            <div class="error" v-html="error"/>
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
      email: '',
      passowrd: '',
      error: null
    }
  },
  methods: {
    async register () {
      try {
        const response = await AuthenticationService.register({
          email: this.email,
          password: this.password
        })
        console.log(response.data)
      } catch (error) {
        this.error = error.response.data.error
      }
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
