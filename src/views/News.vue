<template>
    <div class="top0">
     <NavView></NavView>
     <div class="top">
        <Leftmenu class="leftt"></Leftmenu>
      <div class="News">

        <div class="content">   
              <!-- 轮播图大图 -->
              <el-carousel class="carousel">
              <!--遍历图片地址,动态生成轮播图-->
              <el-carousel-item class="carouselImg" v-for="(item, index) in imgList" :key="index">
                <img :src="item.listImg" />
              </el-carousel-item>
            </el-carousel>
            
          </div>
          <!-- <el-button @click="back">返回</el-button> -->
       <NewsList class="newlist"></NewsList>
     </div>
    </div>
    </div>
    </template>
    <script>
      import NavView from '@/components/NavView.vue'
      import Leftmenu from '@/components/Leftmenu.vue'
      import NewsList from '@/components/Newslist.vue'
      export default {
        name: 'News',
        components:{
          NavView,
          Leftmenu,
          NewsList
        },
        data () {
          return {
            imgList: [],
       
          }
          
        },
        methods: {  
          back(){
            this.$router.go(-1)
          },
          
        getImglist(){
          this.$axios
            .post(
              '/News/showNewslist',
              )
              .then(successResponse => {
                if (successResponse.data != "") {
                  this.imgList=successResponse.data.newslist
                  this.imgList.length=5;
                }else {
                  this.$alert('fail')
                  
                }
              })
              .catch(failResponse => {
                this.$alert(failResponse.response)
              })
            
          },
        },
 
        
        mounted() {
 
    this.getImglist();
   
  }}
    </script>
    <style scoped>
     .leftt{
            
            height: 700px;
            width:300px;
            float: left;

        }
        .top0{
          position: relative;
          width: 100%;
          height: 1000px;
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
        .content{
          margin-top: 10px;
          margin-left: 10px;
          float: left;
          /* border: 1px solid red; */
          width: 880px;
         
        }

        /* 顶部图 */
        .top-head{
          width: 800px;
          height: 350px;
          float: left;
        }
        #school{
          width: 900px;
          height: 350px;
          float: left;
          border-radius: 5px;
          box-shadow: 0px 10px 10px 0px rgb(179, 173, 173);          
        }
        .carousel{
          height: 350px;
        }
        .carouselImg{
          height:350px;
        }
        .carousel img{
      
          width: 880px;
          height: 350px;
        }
    </style>