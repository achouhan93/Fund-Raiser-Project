import axios from 'axios'
export default {
  getAllCauses: async function () {
    return axios
      .get('http://localhost:8085/cause/getAllActiveCauses')
      .then(response => (this.causes = response.data))
  },
  getCauseById (causeId) {
    return axios
      .get('http://localhost:8085/cause/getCauseById?causeId=' + causeId)
      .then(response => (this.causes = response.data))
  },
  getCauseByNameAndCategoryId (causeName, categoryId) {
    return axios
      .get('http://localhost:8085/cause/SearchCause?causeName=' + causeName + '&categoryId=' + categoryId)
      .then(response => (this.causes = response.data))
  }
}
