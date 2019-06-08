<template>
  <div>
    <div v-if="!signedIn">
    <amplify-authenticator></amplify-authenticator>
    </div>
    <div v-if="signedIn">
    <amplify-sign-out></amplify-sign-out>
    </div>
    {{signedIn}}
  </div>
</template>

<script>
import { Auth } from 'aws-amplify'
import { AmplifyEventBus } from 'aws-amplify-vue'

export default {
  name: 'testLogin',
  data () {
    return {
      signedIn: false
    }
  },
  created () {
    this.findUser()
    AmplifyEventBus.$on('authState', info => {
      if (info === 'signedIn') {
        this.findUser()
      } else {
        this.signedIn = false
      }
    })
  },
  methods: {
    async findUser () {
      try {
        const user = await Auth.currentAuthenticatedUser()
        this.signedIn = true
        const jwt = user
          .getSignInUserSession()
          .getIdToken()
          .getJwtToken()
        console.log(jwt)
      } catch (err) {
        this.signedIn = false
      }
    }
  }

}

</script>

<style scoped>

</style>
