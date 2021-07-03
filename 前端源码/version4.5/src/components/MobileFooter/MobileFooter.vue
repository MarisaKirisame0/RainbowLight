<template>
  <footer id="MobileFooter">
    <div class="MobileFooterText" id="Footer-TimeBlock">小站运行起点: 2021-xx-xx | 博客总数:{{PostTotalCount}}</div>
    <div class="MobileFooterText" id="Footer-NameBlock">雾雨霜星 | 雾间觉雨,霜空望星</div>
  </footer>
</template>

<script>
export default {
  name: "MobileFooter",
  props:{
    PostTotalCount:Number,
  },
}
</script>

<style scoped>
/*@import "../../assets/fonts/fonts.css";*/
@import "index.css";
</style>