
export default {
  getAllCauses: async function () {
    var url = 'http://localhost:8085/cause/getAllActiveCauses'
    var res = ' '
    var data = ' '
    fetch(url)
      .then(res => res.json())
      .then(data => console.log(data))
    console.log(res)

    return data
  }
}
