import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import User from  '../components/User'
import form from '../components/form'
import login from '../components/login'
import center from '../components/center'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/',
      component:login
    },

    {
      path:'/center',
      component:center,
      children:[
        {
          path: 'hello',
          component: HelloWorld
        },
        {
          path: 'user',
          component: User
        },
        {
          path: 'form',
          component: form
        },
        {
          path:'login',
          component:login
        }
      ]
    }
  ]
})
