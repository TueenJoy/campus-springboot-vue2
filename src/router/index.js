import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import Home from '../views/Home.vue'
import Register from '../views/Register.vue'
import Change from '../views/Change.vue'
import Misspwd from '../views/Misspwd.vue'
import Newpwd from '../views/newPwd.vue'
import Index from '../views/Index.vue'
import Admin from '../views/admin/Admin.vue'
import Actadd from '../views/Actadd.vue'
import Detailpage from '../views/detail/Detailpage.vue'
import ManageAct from '../views/manage/ManageAct.vue'
import ManageStu from '../views/manage/ManageStu.vue'
import News from '../views/News.vue'
import userCenter from '../views/userCenter.vue'
import newsDetail from '../views/detail/newsDetail.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect:'/login',
    meta:{auth:true}
  },
  
  {
    path: '/login',
    component: Login,
    meta:{auth:true}
  },
  {
    path:'/News',
    component:News
  },
  {
    path:'/home',
    component:Home
  },
  {
    path:'/register',
    component:Register,
    meta:{auth:true}
  },
  {
    path:'/change',
    component:Change
  },
  {
    path:'/misspwd',
    component:Misspwd,
    meta:{auth:true}
  },
  {
    path:'/newpwd',
    component:Newpwd
  },
  {
    path:'/index',
    component:Index
  },
  {
      path:'/admin',
      component:Admin
  },
  {
    path:'/Actadd',
    component:Actadd
  },
  {
    path:'/Detailpage',
    component:Detailpage
  },
  {
    path:'/ManageAct',
    component:ManageAct
  },
  {
    path:'/ManageStu',
    component:ManageStu
  },{
    path:'/userCenter',
    component:userCenter
  },{
    path:'/newsDetail',
    component:newsDetail
  }
 
 
  
]

const router = new VueRouter({
  routes
})

export default router
