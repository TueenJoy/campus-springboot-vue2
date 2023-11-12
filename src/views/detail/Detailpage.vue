<template>
  <div class="top0">
    <NavView></NavView>
    <div class="top">
      <Leftmenu class="leftt"></Leftmenu>
      <div class="background">
        <div class="header">
          <p id="p_regiTitle">{{ regiAll.regiTitle }}</p>
          <p id="p_author">发布者：{{ regiAll.regiAuthor }}</p>
          <p id="p_repdate">发布时间：{{ regiAll.regiDatetime }}</p>
          <div class='block'></div>

        </div>
        <div class="foot">
        <img id="img_news" :src="regiAll.regiImg" />
      </div>
        <div class="content">
          <p id="p_regiContent">{{ regiAll.regiContent }}</p>
         
        </div>
        <div class="foot">
          <div class='block2'></div>

          <p id="p_date1">活动开始时间：{{ regiAll.regiStarttime }}</p>
          <p id="p_date2">活动结束时间：{{ regiAll.regiOvertime }}</p>
          <p id="p_reginums1">
            报名人数：{{ regiAll.regiAlnum }}
          </p>
          
          <p id="p_reginums2">
            最大人数：{{ regiAll.regiMaxnum }}
          </p>
          
        </div>
        
        <div class="opera">
          <el-button @click="doAddact" type="primary" id="button">提交报名</el-button>
        </div>
      
      </div>

    </div>
  </div>
</template>
    <script>
import NavView from "@/components/NavView.vue";
import Leftmenu from "@/components/Leftmenu.vue";
import jsCookie from "js-cookie";
export default {
  name: "Actadd",
  components: {
    NavView,
    Leftmenu,
  },

  data() {
    return {
      regiAll: {},
      rules: {},
    };
  },
  created() {
    this.scrollToTop();
    this.regiNumber = this.$route.query.regiNumber;

    // alert(this.regiNumber)
    //接收传值
    this.$axios
      .post("/Home/toActDetail/" + this.regiNumber, {})
      .then((successResponse) => {
        if (successResponse.data != null) {
          // this.$alert(successResponse.data)
          this.regiAll = successResponse.data;
        } else {
          this.$alert("失败！");
        }
      })
      .catch((failResponse) => {
        this.$alert(failResponse.response);
      });
  },
  methods: {
    scrollToTop() {
      window.scrollTo(0, 0);
    },
    doAddact() {
      var signUser = jsCookie.get("userAcc");
      var signUname = jsCookie.get("userName");
      this.$axios
        .post("/Home/doSignAct", {
          signTitle: this.regiAll.regiTitle,
          signNumber: this.regiAll.regiNumber,
          signUser: signUser,
          signUname: signUname,
        })
        .then((successResponse) => {
          if (successResponse.data == "1") {
            this.$alert("报名成功！");
          } else {
            this.$alert("报名失败！请稍后重试。");
          }
        })
        .catch((failResponse) => {
          this.$alert(failResponse.response);
        });
    },
  },
};
</script>
    <style scoped>
.leftt {
  height: 700px;
  width: 300px;
  float: left;
}
.top0 {
  position: relative;
  width: 100%;
  height: 780px;
  /* background-color: bisque; */
}

/* 次上层父元素 */
.top {
  /* background-color: #fff; */
  margin-top: 80px;
  width: 1200px;
  height: 100%;
  /* border: 1px solid black; */
  position: absolute;
  /* 父相子绝 */
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}

.background{
  /* background-color: rgb(137, 137, 138); */
  background-color: white;
  border-radius: 5px;
  margin: 10px 10px;
  height: auto;
  width: 800px;
  float: left;
}

.header{
  width: 780px;
  /* border: 1px solid black; */
  margin: 10px;
  height: 60px;
  float: left;
}
.block::after {
content: '';
  width: 80%;
  height: 70px;
  display: block;
  margin: 0 auto;
  
  margin: 0 auto;
  border-bottom: 2px solid rgba(102, 177, 255, 0.1);
}
.block2::after {
content: '';
  width: 80%;
  height: 10px;
  display: block;

  margin: 0 auto;
  border-bottom: 2px solid rgba(102, 177, 255, 0.1);
}
#p_regiTitle{
  font-size: 32px;
  width: 100%;
  font-weight: lighter;
  /* border: 1px solid black; */
  float: left;
  /* text-align: center; */
}
#p_author{
    width:auto;
    font-weight: lighter;
    color: grey;
    font-size: 14px;
  float: left;
}
#p_repdate{
width:auto;
margin-right: 10px;
    font-weight: lighter;
    color: grey;
    font-size: 14px;
  float: right;
}
.content{
  /* background-color: red; */
  width: 800px;
  float: left;

}
#p_regiContent {
  float: left;
  text-indent:20px;
  height: auto;
  width: 780px;
  /* border: 1px solid black; */
  margin: 10px 10px;
  line-height: 40px;
  font-size: 18px;
  font-weight: lighter;

}
.foot {
  float: left;
  width: 780px;
  height: auto;
  /* border: 1px solid black; */
  margin: 10px;
}

.foot img{
  width: 100%;
  height: auto;
  float: left;
}
#p_date1{
  font-size: 16px;
  color:grey;
  float: left;
  width: 100%;
  font-weight: lighter;

}
#p_date2{
  font-size: 16px;
  color: grey;
  float: left;
  width: 100%;
  font-weight: lighter;

}

#p_reginums1{
  width: 100px;
  float: left;
  font-weight: lighter;

}

#p_reginums2{
  float: left;
  width: 100px;
  font-weight: lighter;

}

.opera{
  float: left;
  margin: 10px;


}



</style>