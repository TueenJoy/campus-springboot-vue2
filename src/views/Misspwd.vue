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
        <p id="p_formTitle">找回密码</p>
        <el-form-item label="账号" prop="userAcc">
           <el-input class="elInput" v-model="form.userAcc" placeholder="账号"></el-input>
         </el-form-item>
         <el-form-item label="手机号">
           <el-input class="elInput2" v-model="form.userMobile" placeholder="请输入手机号"></el-input>
         </el-form-item>
         <el-form-item label="验证码">
           <el-input class="elInput3" v-model="form.nums" placeholder="请输入验证码"></el-input>
           <el-button type="default" @click="getNums" class="elBtn">获取验证码</el-button>
         </el-form-item>
        <el-dialog title="验证正确，请重置密码" :visible.sync="dialogFormVisible">
          <el-form-item label="新密码" prop="newWord1">
           <el-input class="elInput3" v-model="form.newWord1" placeholder="新密码"></el-input>
         </el-form-item>
         <el-form-item label="重复密码" prop="newWord2">
           <el-input class="elInput3" v-model="form.newWord2" placeholder="重复密码"></el-input>
         </el-form-item>
          <div slot="footer" class="dialog-footer">
            <el-button type="primary" @click="missPwdSave">重置</el-button>
          </div>
        </el-dialog>
        <el-form-item>
          <el-button type="primary" @click="missPwd">提交验证</el-button>
          <el-button type="default" @click="back">返回</el-button>
        </el-form-item>
      </el-form>
     </div>
    </div>
  
    </div>
    </template>
    <script>
      import NavView from '@/components/NavView.vue'
      export default {
        name: 'Login',
        components:{
          NavView
        },
        data () {
          return {
              dialogFormVisible: false,
              form: {
                
              },
                rules: {
                userAcc: [{required: true, message: '请输入账号', trigger: 'blur'}],
                newWord1: [{required: true, message: '请输入新密码', trigger: 'blur'}],
                newWord2: [{required: true, message: '请输入重复密码', trigger: 'blur'}],
              },
               formLabelWidth: '120px'
          }
        },
        methods: {  
          getNums(){
            this.$axios
            .post('/Login/Misspwd',{
                userAcc: this.form.userAcc,
                userMobile: this.form.userMobile
              })
              .then(successResponse => {
                if (successResponse.data != "") {
                        this.$axios
                    .post('/Login/Misspwd-submit',{
                        userMobile: this.form.userMobile
                    })
                    .then(successResponse => {
                      if (successResponse.data != "") {
                          // this.$alert(successResponse.data[0].nums+","+successResponse.data[0].userMobile)
                          console.log(successResponse.data)
                          this.$alert("验证码已发送")

                         
                      }else {
                        this.$alert('请检查账号或手机号是否有误！')
                        
                      }
                    })
                }else {
                  this.$alert('请检查账号或手机号是否有误！')
                  
                }
              })
          },
          missPwd(){
            this.$axios
            .post('/Login/Misspwd-submit-nums',{
                nums: this.form.nums,
                
              })
              .then(successResponse => {
                console.log(successResponse.data)
                if (successResponse.data ==0) {

                    this.dialogFormVisible=true
                    
                }else if(successResponse.data ==1){
                  this.$alert('验证码错误！')
                  
                }else{
                  this.$alert('请获取验证码！')
                }
                
              })
          },
          missPwdSave(){
            if(this.form.newWord1==this.form.newWord2&&this.form.newWord1!=null){
                this.$axios
                .post('/Login/Misspwd-submit-save',{
                    userPassword:this.form.newWord1,
                  })
                  .then(successResponse => {
                    console.log(successResponse.data)
                    if (successResponse.data ==1) {
                        this.$alert("密码修改成功！")
                        
                    }else{
                      this.$alert('密码修改失败！')
                      
                    }
                    
                  })
                 }else{
                    this.$alert("请正确填写密码！")
                 }
          },
          back(){
            this.$router.go(-1)
          },
          
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
    .elForm{
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
    .elInput2{
        width: 250px;
    }
    .elInput3{
        width: 130px;
    }
    
    .elBtn{
      width: 120px;
      
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