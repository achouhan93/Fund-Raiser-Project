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
import { AmplifyEventBus } from 'aws-amplify-vue'
import Stores from '@/store.js'
import LoginLogoutService from '../services/LoginLogoutService'

export default {
  name: 'testLogin',
  created () {
    this.findUser()
    AmplifyEventBus.$on('authState', info => {
      if (info === 'signedIn') {
        this.findUser()
      } else {
        this.$store.state.signedIn = false
      }
    })
  },
  methods: {
    async findUser () {
      try {
        const user = await Auth.currentAuthenticatedUser()
        Stores.state.signedIn = true
        Stores.state.user = user.attributes
        const userEmail = user.attributes.email
        const jwt = user
          .getSignInUserSession()
          .getIdToken()
          .getJwtToken()
        Stores.state.jwt = jwt
        await LoginLogoutService.getLogin(jwt, userEmail)
          .then(this.navigateTo({name: 'home'}))
          .catch(e => {
            this.errors.push(e)
          })
      } catch (err) {
        this.signedIn = false
        this.$store.state.signedIn = false
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
