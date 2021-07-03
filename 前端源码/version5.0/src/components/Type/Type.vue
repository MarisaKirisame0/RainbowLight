<template>
  <router-link class="Type-router-link"
               :to="{path: '/postquery',query: {qc:query_condition, qk:query_keyword}}">
  <div class="Type-Box">
      <img class="TypeImage" :src="TypeImage" alt="???"/>
      <div class="Type-Word-Name">{{type_block.type_name}}</div>
      <div class="Type-Word-Info">{{type_block.type_info}}</div>
  </div>
  </router-link>
</template>

<script>
//显示每个Passage-Type的组件,点击跳转进入Type查询结果页面
export default {
  name: "Type",
  props:{
    type_block:JSON
  },
  data (){
    return{
      query_condition:"Type",
      query_keyword:this.type_block.type_name,
      TypeImage:this.type_block.type_img,
    }
  },
}
</script>

<style scoped>
/*@import "../../assets/fonts/fonts.css";*/
@import "index.css";
</style>