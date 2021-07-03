<template>
<div id="TypeCategory-Main-Area">
  <Type v-for="type_info in TypeCategory" :type_block="type_info"></Type>
</div>
</template>

<script>
/* 组件功能: 类型分类页
*  组件使用状况: 已经投入使用 */

import Type from "@/components/Type/Type";

export default {
name: "TypeCategory",
  data (){
  return{
    TypeCategory:[
        {type_name:"代码海", type_info:"关于不愿做代码的仆人的我放弃了编程这档事 <(￣ˇ￣)/",
          type_img:"http://marisa-kirisame.gitee.io/phw/TypeImage/TypeCate1.PNG"},
        {type_name:"技术向", type_info:"技术什么的是学不会的了 (ˉ▽￣～)",
          type_img:"http://marisa-kirisame.gitee.io/phw/TypeImage/TypeCate3.PNG"},
        {type_name:"分享境", type_info:"悄悄给你看点好东西 (>▽<)",
          type_img:"http://marisa-kirisame.gitee.io/phw/TypeImage/TypeCate2.PNG"},
        {type_name:"事件薄", type_info:"这就是神的记事本吗 ( ¯▽¯；)",
          type_img:"http://marisa-kirisame.gitee.io/phw/TypeImage/TypeCate4.PNG"},],
  }
  },
  components:{
    Type,
  },
}
</script>

<style scoped>
#TypeCategory-Main-Area{
  width: 60%;
  padding-bottom: 20px;
  background-color: rgba(255,255,255,0);
  margin:20px auto;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
  opacity: 0.9;
}
@media screen and (max-width: 1250px) {
  #TypeCategory-Main-Area{
    width: 80%;
  }
}
@media screen and (max-width: 650px) {
  #TypeCategory-Main-Area{
    position: absolute;
    top:180px;
    width: 100%;
    padding-bottom: 20px;
    margin:0;
    display: flex;
    flex-direction: column;
  }
}
</style>