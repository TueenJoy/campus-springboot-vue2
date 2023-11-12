<template>
    <div class="top0">

     <NavView></NavView>
     <div class="top">
     <Leftmenu class="leftt"></Leftmenu>
     <br>
     <el-button @click="doAddact" id="doact-button">发布活动</el-button>
     
     <Actlist></Actlist>
    </div>
      <!-- <div class="Login"> -->
        <!-- <el-button type="default" @click="reLogin">返回登录</el-button>
        <el-button type="default" @click="changeUser">修改个人资料</el-button>
        <el-button type="default" @click="newPwd">修改密码</el-button>
        <el-button type="default" @click="goIndex">index</el-button>
        <el-button type="default" @click="infIndex">活动页</el-button> -->
      <!-- </div> -->
    </div>
    </template>
    <script>
       import NavView from '@/components/NavView.vue'
        import Leftmenu from '@/components/Leftmenu.vue'
        import Actlist from '@/components/Actlist.vue';
      export default {
        name: 'homepage',
        components:{
          NavView,
          Actlist,
          Leftmenu
        },
        data () {
          return {
             
             
          }
        },
        
        methods: {
         
          doAddact(){
            this.$router.push('/Actadd')
          }
        },
        
      }
    </script>
    <style scoped>
    
        .leftt{
            
            height: 700px;
            width:300px;
            float: left;

        }

        /* 最上层父元素 */
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