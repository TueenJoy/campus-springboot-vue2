<template>
    <div class="top0">
        
     <NavView></NavView>
     <div class="top">
     <Leftmenu class="leftt"></Leftmenu>
     <br>
     <div class="manageList">
        
      <div class="lef-block">
        <div class="lef-blocks" v-for="(item, index) in userinfo" :key="index" >

          <img id="lef-img" :src="item.regiImg">
            <p id="lef-title">{{item.regiTitle }}</p>
            <p id="lef-content">{{item.regiContent }}</p>
            <p id="lef-date">{{item.regiStarttime }}</p>
            <p id="lef-nums">{{item.regiNumber }}</p>
            
            <el-button id="lef-button" @click="doShow(item.regiNumber,$event)">查看已报名</el-button>
            <el-button id="lef-button" @click="doUpdate">修改</el-button>
            <el-button id="lef-button" @click="doDel">删除</el-button>
            

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
        import jsCookie from 'js-cookie'
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
          this.manageAct();
        },
        methods: {
            doShow(e){
              this.$router.push({
                  path:'ManageStu',
                  query:{
                    regiNumber:e
                  }

                })
            },
            doUpdate(){

            },
            doDel(){

            },
            manageAct(){
                
            console.log('初始数据',this.userinfo)
            this.userAcc=jsCookie.get('userAcc')
            console.log(this.userAcc)
            
            this.$axios
                    .post('/Home/record/'+this.userAcc,{
                    })
                    .then(async successResponse => {
                        if (successResponse.data !='') {
                            console.log('recNumber:'+successResponse.data[0].recNumber)
                           for(let i=0;i<successResponse.data.length;i++){
                            this.rexNumber=successResponse.data[i].recNumber
                            console.log(i+' - '+this.rexNumber)
                            await this.$axios
                                .post('/Home/record2/'+this.rexNumber,{

                                })
                                .then(async successResponse => {
                                    if (successResponse.data !='') {
                                          this.userinfo.push(successResponse.data[0])
                                          console.log(successResponse.data)
                                          console.log(i,this.userinfo)
                                         
                                    }else {
                                        this.$alert('F')
                                    }
                                })
                                      .catch(failResponse => {
                                       this.$alert(failResponse.response)
                    })
                           }
                        }else {
                            this.$alert(this.rexNumber)
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
        .lef{
      /* background-color: #6666ee; */
      height: 100%;
      
    }

    .lef_block{
        float: left;
        width: 800px;
        height: 400px;
        background-color: rgb(240, 240, 240);
        padding:20px 20px;
        /* border: 1px solid black; */
        overflow-x: hidden;
				overflow-y: scroll;
    }
    /* 
      */
    .lef-blocks{
      width:100%;
        height:150px;
      background-color: white;
      /* border: 1px solid black; */
      margin-top: 10px;
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