<template>
  <div class="top0">
    <NavView></NavView>
    <div class="top">
      <Leftmenu class="leftt"></Leftmenu>

      <div class="background">
        
        <div class="header">
          <p id="p_regiTitle">{{ newsList.listTitle }}</p>
          <p id="p_author">{{ newsList.listAuthor }}</p>
          <p id="p_repdate">{{ newsList.listDatetime }}</p>
          <div class="block"></div>
        </div>
        <div class="foot">
        
        <img id="img_news" :src="newsList.listImg" />
       

      </div>
        <div class="content">
          <p id="p_regiContent">{{ newsList.listContent }}</p>
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
      newsList: {},
      rules: {},
    };
  },
  created() {
    this.scrollToTop();
    var listNumber = this.$route.query.listNumber;
    console.log(listNumber);
    this.$axios
      .post("/News/toNewsDetail/" + listNumber, {})
      .then((successResponse) => {
        if (successResponse.data != null) {
          // this.$alert(successResponse.data)
          this.newsList = successResponse.data;
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
.background {
  /* background-color: rgb(137, 137, 138); */
  background-color: white;
  border-radius: 5px;
  margin: 10px 10px;
  height: auto;
  width: 800px;
  float: left;
}

.header {
  width: 780px;
  /* border: 1px solid black; */
  margin: 10px;
  height: 60px;
  float: left;
}
.block::after {
  content: "";
  width: 80%;
  height: 70px;
  display: block;
  margin: 0 auto;

  margin: 0 auto;
  border-bottom: 2px solid rgba(102, 177, 255, 0.1);
}
.block2::after {
  content: "";
  width: 80%;
  height: 10px;
  display: block;

  margin: 0 auto;
  border-bottom: 2px solid rgba(102, 177, 255, 0.1);
}
#p_regiTitle {
  font-size: 32px;
  width: 100%;
  font-weight: lighter;
  /* border: 1px solid black; */
  float: left;
  /* text-align: center; */
}
#p_author {
  width: auto;
  font-weight: lighter;
  color: grey;
  font-size: 14px;
  float: left;
}
#p_repdate {
  width: auto;
  margin-right: 10px;
  font-weight: lighter;
  color: grey;
  font-size: 14px;
  float: right;
}
.content {
  /* background-color: red; */
  width: 800px;
  float: left;
}
#p_regiContent {
  float: left;
  text-indent: 20px;
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

</style>