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
Vue.http.options.root = 'http://127.0.0.1:8090/user/';
Vue.http.options.emulateJSON=true;
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})


