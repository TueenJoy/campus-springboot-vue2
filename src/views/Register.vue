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
        <p id="p_formTitle">注册</p>
         <el-form-item label="账号" prop="userAcc">
           <el-input class="elInput" v-model="form.userAcc" placeholder="请输入账号"></el-input>
         </el-form-item>
         <el-form-item label="密码" prop="userPassword">
           <el-input class="elInput" v-model="form.userPassword" placeholder="请输入密码"></el-input>
         </el-form-item>
         <el-form-item label="用户名" prop="userName">
           <el-input class="elInput" v-model="form.userName" placeholder="请输入用户名"></el-input>
         </el-form-item>
        <el-form-item>
          <el-button type="default" @click="registerPost">注册</el-button>
          <el-button type="default" @click="routerlink">返回</el-button>
        </el-form-item>
      </el-form>
     </div>
    </div>
    </div>
    </template>
    <script>
      import NavView from '@/components/NavView.vue'
      import user from '@/router/loginGlobal.js'
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
              userAcc: [{required: true, message: '请输入账号', trigger: 'blur'}],
              userPassword: [{required: true, message: '请输入密码', trigger: 'blur'}],
              userName: [{required: true, message: '请输入用户名', trigger: 'blur'}],
        },
          }
        },
        methods: {  
          routerlink(){
            this.$router.push('/Login')
          },
          registerPost(){
            // this.$alert(this.form.userAcc+','+this.form.userPassword+','+this.form.userName)
            if(this.form.userAcc!=null&&this.form.userName!=null&&this.form.userPassword!=null){
                this.$axios
                .post('/Login/Register',{
                    userAcc: this.form.userAcc,
                    userPassword: this.form.userPassword,
                    userName:this.form.userName
                 })
                .then(successResponse => {
                   console.log(successResponse.data)
                  if (successResponse.data == "1") {
                    this.$alert('注册成功。')
                    this.$router.push('/Home').catch(err => {})
                  }else {
                    this.$alert('注册失败！用户名已被使用')
                    
                  }
                })
                .catch(failResponse => {
                  this.$alert(failResponse.response)
                })
            }else{
              this.$alert('请填写所有必填项！')
            }
            
            
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
    .elForm{
      float: left;
      width: 340px;
      height: auto;
      margin: 50px 10px;
      /* border: 1px solid black; */
      border-radius: 10px;
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
    </style>