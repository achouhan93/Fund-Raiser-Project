<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-toolbar fixed class="cyan">
    <v-toolbar-title class="mr-4">
          <span @click="navigateTo({name: 'home' })" class="home"> Fund Raiser
          </span>
    </v-toolbar-title>
    <v-toolbar-items>
      <v-btn flat dark @click="navigateTo({name: 'createcause' })"> Create Cause </v-btn>
    </v-toolbar-items>
    <v-spacer></v-spacer>
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
// import { AmplifyEventBus } from 'aws-amplify-vue'

export default {
  data () {
    return {
      items: [
        { title: 'Dashboard' },
        { title: 'Sign out' }
      ]
    }
  },
  methods: {
    navigateTo (route) {
      this.$router.push(route)
    },
    performAction (titleSelected) {
      if (titleSelected === 'Dashboard') {
        console.log(titleSelected)
      } else if (titleSelected === 'Sign out') {
        Auth.signOut()
          .then(data => {
            this.$store.state.signedIn = !!data
          })
          .catch(err => console.log(err))
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
