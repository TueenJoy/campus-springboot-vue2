<template>
    <div>
   
     <NavView></NavView>
    
    
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
            cardlist:[
            { },]
          }
        },
        
        methods: {
          
            loadIndex(){
                
                this.$axios
                    .get('/loadIndex',{

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
        
    </style>