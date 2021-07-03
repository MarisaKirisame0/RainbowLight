<template>
  <footer id="MobileFooter">
    <div class="MobileFooterText" id="Footer-TimeBlock">小站运行起点: 2021-5-1 | 博客总数:{{PostTotalCount}}</div>
    <div class="MobileFooterText" id="Footer-NameBlock">雾雨霜星 | 雾间觉雨,霜空望星</div>
    <div class="FooterText" id="Footer-HtmlSecurity">
      <img src="../../assets/HtmlSecurityIcon.png" alt="..."/>粤公网安备 44010602009114号
    </div>
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