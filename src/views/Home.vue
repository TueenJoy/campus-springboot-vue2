<template>
    <div class="top0">

     <NavView></NavView>
     <div class="top">
     <Leftmenu class="leftt"></Leftmenu>
    
     <Actlist class="actlist"></Actlist>
     <div class="opera">
        <el-button @click="doAddact" id="doact-button" icon="el-icon-edit-outline"></el-button>
      </div>
    
    </div>
    </div>
    </template>
    <script>
       import NavView from '@/components/NavView.vue'
        import Leftmenu from '@/components/Leftmenu.vue'
        import Actlist from '@/components/Actlist.vue';
        import jsCookie from 'js-cookie';
    
      export default {
        name: 'homepage',
        components:{
          NavView,
          Actlist,
          Leftmenu
          
        },
        data () {
          return {
              userinfo:[{
                regiId:'1',
                regiTitle:'2',
                regiAuthor:'3',
                regiContent:'4', 
                regiStarttime:'5',
                regiOvertime:'6',
                regiDatetime:'7', 
                regiImg:'8',
                regiNumber:'9',
                regiMaxnum:'00',
                regiAlnum:'01',
              }]
          }
        },
        methods: {   
          doAddact(){
            this.$router.push('/Actadd')
          },

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
          float: left;
   
        }
        
        /* 次上层父元素 */
        .top{
          float: left;
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
       
        .actlist{
          width: 850px;
          float: left;
          
        }
        .opera{
          /* border: 1px solid black; */
         width: 60px;
         height:60px;
         position:fixed;
          
         left: 1200px;
         top: 700px ;
        }
        #doact-button{
          color: white;
          background-color: #039aff;
          width: 60px;
          height: 60px;
          float: left;
          
        }
      
        
    </style>