<template>
<div id="file-box" :style="special_style">
  <router-link class="article-router-link" :to="{path: '/passage',query: {id}}">
  <div class="title">
    <p>{{title}}</p>
  </div>
  <div class="type-tags-create">
    <div>
      <svg-icon data_iconName="type" className="type_icon" />
      <span class="type-tags-create-span">{{type}}</span>
      <svg-icon id="TagSVGIcon" data_iconName="tag" className="tag_icon" />
      <span id="TagsSpan" class="type-tags-create-span">{{tags}}</span>
      <svg-icon id="CreateTimeSVGIcon" data_iconName="date" className="date_icon" />
      <span id="CreateTimeSpan" class="type-tags-create-span">{{time}}</span>
    </div>
  </div>
  </router-link>
</div>
</template>

<script>
/* 组件功能: 归档分类页每个推送文章的小方块组件
*  组件使用状况: 已经投入使用
*  组件具体使用地方: FilePlace.vue 、PostQuery.vue */

export default {
  name: "filebox",
  props:{
    FileBoxInfo:JSON,
},
  data (){
    return{
      id:"",
      title:"",
      tags:"",
      type:"",
      time:"",
      random_index1:"",
      random_index2:"",
      random_index3:"",
      special_style:"background-color:rgba("+
          Math.floor(Math.random()*255).toString()+","+
          Math.floor(Math.random()*255).toString()+","+
          Math.floor(Math.random()*255).toString()+",0.2);"
    }
  },
  watch:{
    FileBoxInfo:function (){
      this.id = this.FileBoxInfo.id;
      this.title = this.FileBoxInfo.name;
      this.time = this.FileBoxInfo.time;
      this.type = this.FileBoxInfo.type;
      this.tags = this.FileBoxInfo.tags;
    }
  },
  created() {
    this.id = this.FileBoxInfo.id;
    this.title = this.FileBoxInfo.name;
    this.time = this.FileBoxInfo.time;
    this.type = this.FileBoxInfo.type;
    this.tags = this.FileBoxInfo.tags;
  }
}
</script>

<style scoped>
/*@import "../../assets/fonts/fonts.css";*/
@import "index.css";
</style>