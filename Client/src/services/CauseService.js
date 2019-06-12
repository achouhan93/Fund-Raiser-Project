import axios from 'axios'
import Stores from '@/store.js'
export default {
  getAllCauses: async function () {
    return axios
      .get('http://localhost:8085/cause/')
      .then(response => (this.causes = response.data))
  },
  getCauseById (causeId) {
    return axios
      .get('http://localhost:8085/cause/' + causeId)
      .then(response => (this.causes = response.data))
  },
  getCauseByNameAndCategoryId (causeName, categoryId) {
    return axios
      .get('http://localhost:8085/cause/SearchCause?causeName=' + causeName + '&categoryId=' + categoryId)
      .then(response => (this.causes = response.data))
  },
  createCause: async function (causeData) {
    const URL = Stores.state.API_URL + 'cause/'
    return axios({
      method: 'post',
      url: URL,
      headers: {'authorization': Stores.state.jwt},
      data: causeData
    })
  },
  updateCause: async function (causeData) {
    const URL = Stores.state.API_URL + 'cause/'
    console.log(URL)
    return axios({
      method: 'put',
      url: URL,
      headers: {'authorization': Stores.state.jwt},
      data: causeData
    })
  },
  getAllCategories: async function () {
    return axios
      .get('http://localhost:8085/category/')
      .then(responses => (Stores.state.categories = responses.data))
  },
  postDonation: async function (config) {
    const URL = Stores.state.API_URL + 'donation/'
    console.log(URL)
    return axios({
      method: 'post',
      url: URL,
      headers: {'authorization': Stores.state.jwt},
      data: config
    })
  }
}
