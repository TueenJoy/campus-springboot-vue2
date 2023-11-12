<template>
    <div class="top0">
        
     <NavView></NavView>
     <div class="top">
     <Leftmenu class="leftt"></Leftmenu>
     <br>
     <div class="manageList">
        
      <div class="lef-block">
        <div class="lef-blocks" v-for="(item, index) in userinfo" :key="index" >

            <p id="lef-title">{{item.signUname}}</p>
            <!-- <p>{{item.signUser}}</p> -->
            
         
         </div>
        </div>
     </div>
    
    </div>
    </div>
    </template>
    <script>
       import NavView from '@/components/NavView.vue'
        import Leftmenu from '@/components/Leftmenu.vue'
        import Actlist from '@/components/Actlist.vue'

      export default {
        name: 'homepage',
        components:{
          NavView,
          Actlist,
          Leftmenu
        },
        data () {
          return {
              userinfo:[]
          }
        },
        created(){
                var recNumber=this.$route.query.regiNumber
                // alert(recNumber)
                //接收传值
                        this.$axios
                        .post('/Home/manageStu/'+recNumber,{

                        })
                        .then(successResponse => {
                            if (successResponse.data !=null) {
                                // this.$alert(successResponse.data)
                                this.userinfo=successResponse.data
                            
                            }else {
                            this.$alert('失败！')
                            }
                        })
                        .catch(failResponse => {
                            this.$alert(failResponse.response)
                        })

            },

        methods: {
           
      }
    }
    </script>
    <style scoped>
      .manageList{
        width: 800px;
        float: left;
        border: 1px solid black;
      }
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

          /* background-color: rgb(168, 168, 168); */
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
      
    

    .lef_block{
        float: left;
        width: 800px;
        height: 400px;
        background-color: rgb(240, 240, 240);
       
        
      
    }
    /* 
      */
    .lef-blocks{
      width:100%;
        height:20px;
      background-color: white;
      border: 1px solid black;
      
    }
  
   #lef-img{
        width: 220px;
        height: 150px;
        float: left;
    }
    #lef-title{
        /* background-color: red; */
        width:100%;
        font-size: 18px;
    }
    #lef-content{
      float: left;
      /* background-color: greenyellow; */
      /* 超出2行 省略 */
      display: -webkit-box;
      -webkit-box-orient: vertical;
      -webkit-line-clamp: 2;
      overflow: hidden;
      width: 500px;
      color: rgb(201, 201, 201);
    }
    #lef-date{
      float: left;
      width: 100px;
      /* background-color: aquamarine; */
    }
    #lef-nums{
      float: left;
      width: 100px;
    }
    #lef-button{
      float:left;
      width: 100px;
    }
    </style>

