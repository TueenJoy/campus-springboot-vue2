<template>
    <div class="top0">
     <NavView></NavView>
      <div class="top">
         
     
      <div class="background">
        <!-- 登录表单 -->
        <div class="headlogo">
          <img src="@/image/logo3.png" alt="">
        </div>
        <el-form class="elForm" ref="form" :model="form" :rules="rules" label-width="80px" method="post">
        <p id="p_formTitle">登录</p>
         <el-form-item label="账号" prop="userAcc">
           <el-input class="elInput" v-model="form.userAcc" id="input1" placeholder="请输入账号"></el-input>
           <!-- type=password 方便触发浏览器密码管理 -->
         </el-form-item>
         <el-form-item label="密码" prop="userPassword">
           <el-input class="elInput" type="password" v-model="form.userPassword" id="input2" placeholder="请输入密码"></el-input>
         </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="loginPost" id="login">登录</el-button>
          <el-button type="default" @click="routelink">注册</el-button>
          <router-link to="/Misspwd" id="missPwd">忘记密码</router-link>
        </el-form-item>
      </el-form>
     </div>
    </div>
    </div>
    </template>
    <script>
      import NavView from '@/components/NavView.vue'
      import jsCookie from 'js-cookie';
    
      export default {
        name: 'Login',
        components:{
          NavView
        },
        data () {
          return {
              form: {
              },
              rules: {
              userAcc: [{required: false, message: '请输入用户名', trigger: 'blur'}],
              userPassword: [{required: false, message: '请输入密码', trigger: 'blur'}]
        },
          }
        },
        methods: {  
        
          routelink(){
              this.$router.push('/Register')
          },
          loginPost(){
            // this.$alert(this.form.userAcc+','+this.form.userPassword)
            this.$axios
            .post(
              '/Login/LoginMapper',
              {
                userAcc: this.form.userAcc,
                userPassword: this.form.userPassword
              })
              .then(successResponse => {
                if (successResponse.status==200) {
                  //Message Box
                  if(successResponse.data.status="200"){
                    
                    this.$alert('登录成功，欢迎用户：'+successResponse.data.data)
                    jsCookie.set('userName',successResponse.data.userName)
                    jsCookie.set('userAcc',successResponse.data.userAcc)    


                  }
                  // 旧用户名存储方式 现在用来判断是否登录，不用在显示用户名上
                  this.$store.commit('changeLogin',successResponse.data.userName)
                  
                  let path = this.$route.query.redirect
                  this.$router.push({path: path === '/' || path === undefined ? '/News': path})

                }else {
                  this.$alert('用户名或密码错误！')
                  
                }
              })
              .catch(failResponse => {
                this.$alert(failResponse.response)
              })
            
          }
        }
      }
    </script>
    <style scoped>
    .top{
      background: url('../image/img29.jpg')center center no-repeat;
      /* border: 1px solid black; */
      height: 100vh;
      width: 100%;
      float: left;
    }
   .background{
    width: 400px;
          height: 600px;
          margin: 100px auto;
          background-color: white;
          border-radius: 10px;
   }
   #missPwd{
     margin-left: 10px;
   }
   
   
    .elForm{
      /* background-color: white; */
      float: left;
      width: 400px;
      height: auto;
      margin: 50px auto;
      /* border: 1px solid black; */
      border-radius: 10px;
      
    }
    .elInput{
        width: 250px;
        
    }
    #p_formTitle{
        color:black;
       
        width: 400px;
        line-height: 50px;
        text-align: center;
        font-size: 26px;
        font-weight: lighter;
    }
    .headlogo{
      width: 100%;
      float: left;
      height: 150px;
      /* border: 1px solid black; */
      
      text-align: center;
    }
    .headlogo img{
      margin: 30px auto;
      height: 100px;
      width: 150px;
    }
    </style>