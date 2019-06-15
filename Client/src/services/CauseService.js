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
  getCauseByNameAndCategoryId (causeName, categoryId) {
    return axios
      .get('http://localhost:8085/cause/SearchCause?causeName=' + causeName + '&categoryId=' + categoryId)
      .then(response => (this.causes = response.data))
  },
  createCause: async function (causeData) {
    const URL = this.$store.state.API_URL + 'cause/'
    return axios({
      method: 'post',
      url: URL,
      headers: {'authorization': this.$store.state.jwt},
      data: causeData
    })
  },
  updateCause: async function (causeData) {
    const URL = this.$store.state.API_URL + 'cause/'
    return axios({
      method: 'put',
      url: URL,
      headers: {'authorization': this.$store.state.jwt},
      data: causeData
    })
  },
  getAllCategories: async function () {
    return axios
      .get('http://localhost:8085/category/')
      .then(response => (this.category = response.data))
  },
  postDonation: async function (config) {
    const URL = this.$store.state.API_URL + 'donation/'
    return axios({
      method: 'post',
      url: URL,
      headers: {'authorization': this.$store.state.jwt},
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
