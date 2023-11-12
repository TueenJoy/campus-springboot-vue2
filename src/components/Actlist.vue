<template>
    <div>   
      <div class="lef">
        <div class="top_nav">
               <p  id="navP1">推荐</p>
               <p  id="navP2">最新</p>
               
          </div>   
        <div class="lef_block">
          <!-- <el-button @click="showActlist" id="lef-button">报名</el-button> -->
        <div class="lef-blocks" v-for="(item, index) in actlist" :key="index" @click="toregiNumber(item.regiNumber,$event)">
           
              <img id="lef-img" :src="item.regiImg">
            <p id="lef-title">{{item.regiTitle }}</p>
            <p id="lef-content">{{item.regiContent }}</p>
            <p id="lef-date">发布日期：{{item.regiDatetime }}</p>
            <p id="lef-nums">已报名：{{item.regiAlnum }}</p>
            
            <!-- $event带reginumber用于详情页传值 -->
            <!-- <el-button  id="lef-button" >报名</el-button> -->
<!-- v-model="item.regiNumber"
    双向绑定的方式使得每个button都带不同的值传递，用于详情页的regiNumber判断对应的页面内容
-->

         </div>
        </div>
      </div>
     
    </div>
</template>
    <script>
      export default {
        name: 'act',
    
        data () {
          return {
              actlist:[],
              
            }
        },
        components:{
        
        },

        methods: {
            toregiNumber(e){
                this.$router.push({
                  path:'Detailpage',
                  query:{
                    regiNumber:e
                  }

                })
               
                console.log(e)//指向regiNumber
                console.log(this.$route.query)//指向regiNumber
            },
           
          
          showActlist(){
            // this.$alert(this.form.userAcc+','+this.form.userPassword)
            this.$axios
            .post(
              '/Home/showActlist',
              )
              .then(successResponse => {
                if (successResponse.data != "") {
                  this.actlist=successResponse.data.actlist
                  console.log(successResponse.data.actlist)
                  console.log(this.actlist)
                }else {
                  this.$alert('fail')
                  
                }
              })
              .catch(failResponse => {
                this.$alert(failResponse.response)
              })
            
          }
        },
        created(){
          this.showActlist();
        }
      }
    </script>
    <style scoped>
    .lef{
      /* background-color: #6666ee; */
      height: 100%;
      
    }

    .lef_block{
        float: left;
        width: 800px;
        /* height: 400px; */
        border-radius: 10px;
        margin: 0 5px;
        /* border: 1px solid black; */
        /* overflow-x: hidden;
				overflow-y: scroll; */
    }
    /* 
      */
    .lef-blocks{
      width:100%;
        height:150px;
      background-color: white;
      /* border-radius: 10px;
      box-shadow: 10px 10px 10px gray; */
      /* border: 1px solid black; */
      /* margin-top: 10px; */
      cursor: pointer;
      border-bottom: 2px solid rgb(243, 243, 243);
    }
.top_nav{
  background-color: white;
  width: 800px;
  height: 50px;
  margin-top: 10px;
  margin-left: 5px;
  float: left;
}
#navP1{
  float: left;
  height: 40px;
  line-height: 50px;
  color: rgb(3, 154, 255);
  border-bottom: 2px solid rgb(3, 154, 255);
  cursor: pointer;
  margin-left: 10px;
}
#navP2{
  float: left;
  height: 50px;
  line-height: 50px;
  cursor: pointer;
  margin-left: 10px;
}
  .lef-blocks:hover{
    
      background-color: rgb(247, 248, 250);
     
      border-bottom: 2px solid rgb(243, 243, 243);
      transition: 0.2s linear;
    }
   #lef-img{
        width: 200px;
        height: 130px;
        float: left;
        padding: 10px;
    }
    #lef-title{
        /* background-color: red; */
        width:100%;
        font-weight: lighter;
        padding-top: 10px;
        font-size: 18px;
    }
    #lef-content{
      float: left;
      
      display: -webkit-box;
      -webkit-box-orient: vertical;
      -webkit-line-clamp: 2;
      overflow: hidden;
      word-wrap: break-word;
      height: auto;
      
      width: 500px;
      font-weight: lighter;
      
      color: rgb(201, 201, 201);
    }
    #lef-date{
      margin-top: 50px;
      float: left;
      width: 300px;
      font-weight: lighter;
      font-size: 14px;
      color: rgb(132, 133, 134);
      /* background-color: aquamarine; */
    }
    #lef-nums{
      float: left;
      width: 250px;
      margin-top: 50px;
      font-weight: lighter;
      font-size: 14px;
      color: rgb(132, 133, 134);

    }
    #lef-button{
      float:left;
      width: 150px;
      font-weight: lighter;

    }
    
    </style>