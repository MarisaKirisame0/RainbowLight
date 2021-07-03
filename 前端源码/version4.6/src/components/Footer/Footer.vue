<template>
  <footer id="Footer">
    <div class="FooterText" id="Footer-TimeBlock">小站运行起点: 2021-5-1 | 博客总数:{{PostTotalCount}}</div>
    <div class="FooterText" id="Footer-NameBlock">雾雨霜星 | 雾间觉雨,霜空望星</div>
    <div class="FooterText" id="Footer-HtmlSecurity">
      <img src="../../assets/HtmlSecurityIcon.png" alt="..."/>粤公网安备 44010602009114号
    </div>
  </footer>
</template>

<script>
/* 组件功能: PC端显示的网站页脚组件
*  组件使用状况: 已经投入使用
*  组件具体使用地方: App.vue */

export default {
name: "Footer",
  props:{
  PostTotalCount:Number,
  },
}
</script>

<style scoped>
/*@import "../../assets/fonts/fonts.css";*/
@import "index.css";
</style>