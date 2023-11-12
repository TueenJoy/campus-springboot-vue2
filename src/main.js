import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
Vue.config.productionTip = false
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'default-passive-events'
Vue.prototype.$axios=axios

axios.defaults.baseURL  = 'http://127.0.0.1:8089'

Vue.use(ElementUI)
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
//拦截
router.beforeEach((to,from,next)=>{
  //如果路由器需要验证
  if(!to.matched.some(m=>m.meta.auth)){
    //对路由进行验证
    if (store.state.isLogin == '0') {
      
      // 未登录则跳转到登陆界面，query:{ redirect: to.fullPath}表示把当前路由信息传递过去方便登录后跳转回来；
      next({
        path: 'login',
        query: {redirect: to.fullPath}
      })
    } else { // 已经登陆
      next() //正常跳转到设置好的页面
    }
  }else{
    next()
  }
}
)