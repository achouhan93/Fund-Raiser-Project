import axios from 'axios'
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
  creatingCause: async function (userJwt, causeData) {
    const URL = 'http://localhost:8085/cause/'
    return axios({
      method: 'post',
      url: URL,
      headers: {'authorization': userJwt},
      data: causeData
    })
  },
  updatingCause: async function (userJwt, causeData) {
    const URL = 'http://localhost:8085/cause/'
    return axios({
      method: 'put',
      url: URL,
      headers: {'authorization': userJwt},
      data: causeData
    })
  },
  getAllCategories: async function () {
    return axios
      .get('http://localhost:8085/category/')
      .then(response => (this.category = response.data))
  },
  postDonation: async function (userJwt, config) {
    const URL = 'http://localhost:8085/donation/'
    return axios({
      method: 'post',
      url: URL,
      headers: {'authorization': userJwt},
      data: config
    })
  },
  /* searchCauseByNameAndId: async function (causeName, categoryId) {
    console.log('causename and categ ' + causeName + categoryId)
    var catId = 0
    switch (categoryId) {
      case 'Education Help' : catId = 3
        break
      case 'Medical Cause' : catId = 2
        break
      case 'Natural Disaster' : catId = 1
        break
    }
    return axios
      .get('localhost:8085/cause/searchCause?searchString=' + causeName + '&categoryId=' + catId)
      .then(response => (this.causes = response.data))
  } */
  searchCauseByNameAndId: async function (causeName, categoryId) {
    // console.log('causename and categ ' + causeName + categoryId)
    var catId = 0
    switch (categoryId) {
      case 'Education Help' : catId = 3
        break
      case 'Medical Cause' : catId = 2
        break
      case 'Natural Disaster' : catId = 1
        break
    }

    const URL = this.$store.state.API_URL + 'cause/searchCause'
    return axios({
      method: 'get',
      url: URL,
      params: { 'categoryId': catId, 'searchString': causeName }
    })
  }
}
