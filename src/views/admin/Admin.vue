<template>
    <div class="top0">
     <NavView></NavView>
     <div class="top">
     <Leftmenu class="leftt"></Leftmenu>
      <div class="Login">
        首页
        <p>欢迎用户：{{showUserName}}</p>
        <br/>
        <el-button type="default" @click="reLogin">返回登录</el-button>
        <el-button type="default" @click="changeUser">修改个人资料</el-button>
        <el-button type="default" @click="newPwd">修改密码</el-button>
        <el-button type="default" @click="getUsersList">查询</el-button>
        <el-button type="default" @click="goIndex">index</el-button>
        <el-button type="default" @click="infIndex">活动页</el-button>
        <router-link>连接</router-link>
      </div>
      <div>
      <el-table :data="usersList" style="width:auto;">
        <el-table-column prop="userId" label="ID" align="center" width="">
        </el-table-column>
        <el-table-column prop="userName" label="姓名" align="center">
        </el-table-column>
        <el-table-column prop="userAcc" label="账号" align="center" width="">
        </el-table-column>
        <el-table-column prop="userPassword" label="密码" align="center" width="">
        </el-table-column>
        <el-table-column prop="userAge" label="年龄" align="center" width="">
        </el-table-column>
        <el-table-column prop="userGender" label="性别" align="center" width="">
        </el-table-column>
        <el-table-column prop="userMobile" label="手机号" align="center" width="">
        </el-table-column>
        <el-table-column prop="userEmail" label="邮箱" align="center" width="">
        </el-table-column>
        <el-table-column prop="userStatus" label="状态" align="center" width="">
        </el-table-column>
      </el-table>
    </div>
    <div>
      <el-pagination
            background
            layout="total,sizes,prev,pager,next,jumper"
            :page-size.sync="pageParam.pageSize"
            :current-page.sync="pageParam.pageNum"
            :page-sizes="pageSizes"
            :total="total"
            :hide-on-single-page="false"
            @current-change="getUsersList"
            @size-change="getUsersList"
            
            >
        </el-pagination>
      </div>
    </div>
    </div>
    </template>
    <script>
       import NavView from '@/components/NavView.vue'
        import Leftmenu from '@/components/Leftmenu.vue'
        import jsCookie from 'js-cookie';
      export default {
        name: 'Login',
        components:{
          NavView,
          Leftmenu
        },
        data () {
          return {
              userToken:{
                  username:this.$store.state.username
               
              },
              usersList: [],
              //分页设置
              pageParam: {//分页参数
                pageNum: 1,//当前页
                pageSize: 5,//每页条目数据
              },
              total: 0,//总条目数
              pageSizes: [5, 8, 10, 15],//每页显示条目数列表

          }
        },
        computed:{
            showUserName(){
              // 对当前的cookie登录状态非空判断防止报错
                if(jsCookie.get('userName')!=null){
                  return jsCookie.get('userName')
                }
                
            }
        },
        methods: {
         
          getUsersList() {
            this.$axios.get('/Home/getAll',{params:this.pageParam})
                .then(successResponse => {
                  //获得服务器端回传的map对象
                  let resultMap = successResponse.data;
                  //从集合中获取用户列表及总条目数
                  this.usersList = resultMap.userList;
                  this.total = resultMap.total;
                
                })
                .catch(err => {
                  alert(err)
                })
          
         
        },
            goIndex(){
                this.$router.push('/Index')
            },
            reLogin(){
                this.$router.push('/Login')
            },
            changeUser(){
              this.$router.push('/Change')
            },
            newPwd(){
              this.$router.push('/newPwd')
            },
            infIndex(){
              this.$router.push('/infIndex')
            }
        },
        created() {
            this.getUsersList();
        },
      }
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
    </style>