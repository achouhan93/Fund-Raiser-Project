import axios from 'axios'
import Stores from '@/store.js'

export default {
  getLogin: async function (userToken, emailId) {
    const URL = Stores.state.API_URL + '/user/login'
    return axios({
      method: 'post',
      url: URL,
      params: {'emailId': emailId},
      headers: {'accessToken': userToken}
    }).then(this.navigateTo({ name: 'home' }))
  }
}
