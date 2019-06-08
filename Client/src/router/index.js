import Vue from 'vue'
import Router from 'vue-router'
import Register from '@/components/Register'
import Login from '@/components/Login'
import Home from '@/components/Home'
import CreateCause from '@/components/CreateCause'
import CauseDetails from '@/components/CauseDetails'
import UserHome from '@/components/UserHome'
import testLogin from '@/components/testLogin'
import Dashboard from '@/components/Dashboard'
import UpdateCause from '@/components/UpdateCause'

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
    },
    {
      path: '/user_home/',
      name: 'user_home',
      component: UserHome
    },
    {
      path: '/testLogin',
      name: 'testLogin',
      component: testLogin
    },
    {
      path: '/dashboard',
      name: 'dashboard',
      component: Dashboard
    },
    {
      path: '/updateCause',
      name: 'updateCause',
      component: UpdateCause
    }
  ]
})
