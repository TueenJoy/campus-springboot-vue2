<template>
   <div class="top0">

<NavView></NavView>
<div class="top">
<Leftmenu class="leftt"></Leftmenu>
<div class="background">
      <!-- 登录表单 -->
      <p id="p_formTitle">发布活动</p>
        <div class="block"></div>
      <el-form
        class="elForm"
        ref="form"
        :model="form"
        :rules="rules"
        label-width="80px"
        method="post"
      >
       
        <el-form-item label="活动标题" prop="regiTitle">
          <el-input
            class="elInput"
            v-model="form.regiTitle"
            id="input1"
            placeholder="请输入标题"
          ></el-input>
        </el-form-item>
        <!-- <el-form-item label="作者" prop="regiAuthor">
        <el-input class="elInput" v-model="form.regiAuthor" id="input1" placeholder="请输入作者"></el-input>
         </el-form-item> -->

        <el-form-item label="文章内容"  prop="regiContent">
          <el-input
            class="elInpuTextarea"
            type="textarea"
            :rows="11"
            v-model="form.regiContent"
            id="input1"
            
            placeholder="文章详情"
          ></el-input>
        </el-form-item>

        <el-form-item label="限制人数" prop="regiMaxnum">
          <el-input
            class="elInput"
            v-model="form.regiMaxnum"
            id="input1"
            placeholder="请输入活动最大人数"
          ></el-input>
        </el-form-item>

        <form
          enctype="multipart/form-data"
          action="http://127.0.0.1:8089/Home/upload"
          method="POST"
          class="timeForm"
        >
        
<!-- eleui 日期选择器 组件 -->
          <el-form-item
            class="dateSelect"
            label="开始时间"
            prop="statime"
            label-width="80px"
            >
            <el-date-picker
            class="datePicker"
              v-model="statime"
              type="datetime"
              format="yyyy-MM-dd HH:mm:ss"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder
              :picker-options="pickerOptionsStart(endtime)"
            />
          </el-form-item>
          <el-form-item
            class="dateSelect"
            label="结束时间"
            prop="endtime"
            label-width="80px"
            >
            <el-date-picker
            class="datePicker"
              v-model="endtime"
              type="datetime"
              format="yyyy-MM-dd HH:mm:ss"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder
              :picker-options="pickerOptionsEnd(statime)"
            />
          </el-form-item>
              <!-- 旧的上传方法，已弃用。使用elui的upload组件 -->
          <!-- <input type="file" name="file" accept=".jpg,.png,.jpeg" />
          <button type="submit">上传</button> -->
        </form>
        活动封面上传：<br />
        <el-upload
  class="avatar-uploader"
  action="http://127.0.0.1:8089/Home/upload"
  :on-change="toUpload"
  :auto-upload="true"
  :show-file-list="false"
  :on-success="handleAvatarSuccess"
  :before-upload="beforeAvatarUpload">
  <img v-if="imageUrl" :src="imageUrl" class="avatar">
  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
</el-upload>

        <el-form-item>
          
          <div class="opera">
          <el-button @click="postAdd" type="primary" id="button">提交报名</el-button>
        </div>
        </el-form-item>
      </el-form>
    </div>
  </div>


  </div>
</template>
    <script>
import NavView from "@/components/NavView.vue";
import jsCookie from "js-cookie";
import Leftmenu from '@/components/Leftmenu.vue'
export default {
  name: "Actadd",
  components: {
    NavView,
    Leftmenu
  },
  watch:{
    formData:{
        mark(val1,val2){
          console.log(val1);
        }
    }
  },
  data() {
    return {
      imageUrl:"",
      statime: "",
      endtime: "",
      formData:'',
      form: {},
      rules: {
        regiTitle: [{ required: true, message: "请输入标题", trigger: "blur" }],

        regiContent: [
          { required: true, message: "请输入正文", trigger: "blur" },
        ],
        regiMaxnum: [
          { required: true, message: "请输入最大限制人数", trigger: "blur" },
        ],
        statime:[
          {
            required:true,message:"请选择开始日期" ,trigger:"blur"
          }
        ],
        endtime:[
          {
            required:true,message:"请选择开始日期" ,trigger:"blur"
          }
        ]
      },
    }
  },
  
  methods: {
    // 临时方法 对时间进行比较，必须相差一天
    // testtime(){
    //     if(new Date(this.statime).getDay()<new Date(this.endtime).getDay()){
    //       alert(this.statime)
    //     }
    // },
    toUpload(file){
     this.formData=URL.createObjectURL(file.raw);
    },
    handleAvatarSuccess(res, file) {
        this.imageUrl = URL.createObjectURL(file.raw);
       
        console.log(this.imageUrl)

      },
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      },

      
    pickerOptionsStart(val) {
      return {
        disabledDate(time) {
          return time.getTime() < Date.now();
        },
      };
    },
    pickerOptionsEnd(val) {
      return {
        disabledDate(time) {
          return time.getTime() < new Date(val).getTime();
        },
        
      }
      
    },

    postAdd() {
      var recUserAcc = jsCookie.get("userAcc");
      var regiAuthor = jsCookie.get("userName");
      var recNumber = 0;
      if (
        this.form.regiTitle != null &&
        this.form.regiContent != null &&
        this.form.regiMaxnum != null

      ) {
        if( new Date(this.statime).getDay()<new Date(this.endtime).getDay()){

        
        this.$axios
          .post("/Home/doAddact", {
            regiTitle: this.form.regiTitle,
            regiAuthor: regiAuthor,
            regiContent: this.form.regiContent,
            regiMaxnum: this.form.regiMaxnum,
            regiStarttime:this.statime,
            regiOvertime:this.endtime

          })
          .then((successResponse) => {
            if (successResponse.data != "0") {
              recNumber = successResponse.data;
              this.$axios
                .post("/Home/doRecord", {
                  recTitle: this.form.regiTitle,
                  recNumber: recNumber,
                  recUseracc: recUserAcc,
                })
                .then((successResponse) => {
                  if (successResponse.data == "1") {
                    this.$alert("发布成功！");
                  }
                });
            } else {
              this.$alert("发布失败，请检查填写项并重试！");
            }
          })
          .catch((failResponse) => {
            this.$alert(failResponse.response);
          });
      } else {
        this.$alert("开始时间和结束时间至少间隔一天！");
      }
     }else{
      this.$alert("信息不允许为空！");
     }
    },
  },
};
</script>
    <style scoped>

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
          float: left;
   
        }
        
        /* 次上层父元素 */
        .top{
          float: left;
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
        .block::after {
            content: "";
            width: 90%;
            height: 5px;
            display: block;
            margin: 0 auto;

            border-bottom: 2px solid rgba(102, 177, 255, 0.1);
          }
        .background{
          width: 800px;
          float: left;
          margin: 10px 10px;
          background-color: white;
          border-radius: 10px;
          /* border: 1px solid black; */
        }
    
   .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
    
  }


.elForm {
  background-color: white;
  width: 780px;
  height: auto;
  padding: 10px 10px;
  border-radius: 10px;
}
.elInput {
  width: 700px;
}
#p_formTitle {
  color: black;

  width: 100%;
  line-height: 50px;
  margin: 0 10px;
  font-size: 26px;
  font-weight: lighter;
}
.elInpuTextarea{
  width: 700px;
  height:250px;
  font-family:"Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;

}

</style>