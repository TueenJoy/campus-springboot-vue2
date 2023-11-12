<template>
    <div class="Navview">
      <div class="logo">
         <img src="@/image/logo3.png" alt="">
         <p id="navReturn" @click="goReturn">校园汇 | 校园资讯智能汇总平台</p>
         <div class="userPart"><div id="uname" @click="goUserCenter">{{showUserName}}</div>
      </div>
      </div>
      
    </div>
  </template>
  
  <script>
  import jsCookie from 'js-cookie';
  export default {
    name: 'Navview',
    props: {
      msg: ''
    },
    methods:{
          goUserCenter(){
               if(this.$route.path!='/userCenter'){
                    this.$router.push('/userCenter')
               }
               
          },
          goReturn(){
               if(this.$route.path!='/home'){
                    this.$router.push('/home')
               }   
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

  }
  </script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped lang="scss">
     
     .Navview{
          background-color: white;
          width: 100%;
     }
     .userPart{
          float: right;
          height: 80px;
       
          width: 120px;
          // border: 1px solid black;
          line-height: 80px;
          
          color: rgb(90, 90, 90);
          font-size: 13px;
          font-weight: lighter;
     }
     #navReturn{
          cursor: pointer;
     }
     #uname{
          
          width: 120px;
          float: left;
          transition: all 0.2s linear;
          text-align: center;
          font-size: 14px;
          cursor: pointer;
     }
     #uname:hover{
          
          background-color: #9dd8ff;
          color: white;
          transition-property: all;
          
          transition: all 0.2s linear;

     }
  
     
     .logo{
          width: 100%;
          height:80px;
          // float: left;
         
     }
     .logo img{
          width: 70px;
          height:50px;
          padding:15px 10px;
          // border: 1px solid black;
          float: left;
     }
     .logo p{
          font-size: 18px;
          font-weight: lighter;
          line-height: 80px;
          float: left;
          margin-left: 10px;
          vertical-align: middle;
     }
  </style>
  