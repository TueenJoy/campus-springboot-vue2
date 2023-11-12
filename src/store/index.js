import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
 
    isLogin:window.sessionStorage.getItem('user') == null ? '0' : window.sessionStorage.getItem('user')

  },
  getters: {
  },
  mutations: {
    changeLogin(state, data) {
      
      state.isLogin= data;
      window.sessionStorage.setItem('user', data)
      
    }
  },
  actions: {
  },
  modules: {
  },
  
})
