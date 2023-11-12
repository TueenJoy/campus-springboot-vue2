<template>
    <div>   
      <div class="lef">
        <div class="lef_block">
          <!-- <el-button @click="showActlist" id="lef-button">报名</el-button> -->
        <div class="lef-blocks" v-for="(item, index) in actlist" :key="index" >
           
              <img id="lef-img" :src="item.regiImg">
            <p id="lef-title">{{item.regiTitle }}</p>
            <p id="lef-content">{{item.regiContent }}</p>
            <p id="lef-date">{{item.regiStarttime }}</p>
            <p id="lef-nums">{{item.regiNumber }}</p>
            
            <!-- $event带reginumber用于详情页传值 -->
            <el-button  id="lef-button" @click="toregiNumber(item.regiNumber,$event)">报名</el-button>
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
              actlist:[{}],
              
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
      width: 250px;
    }
    #lef-button{
      float:left;
      width: 150px;
    }


    </style>