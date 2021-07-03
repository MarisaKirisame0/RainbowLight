<template>
  <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <div id="home-nav-block">
    <nav id="home-nav">
      <router-link to="/" class="page-nav-link">
        <p class="fa fa-star-o" id="icon-main"></p>
        <p class="page-nav-words">{{datas.w1}}</p>
      </router-link>
      <router-link to="/fileplace" class="page-nav-link">
        <p class="fa fa-folder-o" id="icon-file"></p>
        <p class="page-nav-words">{{datas.w2}}</p>
      </router-link>
      <router-link to="/typecategory" class="page-nav-link">
        <p class="fa fa-files-o" id="icon-time"></p>
        <p class="page-nav-words">{{datas.w3}}</p>
      </router-link>
      <router-link to="/tagscategory" class="page-nav-link">
        <p class="fa fa-bookmark-o" id="icon-happy"></p>
        <p class="page-nav-words">{{datas.w4}}</p>
      </router-link>
      <router-link to="" class="page-nav-link">
        <p class="fa fa-map-o" id="icon-story"></p>
        <p class="page-nav-words">{{datas.w5}}</p>
      </router-link>
      <router-link to="/friendlink" class="page-nav-link">
        <p class="fa fa-paper-plane-o" id="icon-friends"></p>
        <p class="page-nav-words">{{datas.w6}}</p>
      </router-link>
      <router-link to="/about" class="page-nav-link">
        <p class="fa fa-comment-o" id="icon-know"></p>
        <p class="page-nav-words">{{datas.w7}}</p>
      </router-link>
    </nav>
  </div>
</template>

<script>
/* 组件功能: 导航栏
*  组件使用状况: 已经投入使用
*  组件具体使用地方: App.vue */

const datas = {w1:"首页",w2:"归档",w3:"分类",w4:"标签",w5:"记录",w6:"友链",w7:"关于"}

export default {
  name: "Nav",
  data () {
    return {
      datas,
    }
  }
}
</script>

<style scoped>
/*@import "../../assets/fonts/fonts.css";*/
@import "index.css";
</style>