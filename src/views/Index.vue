<template>
    <div>
     
     <NavView></NavView>
    
     <div class="card" v-for="(card, index) in cardlist" :key="index">
      <img :src="card.userImage" class="userimg">    
      <p class="cTitle">{{card.userAcc}}</p>
            
     </div>
    </div>
    </template>
    <script>
      import NavView from '@/components/NavView.vue'
      export default {
        name: 'Index',
        components:{
          NavView
        },
        data () {
          return {
            cardlist:[
            { },]
          }
        },
        
        methods: {
          
            loadIndex(){
                
                this.$axios
                    .get('/Index/loadIndex',{

                    })
                    .then(successResponse => {
                        if (successResponse.data !="") {
                            this.cardlist=successResponse.data.userList
                            console.log(this.cardlist.userList)

                        }else {
                           this.$alert('失败')
                        }
                    })
            }
        
          
        },
        created() {
            this.loadIndex();
        },
      }
    </script>
    <meta name="referrer" content="no-referrer"></meta>
    <!-- 使用该策略显示网络图片地址 -->
    <style scoped>
        .box{
          width: 100%;
          height: 180px;
        }
        .card{
            width: 200px;
            height: 200px;
            box-shadow:3px 3px 10px 3px rgb(219, 219, 219);
            border-radius: 10px;
            margin: 10px 10px 10px 10px;
            float: left;
            cursor: pointer;
        }
        .userimg{
          float: left;
          width:200px;
          height: 200px;
          border-radius: 10px;

        }
        .cTitle{
          width: 100%;
          float: left;
          text-align: center;
          /* border:1px solid black; */

        }
    </style>