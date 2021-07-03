<template>
  <link href="https://cdn.jsdelivr.net/npm/animate.css@3.5.1" rel="stylesheet" type="text/css">
  <!-- 设置Loading动画  -->
  <Loading id="Loading" :isLoading="LoadingFlag"></Loading>
  <keep-alive>
    <MainBackground v-if="(this.$route.path) !== '/'"/>
  </keep-alive>
  <Header/>
  <Nav/>
  <router-view/>
  <Footer id="Footer" :PostTotalCount="PostTotalCount" />
</template>

<script>
import Nav from "@/components/Nav/Nav";
import Header from "@/components/Header/Header";
import HeadBackground from "@/components/HeadBackground/HeadBackground";
import MainBackground from "@/components/MainBackground/MainBackground";
import Footer from "@/components/Footer/Footer";
import Loading from "@/components/Loading/Loading";
import axios from "axios";

export default {
  name: 'App',
  components:{
    Footer,
    MainBackground,
    HeadBackground,
    Nav,
    Header,
    Loading,
  },
  data(){
    return{
      PostTotalCount:0,
      LoadingFlag:true, //用于控制Loading动画组件生命的变量
    }
  },
  methods:{
    InquirePostTotalCount:function (){
      let _this = this;
      axios.get('/api/APP/InquirePostTotalCount')
          .then(function (response) {
            _this.PostTotalCount = response.data;
          })
          .catch(function (error) {
            console.log(error);
          });
    }
  },
  created() {
    this.InquirePostTotalCount();
  },
  /* 在下面设置Loading动画的时长 */
  mounted() {
    setTimeout(() => {
      this.LoadingFlag = false; //闭首页页面加载的loading动画
    },4000)
  }
}
</script>

<style>
@import "assets/fonts/fonts.css";
body
{
  cursor:url(assets/cursor/Arrow2.png),auto; /* 设置普通鼠标样式 */
}
a{
  cursor:url(assets/cursor/Hand.png),auto; /* 设置连接鼠标样式 */
}
#Loading{
  position: fixed;
  top: 100px;
}
/* 设置字体选中时的背景与字体颜色 */
::selection{
  background:mediumorchid;
  color:white;
}
::-moz-selection{
  background:mediumorchid;
  color:white;
}
@media screen and (max-width: 650px){
  body{
    margin: 0;
  }
  Header{
    position: absolute;
    top: 0;
  }
  Nav{
    position: absolute;
    top: 112px;
  }
  #Loading{
    top: 1px;
  }
}
</style>
