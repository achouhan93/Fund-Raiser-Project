import Api from '@/services/Api'
export default {
  getAllCauses: async function () {
    var url = 'http://localhost:8085/cause/getAllActiveCauses'
    var data = ' '
    var res = ' '
    fetch(url)
      .then(res => res.json())
      .then(data => console.log(data))
    console.log('res' + res)
    return data
  },
  getCauseById (causeId) {
    // eslint-disable-next-line no-template-curly-in-string
    return Api().get('cause/getCauseById?causeId=' + causeId)
  }
}
