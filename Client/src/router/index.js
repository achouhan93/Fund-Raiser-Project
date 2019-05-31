import Vue from 'vue'
import Router from 'vue-router'
import Register from '@/components/Register'
import Login from '@/components/Login'
import Home from '@/components/Home'
import CreateCause from '@/components/CreateCause'
import CauseDetails from '@/components/CauseDetails'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/register',
      name: 'register',
      component: Register
    },
    {
      path: '/createcause',
      name: 'createcause',
      component: CreateCause
    },
    {
      path: '/cause_details/:causeId',
      name: 'cause_details',
      component: CauseDetails
    }
  ]
})
