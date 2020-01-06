import '@fortawesome/fontawesome-free/css/all.min.css'
import 'bootstrap-css-only/css/bootstrap.min.css'
import 'mdbvue/lib/css/mdb.min.css'
import Vue from 'vue'
import App from './App.vue'
import {router} from "./routes/route"
import axios from '.axios' //이렇게 작성하면  Vue 인스턴스 내부에서는 axios를 따로 improt하지 않아도 this.$axios를 이용해서 사용할 수 있다
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
