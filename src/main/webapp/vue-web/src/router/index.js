import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import User from  '../components/User'
import form from '../components/form'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: HelloWorld
    },
    {
      path: '/user',
      component: User
    },
    {
      path: '/form',
      component: form
    }
  ]
})
