<template>
    <div>
    
      <div class="lef">
          <ul class="lef-ul">
        <li v-for="(item, index) in navlist1" :key="index" >
          <router-link id="rtlink" tag="div" :to="item.link" exact :class='{routerLinkActive}'>{{ item.name }}</router-link>
        </li>
          </ul>

      </div>
    </div>
</template>
    <script>
      export default {
        name: 'Lefemenu',
    
        data () {
          return {
              
              navlist1:[
                {
                  name:'首页',
                
                  link:'News'
                },
                {
                  name:'校园实践',
                  link:'home'
                },
                {
                  name:'个人中心',
                  link:'userCenter'
                }, 
                ]
            }
        },
        
        components:{
        
        },
        methods: {
          
        },
        
      }
    </script>
    <style scoped>
    .lef{
      /* background-color: #6666ee; */
      height: 100%;
      
    }
    .lef-ul{
      text-align: center;
      list-style-type:none;
      
    }
    .lef-ul li{
      cursor: pointer;
      
      background-color: #f9f9f9;
      margin: 10px 0;
      border-left-style: solid;
      border-left-width: 5px;
      border-left-color: rgb(3, 154, 255);

    }
    .lef-ul li:hover{
      background-color: rgba(196, 196, 196, 0.2);
        color: rgb(3, 154, 255);
       transition: 0.2s;
    }
    #rtlink{
      line-height: 50px;
    }
    
    .router-link-active{
      color: rgb(3, 154, 255);
      background-color: rgba(3, 154, 255,0.2);
    }
    </style>