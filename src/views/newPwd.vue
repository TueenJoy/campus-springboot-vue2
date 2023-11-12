<template>
    <div class="head">
     <NavView></NavView>
      <div class="Login">
        <el-form class="elForm" ref="form" :model="form" :rules="rules" label-width="80px" method="post">
        <p id="p_formTitle">修改密码</p>
        <!-- <el-form-item label="账号" prop="userAcc">
           <el-input class="elInput" v-model="form.userAcc" placeholder="账号"></el-input>
         </el-form-item> -->
         <el-form-item label="旧密码">
           <el-input class="elInput" v-model="form.userPassword" placeholder="请输入旧密码"></el-input>
         </el-form-item>
         <el-form-item label="新密码">
           <el-input class="elInput" v-model="form.userNewPassword" placeholder="请输入新密码"></el-input>
         </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="newPwd">确认修改</el-button>
          <el-button type="default" @click="back">返回</el-button>
        </el-form-item>
      </el-form>
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
                
              },
          }
        },
        methods: {  
          back(){
            this.$router.go(-1)
          },
          newPwd(){
            var userAcc=jsCookie.get('userAcc')
            this.$axios
            .post('/Login/LoginMapper',{
                userAcc:userAcc,
                userPassword: this.form.userPassword
              })
              .then(successResponse => {
                if (successResponse.data != "") {
                  this.$axios
                    .post('/Login/Newpwd',{
                        userAcc:this.form.userAcc,
                        userPassword: this.form.userNewPassword,
                        
                    })
                    .then(successResponse => {
                        if (successResponse.data =="1") {
                            this.$alert('修改密码成功！')

                        }else {
                           this.$alert('修改失败！请检查密码是否正确')
                        }
                    })
                }else {
                  this.$alert('账号或旧密码错误！')
                  
                }
              })

          }
          }
        }
      
    </script>
    <style scoped>
    .Login{
      float: left;
      height: 90vh;
      width:60%;
    }
    .elForm{
      background-color: white;
      width: 400px;
      
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
    </style>