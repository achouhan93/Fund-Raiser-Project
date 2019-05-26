import Api from '@/services/Api'

export default {
  getAllCauses () {
    return Api().get('causes')
  }
}
