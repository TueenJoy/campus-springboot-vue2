<template>
    <div>   
      <div class="lef1">
        
        <div class="top_nav1">
            <p id="navP1">校园快讯</p>
        </div>   
        <div class="lef_block1">
          <!-- <el-button @click="showActlist" id="lef-button">报名</el-button> -->
        <div class="lef-blocks1" v-for="(item, index) in type0list" :key="index" @click="toregiNumber(item.listNumber,$event)">    
            <p id="lef-title1">{{item.listTitle }}</p>
            <p id="lef-date1">{{item.listDatetime }}</p> 
        </div>
        </div>
      </div>
      <div class="lef2">
        <div class="top_nav2">
            <p id="navP1">校内热点</p>
        </div>   
        <div class="lef_block2">
          <!-- <el-button @click="showActlist" id="lef-button">报名</el-button> -->
        <div class="lef-blocks2" v-for="(item, index) in type1list" :key="index" @click="toregiNumber(item.listNumber,$event)">    
            <p id="lef-title2">{{item.listTitle }}</p>
            <p id="lef-date2">{{item.listDatetime }}</p>
                
        </div>
        </div>
      </div>
    </div>
</template>
    <script>
      export default {
        name: 'news',
    
        data () {
          return {
            newslist:[],
            type0list:[],
            type1list:[]
            }
        },
        components:{
        
        },

        methods: {
            toregiNumber(e){
                this.$router.push({
                  path:'newsDetail',
                  query:{
                    listNumber:e
                  }

                })
               
                
            },
          showNewslist(){
            // this.$alert(this.form.userAcc+','+this.form.userPassword)
            this.$axios
            .post(
              '/News/showNewslist',
              )
              .then(successResponse => {
                if (successResponse.data != "") {
                  this.newslist=successResponse.data.newslist
                  console.log(successResponse.data.newslist)
                  console.log(this.newslist)
                }else {
                  this.$alert('fail')
                  
                }
              })
              .catch(failResponse => {
                this.$alert(failResponse.response)
              })
            
          },
          showListByType0(){
            //  返回类型为校园快讯的文章
            this.$axios
            .post(
              '/News/showListByType/'+0,{
                
              }
              )
              .then(successResponse => {
                if (successResponse.data != "") {
                  this.type0list=successResponse.data.newslist
                  console.log(successResponse.data.newslist)
                  console.log(this.type0list)
                }else {
                  this.$alert('fail')
                  
                }
              })
              .catch(failResponse => {
                this.$alert(failResponse.response)
              })
            
          },
          showListByType1(){
            //  返回类型为校园快讯的文章
            this.$axios
            .post(
              '/News/showListByType/'+1,{
                
              }
              )
              .then(successResponse => {
                if (successResponse.data != "") {
                  this.type1list=successResponse.data.newslist
                  console.log(successResponse.data.newslist)
                  console.log(this.type1list)
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
          this.showNewslist();
          this.showListByType0();
          this.showListByType1();
        }
      }
    </script>
    <style scoped>
    .lef1{
      /* background-color: #6666ee; */
      height: 100%;
      float: left;
      width: 900px;
    }
    .lef2{
      /* background-color: #4e4e8d; */
      height: 100%;
      float: left;
      width: 900px;
    }
   
.top_nav1{
  background-color: white;
  width: 900px;
  height: 50px;
  margin-top: 10px;
  margin-left: 5px;
  float: left;
}
.top_nav2{
  background-color: white;
  width: 900px;
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
.lef_block1{
        float: left;
        width: 900px;
        
        margin: 0 5px;
        
    }
    /* 
      */
    .lef-blocks1{
      width:900px;
        height:30px;
      background-color: white;
     
      cursor: pointer;
      border-bottom: 2px solid rgb(243, 243, 243);
    }
  .lef-blocks1:hover{
    
      background-color: rgb(247, 248, 250);
     
      border-bottom: 2px solid rgb(243, 243, 243);
      transition: 0.2s linear;
    }
  
    #lef-title1{
        /* background-color: red; */

        height: 30px;
        line-height: 30px;
        margin-left: 10px;
        float: left;
        width:700px;
        font-size: 16px;
        font-family: '微软雅黑';
        font-weight: lighter;
        overflow: hidden;
	text-overflow:ellipsis;
	white-space: nowrap;
      }

    #lef-date1{
      float: right;
      width: auto;
      color: gray;
      margin-right: 10px;


      font-size: 12px;
      height: 30px;
        line-height: 30px;
        /* border: 1px solid black; */
      /* background-color: aquamarine; */
    }
   


    .lef_block2{
      float: left;
        width: 900px;
        
        margin: 0 5px;
        
    }
    /* 
      */
    .lef-blocks2{
      width:900px;
        height:30px;
      background-color: white;
     
      cursor: pointer;
      border-bottom: 2px solid rgb(243, 243, 243);
    }


  .lef-blocks2:hover{
    
      background-color: rgb(247, 248, 250);
     
      border-bottom: 2px solid rgb(243, 243, 243);
      transition: 0.2s linear;
    }
  
    #lef-title2{
        
      height: 30px;
        line-height: 30px;
        margin-left: 10px;
        float: left;
        width:260px;
        font-size: 16px;
        font-family: '微软雅黑';
        font-weight: lighter;
        overflow: hidden;
	text-overflow:ellipsis;
	white-space: nowrap;
        /* border: 1px solid black; */
    }
  
    #lef-date2{
      float: right;
      margin-right: 10px;
      width: auto;
      color: gray;
      /* border: 1px solid black; */
      font-size: 12px;
      height: 30px;
        line-height: 30px;
    }
    
    

    </style>