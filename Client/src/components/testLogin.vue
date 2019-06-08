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
import axios from 'axios'

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
        console.log(user)
        this.signedIn = true
        const userEmail = user.attributes.email
        console.log(userEmail)
        const jwt = user
          .getSignInUserSession()
          .getIdToken()
          .getJwtToken()
        const config = {
          headers: {
            'accessToken': jwt
          },
          params: {
            emailId: userEmail
          }
        }
        axios.get(`http://localhost:8085/user/login`, config
        )
          .then(response => {
          })
          .catch(e => {
            this.errors.push(e)
          })
      } catch (err) {
        this.signedIn = false
      }
    }
  }

}

</script>

<style scoped>

</style>
