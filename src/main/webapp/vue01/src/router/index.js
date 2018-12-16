import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '../components/HelloWorld'
import Hello from '../components/Hello'
import login from '../components/login'
import register from '../components/register'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/helloWorld',
      component: HelloWorld
    },
    {
      path: '/hello',
      component: Hello,
      children:[
        {path:'login',component:login},
        {path:'register',component:register},
      ]
    }
  ]
})
