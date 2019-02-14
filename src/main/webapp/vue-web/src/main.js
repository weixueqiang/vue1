// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUi from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
import VueReource from 'vue-resource'
import  test from './js/test.js'


Vue.use(ElementUi)
Vue.use(VueReource)

Vue.config.productionTip = false
// Vue.http.options.root = 'http://127.0.0.1:8090/user/';
//Vue.http.options.root = 'http://192.168.99.54:8090/user/';
Vue.http.options.emulateJSON=true;
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

Vue.http.interceptors.push((request, next) => {
  console.log(this)//此处this为请求所在页面的Vue实例
  // modify request
  // request.method = 'POST';//在请求之前可以进行一些预处理和配置

  // continue to next interceptor

  next((response) => {//在响应之后传给then之前对response进行修改和逻辑判断。对于token时候已过期的判断，就添加在此处，页面中任何一次http请求都会先调用此处方法
    console.log('response...'+JSON.stringify(response))

    if(response.body.code==401){
      router.push({
        path:'/'
      })
    }


    return response;

  });
});


