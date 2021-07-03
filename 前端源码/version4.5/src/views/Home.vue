<template>
<!--  &lt;!&ndash; 设置Loading动画  &ndash;&gt;
  <Loading :isLoading="LoadingFlag"></Loading>-->
  <!-- 设置页面主要背景 -->
  <img id="HomeMainBackground" src="http://marisa-kirisame.gitee.io/phw/HomeBackground/SquareBook.png"/>
  <!-- 设置页面的Head部分背景 -->
  <keep-alive>
    <HeadBackground/>
  </keep-alive>
  <div id="home">
    <!-- 文章推送的显示区域 -->
    <div class="article_group">
      <Post class="Home-Post" v-for="info in PostList" :article_info="info"/>
    </div>
    <div id="NextAndLastBlock">
      <PageButton v-if="LastButtonLiveFunction" @click="LastButtonRecall" ButtonContentText="Back" />
      <PageButton v-if="NextButtonLiveFunction" @click="NextButtonRecall" ButtonContentText="Next" />
    </div>
  </div>
  <MobileFooter :PostTotalCount="TotalPostCount" />
</template>

<script>
/* 组件功能: 首页
*  组件使用状况: 已经投入使用 */

// @ is an alias to /src
import axios from "axios";

import Post from "@/components/Post/Post";
import HeadBackground from "@/components/HeadBackground/HeadBackground";
import PageButton from "@/components/PageButton/PageButton";
import MobileFooter from "@/components/MobileFooter/MobileFooter";
import Loading from "@/components/Loading/Loading";

export default {
  name: 'Home',
  components: {
    Loading,
    MobileFooter,
    PageButton,
    HeadBackground,
    Post,
  },
  data () {
    return {
      LoadingFlag:true, //控制页面加载的loading动画组件生命周期的变量
      PostList:[],      //保存从后端获取的文章推送信息(JSON数组)
      TotalPostCount:0, //从后端获取的目前已有文章总数
      PageIndex:1,      //当前页面页码
      MaxPageIndex:2,   //从后端获取的数据库分页最大页码数
    }
  },
  computed:{
    NextButtonLiveFunction:function (){
      return this.PageIndex < this.MaxPageIndex;
      /*return true;*/
    },
    LastButtonLiveFunction:function (){
      return this.PageIndex > 1;
    }
  },
  methods: {
    NextButtonRecall:function (){
      this.PageIndex = this.PageIndex + 1;
      let _this = this;
      axios.get('/api/PageReading/GetArticleInformationListByPage?AriticlesListPage='+(_this.PageIndex).toString())
          .then(function (response) {
            _this.PostList = response.data;
          })
          .catch(function (error) {
            console.log(error);
          });
    },
    LastButtonRecall:function (){
      this.PageIndex = this.PageIndex - 1;
      let _this = this;
      axios.get('/api/PageReading/GetArticleInformationListByPage?AriticlesListPage='+(_this.PageIndex).toString())
          .then(function (response) {
            _this.PostList = response.data;
          })
          .catch(function (error) {
            console.log(error);
          });
    },
    InitQuery:function (){
      let _this = this;
      axios.get('/api/PageLoading/GetPageLordingInformation')
          .then(function (response) {
            _this.PostList = response.data.PostList;
            _this.MaxPageIndex = response.data.MaxPageIndex;
            _this.TotalPostCount = response.data.TotalPostCount;
          })
          .catch(function (error) {
            console.log(error);
          });
    },
  },
  created() {
    this.InitQuery();
  },
  mounted() {
  }
}
</script>

<style>
#HomeMainBackground{
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -4;
}
#home{
  width: 100%;
  padding-top: 10px;
}
.article_group{
  width:80%;
  margin:10px auto;
  padding: 0;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
}
#NextAndLastBlock{
  width: 25%;
  margin: auto;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  justify-content: center;
}
@media screen and (max-width: 650px) {
  #home{
    width: 100%;
    margin: 0;
    padding: 0;
  }
  .article_group{
    width:100%;
    margin: 45px 0;
    display: flex;
    flex-direction: column;
    justify-content: center;
  }
  #NextAndLastBlock{
    padding-top: 10px;
    padding-bottom: 10px;
  }
}
</style>
