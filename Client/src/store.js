
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: null,
    signedIn: false,
    causeId: 0,
    causeData: [],
    API_URL: 'http://localhost:8085/',
    jwt: null

  },
  mutations: {

  },
  actions: {

  }
})
