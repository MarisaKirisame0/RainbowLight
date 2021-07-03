<template>
  <link href="https://cdn.jsdelivr.net/npm/animate.css@3.5.1" rel="stylesheet" type="text/css">
  <div class="HeadImage-Background">
    <div>
      <transition enter-active-class="animated fadeIn">
        <img class="img" :src="MobilePhoneBackGroundImageSrc" v-if="MobilePhoneBackGroundLiveFlag"/>
      </transition>
      <transition name="fade" mode="out-in" leave-active-class="animated fadeOut" enter-active-class="animated fadeIn" >
        <img class="img" :src="src_group[0]" v-if="ShowFlagGroup[0]"/>
      </transition>
      <transition name="fade" mode="out-in" leave-active-class="animated fadeOut" enter-active-class="animated fadeIn" >
        <img class="img" :src="src_group[1]" v-if="ShowFlagGroup[1]"/>
      </transition>
      <transition name="fade" mode="out-in" leave-active-class="animated fadeOut" enter-active-class="animated fadeIn" >
        <img class="img" :src="src_group[2]" v-if="ShowFlagGroup[2]"/>
      </transition>
      <transition name="fade" mode="out-in" leave-active-class="animated fadeOut" enter-active-class="animated fadeIn" >
        <img class="img" :src="src_group[3]" v-if="ShowFlagGroup[3]"/>
      </transition>
      <transition name="fade" mode="out-in" leave-active-class="animated fadeOut" enter-active-class="animated fadeIn">
        <img class="img" :src="src_group[4]" v-if="ShowFlagGroup[4]"/>
      </transition>
      <transition name="fade" mode="out-in" leave-active-class="animated fadeOut" enter-active-class="animated fadeIn">
        <img class="img" :src="src_group[5]" v-if="ShowFlagGroup[5]"/>
      </transition>
      <transition name="fade" mode="out-in" leave-active-class="animated fadeOut" enter-active-class="animated fadeIn">
        <img class="img" :src="src_group[6]" v-if="ShowFlagGroup[6]"/>
      </transition>
      <transition name="fade" mode="out-in" leave-active-class="animated fadeOut" enter-active-class="animated fadeIn">
        <img class="img" :src="src_group[7]"   v-if="ShowFlagGroup[7]"/>
      </transition>
      <transition name="fade" mode="out-in" leave-active-class="animated fadeOut" enter-active-class="animated fadeIn">
        <img class="img" :src="src_group[8]"   v-if="ShowFlagGroup[8]"/>
      </transition>
      <transition name="fade" mode="out-in" leave-active-class="animated fadeOut" enter-active-class="animated fadeIn">
        <img class="img" :src="src_group[9]"   v-if="ShowFlagGroup[9]"/>
      </transition>
      <div class="WaveImage-Block">
        <Wave :PrintWidth="WindowWidth"></Wave>
      </div>
    </div>
  </div>
</template>

<script>
/* 组件功能: PC端的首页的Header的背景
*  组件使用状况: 已经投入使用
*  组件具体使用地方: Home.vue */

import Wave from "@/components/Wave/Wave";

export default {
name: "HeadBackground",
  components:{
  Wave
  },
  data (){
  return{
    /* PC端Head背景图片的URL地址 */
    src_group:[
      "http://marisa-kirisame.gitee.io/phw/HeadImage/DongFangTheme/DongFangHeadImage1.jpg",
      "http://marisa-kirisame.gitee.io/phw/HeadImage/DongFangTheme/DongFangHeadImage8.jpg",
      "http://marisa-kirisame.gitee.io/phw/HeadImage/DongFangTheme/DongFangHeadImage6.jpg",
      "http://marisa-kirisame.gitee.io/phw/HeadImage/DongFangTheme/DongFangHeadImage7.jpg",
      "http://marisa-kirisame.gitee.io/phw/HeadImage/DongFangTheme/DongFangHeadImage3.jpg",
      "http://marisa-kirisame.gitee.io/phw/HeadImage/DongFangTheme/DongFangHeadImage4.jpg",
      "http://marisa-kirisame.gitee.io/phw/HeadImage/DongFangTheme/DongFangHeadImage2.jpg",
      "http://marisa-kirisame.gitee.io/phw/HeadImage/DongFangTheme/DongFangHeadImage5.jpg",
      "http://marisa-kirisame.gitee.io/phw/HeadImage/DongFangTheme/DongFangHeadImage10.jpg",
      "http://marisa-kirisame.gitee.io/phw/HeadImage/DongFangTheme/DongFangHeadImage9.jpg",
    ],
    ShowFlagGroup:[true,false,false,false,false,false,false,false,false,false], //用于控制Head背景图片声明周期的变量数组
    MobilePhoneBackGroundImageSrc:"http://marisa-kirisame.gitee.io/phw/MobileHeadBackground/HeadImage1.png",//移动端的背景图片
    MobilePhoneBackGroundLiveFlag:false, //移动端的图片显示控制变量
    WindowWidthThread:650,  //屏幕阈值，用于区分PC端与移动端
    WindowWidth:1600, //使用Js获取到的屏幕宽度,主要是用于设置Wave动画的显示宽度
  }
  },
  methods:{
    /* 在检测到屏幕宽度大于 WindowWidthThread 时，该函数会执行，得到PC端效果 */
  BackgroundIntervalFunction:function(){
    this.ShowFlagGroup[0]=true;
    this.MobilePhoneBackGroundLiveFlag=false;
    let _this = this;
    const img_count=10;
    const duration_time = 50;
    const IntervalTime = 5000;
    let index = 0;
    let last_index = 0;
    let timer = setInterval(() => {
      last_index = index;
      if(index===img_count-1){
        index=0;
      }
      else {
        index = index + 1;
      }
      _this.ShowFlagGroup[last_index]=false;
      setTimeout(() => {
        _this.ShowFlagGroup[index]=true;
      },duration_time)
    },IntervalTime);
  },
    /* 在检测到屏幕宽度小于 WindowWidthThread 时，该函数会执行，修改背景图片 */
  WindowResetFunction:function(){
    this.ShowFlagGroup[0]=false;
    this.MobilePhoneBackGroundLiveFlag=true;
  },
  },
  created() {
    this.WindowWidth = document.body.clientWidth; //获取屏幕显示宽度用于设置波浪动画显示宽度
    if(window.screen.width < this.WindowWidthThread){
      this.ShowFlagGroup[0]=false;
    }
  },
  mounted() {
  if(window.screen.width >= this.WindowWidthThread){
    this.BackgroundIntervalFunction();
  }
  else {
    this.WindowResetFunction();
  }
  }
}
</script>

<style scoped>
@import "index.css";
</style>