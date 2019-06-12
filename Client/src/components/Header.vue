<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-toolbar fixed class="cyan">
    <v-toolbar-title class="mr-4">
          <span @click="navigateTo({name: 'home' })" class="home"> Fund Raiser
          </span>
    </v-toolbar-title>
    <v-toolbar-items v-if = "this.$store.state.signedIn" >
      <v-btn flat dark @click="navigateTo({name: 'createcause' })"> Create Cause </v-btn>
    </v-toolbar-items>
    <v-spacer></v-spacer>
    <v-toolbar-items v-if = "this.$store.state.signedIn" >
      <v-btn flat dark @click="navigateTo({name: 'about' })"> About US </v-btn>
    </v-toolbar-items>
    <v-toolbar-items>
      <v-menu open-on-hover offset-y v-if = "this.$store.state.signedIn" >
        <template v-slot:activator="{ on }">
          <v-btn
            dark
            flat
            v-on="on">
            Username
          </v-btn>
        </template>
        <v-list>
          <v-list-tile
            v-for="(item, index) in items"
            @click="performAction(item.title)"
            :key="index"
          >
            <v-list-tile-title>{{ item.title }}</v-list-tile-title>
          </v-list-tile>
        </v-list>
      </v-menu>
      <v-btn v-if = "!this.$store.state.signedIn" flat dark @click="navigateTo({name: 'testLogin' })">
        Login
      </v-btn>
    </v-toolbar-items>
  </v-toolbar>
</template>

<script>

import { Auth } from 'aws-amplify'
import LoginLogoutService from '../services/LoginLogoutService'
// import { AmplifyEventBus } from 'aws-amplify-vue'

export default {
  data () {
    return {
      items: [
        { title: 'Dashboard' },
        { title: 'Sign out' }
      ],
      isLogOutSuccess: false
    }
  },
  methods: {
    navigateTo (route) {
      this.$router.push(route)
    },
    performAction (titleSelected) {
      if (titleSelected === 'Dashboard') {
        this.navigateTo({ name: 'dashboard' })
      } else if (titleSelected === 'Sign out') {
        Auth.signOut()
          .then(LoginLogoutService.getLogout(this.$store.state.jwt))
        this.redirectToHome()
      }
    },
    redirectToHome () {
      if (this.$store.state.jwt == null) {
        this.$store.state.signedIn = false
        this.navigateTo({ name: 'home' })
      }
    }
  }
}
</script>

<style>
  .home{
    cursor: pointer;
  }
</style>
