<template>
  <div>
    <div v-if="!this.$store.state.signedIn">
    <amplify-authenticator></amplify-authenticator>
    </div>
    <div v-if="this.$store.state.signedIn">
    <amplify-sign-out></amplify-sign-out>
    </div>
  </div>
</template>

<script>
import { Auth } from 'aws-amplify'
/* import { AmplifyEventBus } from 'aws-amplify-vue' */
import Stores from '@/store.js'
import LoginLogoutService from '../services/LoginLogoutService'

export default {
  name: 'testLogin',
  data () {
    return {
      signedIn: this.$store.state.signedIn
    }
  },
  created () {
    this.findUser()
    /*    AmplifyEventBus.$on('authState', info => {
      if (info === 'signedIn') {
        this.findUser()
      } else {
        this.signedIn = false
        this.$store.state.signedIn = false
      }
    }) */
  },
  methods: {
    async findUser () {
      try {
        const user = await Auth.currentAuthenticatedUser()
        console.log(user)
        /* this.signedIn = true
        this.$store.state.signedIn = true */
        Stores.state.signedIn = true
        const userEmail = user.attributes.email
        const jwt = user
          .getSignInUserSession()
          .getIdToken()
          .getJwtToken()
        Stores.state.jwt = jwt
        const res = await LoginLogoutService.getLogin(jwt, userEmail)
          .then(this.navigateTo('home'))
          .catch(e => {
            this.errors.push(e)
          })
        console.log(res)
      } catch (err) {
        this.signedIn = false
      }
    },
    navigateTo (route) {
      this.$router.push(route)
    }
  }

}

</script>

<style scoped>

</style>
