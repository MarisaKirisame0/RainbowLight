<template>
  <link href="https://cdn.jsdelivr.net/npm/animate.css@3.5.1" rel="stylesheet" type="text/css">
  <div id="Background">
    <transition mode="out-in" leave-active-class="animated fadeOut" enter-active-class="animated fadeIn" >
      <img id="Background-image" :src="ImageURL" v-if="MainBackgroundLiveFlag"/>
    </transition>
    <transition>
      <img id="Mobile-Background" :src="MobileBackgroundSrc" v-if="MobileBackgroundLiveFlag"/>
    </transition>
  </div>
</template>

<script>
/* 组件功能: 首页以外的页面的背景
*  组件使用状况: 已经投入使用
*  组件具体使用地方: App.vue */

const BackgroundImageGroup = [
  "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/61382182_p0.jpg",
  "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/62462796_p0.jpg",
  "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/62555893_p0.jpg",
  "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/62914760_p0.jpg",
  "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/70171811_p0.jpg",
  "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/64559312_p0.jpg",
  "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/69759328_p0.jpg",
  "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/86447654_p0.jpg",
]
export default {
name: "MainBackground",
  data (){
  return{
    BackgroundImgCount:8,//背景图片定时切换，背景图片数量
    DurationTime:100, //过渡动画时间
    IntervalTime:10000,//背景定时切换的周期
    //PC端的背景图片路径变量
    ImageURL:"http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/61382182_p0.jpg",
    MainBackgroundLiveFlag:true,                                                        //控制PC端背景图片生成与删除的变量
    MobileBackgroundSrc:"http://marisa-kirisame.gitee.io/phw/MobileMainBackground/MobileMain1.jpg",//移动端的背景图片路径
    MobileBackgroundLiveFlag:false,                                                     //控制移动端背景图片生成与删除的变量
    WindowWidthThread:650,                                                              //屏幕阈值，低于此值认为是移动端
  }
  },
  methods:{
  /* 用于定时切换背景的函数，只有在屏幕宽度大于阈值时才会被调用 */
   IntervalF:function(){
     this.MainBackgroundLiveFlag=true;
     this.MobileBackgroundLiveFlag=false;
     let _this = this;
     const img_count=this.BackgroundImgCount;const duration_time=this.DurationTime;const IntervalTime=this.IntervalTime;
     let index = 0;
     let timer = setInterval(() => {
       if(index===img_count-1){
         index=0;
       }
       else {
         index = index + 1;
       }
       _this.MainBackgroundLiveFlag=false;
       _this.ImageURL = BackgroundImageGroup[index];
       setTimeout(() => {
         _this.MainBackgroundLiveFlag=true;
       },duration_time)
     },IntervalTime);
   }
  },
  mounted(){
  if(window.screen.width >= this.WindowWidthThread){
    this.IntervalF();
  }
  else {
    /* 检测到屏幕宽度不大于阈值，认为是移动端，不显示MainBackground，显示MobileBackground */
    this.MainBackgroundLiveFlag=false;
    this.MobileBackgroundLiveFlag=true;
  }
  }
}
</script>

<style scoped>
@import "index.css";
</style>