import axios from 'axios'
import Stores from '@/store.js'

export default {
  getLogin: async function (userToken, emailId) {
    const URL = Stores.state.API_URL + '/user/login'
    return axios({
      method: 'post',
      url: URL,
      params: {'emailId': emailId},
      headers: {'authorization': userToken}
    })
  },
  getLogout: async function (userToken) {
    const URL = Stores.state.API_URL + '/user/logout'
    axios({
      method: 'delete',
      url: URL,
      headers: {'authorization': userToken}
    }).then(
      Stores.state.jwt = null,
      this.navigateTo({ name: 'home' }))
  }
}
