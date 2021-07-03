<template>
  <div id="LeftMessageArea">
    <Comment></Comment>
  </div>
</template>

<script>
/* 组件功能: 留言页面
*  组件使用状况: 已经投入使用 */

import Comment from "@/components/Comment/Comment";
export default {
  name: "LeftMessage",
  components: {Comment}
}
</script>

<style>
#LeftMessageArea{
  background-color: #FFFFFF;
  margin-top: 25px;
  padding-left: 5px;
  padding-right: 5px;
  opacity: 0.8;
  transition: opacity 0.5s linear;
}
#LeftMessageArea:hover{
  opacity: 0.9;
}
@media screen and (max-width: 650px) {
  #LeftMessageArea{
    background-color: #FFFFFF;
    margin-top: 100px;
/*    padding-left: 5px;
    padding-right: 5px;*/
    opacity: 0.8;
    transition: none;
  }
}
</style>