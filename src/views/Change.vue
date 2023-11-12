<template>
    <div class="head">
     <NavView></NavView>
      <div class="Login">
        <el-form class="elForm" ref="form" :model="form" :rules="rules" label-width="80px" method="post">
        <p id="p_formTitle">修改个人信息</p>
        <el-form-item label="账号" prop="userAcc">
           <!-- <el-input class="elInput" v-model="form.userAcc" placeholder="账号"></el-input> -->
           <p>{{getUserAcc}}</p>
         </el-form-item>
         <el-form-item label="用户名">
           <el-input class="elInput" v-model="form.userName" placeholder="请输入用户名"></el-input>
         </el-form-item>
         <el-form-item label="年龄">
           <el-input class="elInput" v-model="form.userAge" placeholder="请输入年龄"></el-input>
         </el-form-item>
         <el-form-item label="性别">
           <el-input class="elInput" v-model="form.userGender" placeholder="请输入性别"></el-input>
         </el-form-item>
         <el-form-item label="手机号">
           <el-input class="elInput" v-model="form.userMobile" placeholder="请输入手机号"></el-input>
         </el-form-item>
         <el-form-item label="邮箱">
           <el-input class="elInput" v-model="form.userEmail" placeholder="请输入邮箱"></el-input>
         </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="save">保存</el-button>
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
                // userAcc: [{
                //   required: true, message: '请输入账号', trigger: 'blur'}],
              },
          }
        },
        computed:{
            getUserAcc(){
                this.form.userAcc=jsCookie.get('userAcc')
                return jsCookie.get('userAcc')
            }
        },
        methods: {  
          back(){
            this.$router.go(-1)
          },
            save(){
             
                    this.$axios
                    .post('/Login/Change',{
                        userAcc:this.form.userAcc,
                        userName: this.form.userName,
                        userAge: this.form.userAge,
                        userGender:this.form.userGender,
                        userMobile:this.form.userMobile,
                        userEmail:this.form.userEmail
                    })
                    .then(successResponse => {
                        if (successResponse.data =="1") {
                            this.$alert('保存成功！')
                            jsCookie.set('userName',this.form.userName)
                        this.$router.push('/Home')
                        }else {
                        this.$alert('保存失败！请检查账号是否正确')
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