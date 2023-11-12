<template>
  <div id="app">
     <router-view/>
  </div>
   

</template>

<style lang="scss">
  *{
  margin: 0;
  padding: 0;
}
body,html{
    margin: 0;
    padding: 0;
    min-width:1200px;
    min-height: 500px;
    background-color: #f2f3f5;
}
#app{
  // background-color: #f2f3f5;
  width: 100%;
  height: 100%;
  // background: url('./image/img28.jpg');
  background-size:100% 100%;
  position:absolute;
  min-width:1200px;
    min-height:700px;
}
</style>
<script>

export default({
  //App.vue的created():
  created () {
    // 在页面加载时读取sessionStorage
    if (sessionStorage.getItem('user')) {
      this.$store.replaceState(Object.assign({}, this.$store.state, JSON.parse(sessionStorage.getItem('user'))))
    }
    // 在页面刷新时将store保存到sessionStorage里
    window.addEventListener('beforeunload', () => {
      sessionStorage.setItem('user', JSON.stringify(this.$store.state))
    })
  }

  
})
</script>
