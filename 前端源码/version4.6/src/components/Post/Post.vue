<template>
  <div id="home-article">
    <router-link  class="article-router-link" :to="{path: '/passage',query: {id}}">
    <img class="article-cover" :src="imgsrc" alt="image loading error">
    <div class="home-article-name">
      <strong>{{title}}</strong>
    </div>
    <div class="home-article-introduction">&emsp;{{introduction}}</div>
<!--    <div class="home-article-info">&nbsp;Type:{{type}}  &nbsp;  Tags:{{tags}}<br/>&nbsp;Time:{{time}}<br/>  </div>-->
    <div class="home-article-info">&nbsp;<svg-icon id="Type" data_iconName="typesvg" className="typesvg_icon" />{{type}}  &nbsp;  <svg-icon id="Tags" data_iconName="tagsvg" className="tagsvg_icon" />{{tags}}<br/>&nbsp;Time:{{time}}<br/>  </div>
    </router-link>
  </div>
</template>

<script>
//用于首页中展示文章链接入口的组件

import SvgIcon from "@/svgIcon";
export default {
  name: "Post",
  components: {SvgIcon},
  props:{
    article_info:JSON,
  },
  data () {
    return{
      id:"",
      imgsrc:"https://i.loli.net/2021/03/20/Q1hWdqNgb9p3eYG.jpg",
      title:"",
      clicktimes:"",
      introduction:"",
      tags:"",
      type:"",
      time:"",
      article_information:"",
    }
  },
  watch:{
    article_info:function (){
      this.title=this.article_info.name;
      this.id=this.article_info.id;
      this.imgsrc=this.article_info.cover;
      this.clicktimes=this.article_info.clicktimes;
      this.introduction=this.article_info.introduction;
      this.tags=this.article_info.tags;
      this.type=this.article_info.type;
      this.time=this.article_info.time;
    }
  },
  created () {
    console.log(this.article_info);
    this.title=this.article_info.name;
    this.id=this.article_info.id;
    this.imgsrc=this.article_info.cover;
    this.clicktimes=this.article_info.clicktimes;
    this.introduction=this.article_info.introduction;
    this.tags=this.article_info.tags;
    this.type=this.article_info.type;
    this.time=this.article_info.time;
  },
  mounted() {
  }
}
</script>

<style scoped>
@import "index.css";
</style>