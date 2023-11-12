<template>
    <div class="top0">
     <NavView></NavView>
     <div class="top">
     <Leftmenu class="leftt"></Leftmenu>
      <div class="Login">
        个人中心
        <p>{{showUserName}}</p>
        <br/>
        <el-button type="default" @click="reLogin">退出登录</el-button>
        <el-button type="default" @click="changeUser">修改个人资料</el-button>
        <el-button type="default" @click="newPwd">修改密码</el-button>
        <el-button @click="manageAct"  id="doact-button">管理已发布活动</el-button>
     <el-button @click="doShowMyAct"  id="doact-button">查看我的报名</el-button>
        <router-link>连接</router-link>
      </div>
    </div>
    </div>
    </template>
    <script>
       import NavView from '@/components/NavView.vue'
        import Leftmenu from '@/components/Leftmenu.vue'
        import jsCookie from 'js-cookie';
      export default {
        name: 'Login',
        components:{
          NavView,
          Leftmenu
        },
        data () {
          return {
              userToken:{
                  username:this.$store.state.username
               
              },      

          }
        },
        computed:{
            showUserName(){
              // 对当前的cookie登录状态非空判断防止报错
                if(jsCookie.get('userName')!=null){
                  return jsCookie.get('userName')
                }
                
            }
        },
        methods: {
          doAddact(){
            this.$router.push('/Actadd')
          },
          
          manageAct(){
            
            this.$router.push('/ManageAct')       
          },

           
            reLogin(){
                this.$router.push('/Login')
            },
            changeUser(){
              this.$router.push('/Change')
            },
            newPwd(){
              this.$router.push('/newPwd')
            },
            
        },
        created() {
            this.getUsersList();
        },
      }
    </script>
    <style scoped>
   
        .leftt{
            
            height: 700px;
            width:300px;
            float: left;

        }
        .top0{
          position: relative;
          width: 100%;
          height: 780px;
          /* background-color: bisque; */
          
        }
        
        /* 次上层父元素 */
        .top{

          /* background-color: #fff; */
          margin-top: 80px;
          width: 1200px;
          height: 100%;
          /* border: 1px solid black; */
          position: absolute;  
          /* 父相子绝 */
          left: 50%;
          top: 50%;
          transform: translate(-50%,-50%);
        }
    </style>