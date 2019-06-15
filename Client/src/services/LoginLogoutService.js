import axios from 'axios'

export default {
  getLogin: async function (userToken, emailId) {
    console.log('Inside getLogin')
    const URL = this.$store.state.API_URL + 'user/login'
    return axios({
      method: 'post',
      url: URL,
      params: {'emailId': emailId},
      headers: {'authorization': userToken}
    })
  },
  getLogout: async function (userToken) {
    const URL = this.$store.state.API_URL + 'user/logout'
    return axios({
      method: 'delete',
      url: URL,
      headers: {'authorization': userToken}
    }).then(
      this.$store.state.jwt = null
    )
  },
  getIsAdmin: async function (userToken) {
    const URL = this.$store.state.API_URL + 'user/'
    return axios({
      method: 'get',
      url: URL,
      headers: {'authorization': userToken}
    })
  }
}
