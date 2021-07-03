<template>
  <transition name="fade">
    <img id="loadingimg" v-if="isLoading" src="../../assets/loading/fufu.gif" />
  </transition>
  <transition name="fade">
    <img id="loadingimg-Mobile" v-if="isLoading" src="../../assets/loading/fufum.gif" />
  </transition>
  <div id="LoadingText" v-if="isLoading">Loading...<br/>欢迎来到我的小站！<br/>{{LoadingMessagePost[RandomNumber]}}</div>
  <!-- 预加载背景图片  -->
  <img v-if="isLoading"  class="ImagePreLoad" v-for="image in ImageGroupPreLoad" :src="image" alt="LoadingImage..."/>
</template>

<script>
/* 组件功能: Loading组件,提供Loading动画与对图片文件进行Loading的准备
*  组件使用状况: 已投入使用
*  组件具体使用地方: App.vue */

export default {
  name: "Loading",
  props:{
    isLoading:{
      type:Boolean,
      default:true,
    }
  },
  data(){
    return{
      /* Loading动画花语 */
      LoadingMessagePost:[
          "郁金香的花语是: 荣誉的皇冠、永恒的祝福",
          "百合花的花语是: 纯洁而高雅，神圣而温柔",
          "雏菊的花语是: 深埋心底的爱",
          "矢车菊的花语是: 细致而优雅、幸福地活着",
          "樱花的花语是: 吾之质朴，就是一生一世只爱你",
          "蓝色妖姬的花语是: 相守是承诺,人世轮回中,如何才能拥有一份温柔的情意",
          "薰衣草的花语是: 等待爱情",
          "风铃草的花语是: 你对我的恩情,我将永远铭记于心",
          "夕雾花的花语是: 一往情深",
          "风信子的花语是: 过往的悲伤与后悔,都是未来的序章",
          "紫苑花的花语是: 生来朴素而平凡,也执着于绽放",
          "月光花的花语是: 永恒的温暖,是于寂寥暮夜中默默绽放留下的芳香",
          "曼珠沙华的花语是: 无尽的思念,我只想着你",
          "紫罗兰的花语是: 你的美丽如同盛夏的清凉"
      ],
      /* Loading动画花语 备用 */
      LoadingMessagePost_Spare:[
        "康乃馨的花语是: 温馨,温暖的爱,魅力和尊敬之情",
        "粉色曼陀罗的花语是: 生生不息的希望",
        "不灭忍的花语是: 奉献之爱",
        "琉璃草的花语是: 勿忘我们的过往",
        "七色堇的花语是: 愿望之花,诚实的爱",
        "醉蝶花的花语是: 神秘",
        "鸾尾兰的花语是: 纯真",
      ],
      /* 在展示Loading动画时加载图片，把需要提前加载的图片路径放到这里 */
      ImageGroupPreLoad:[
        "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/61382182_p0.jpg",
        "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/62462796_p0.jpg",
        "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/62555893_p0.jpg",
        "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/62914760_p0.jpg",
        "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/70171811_p0.jpg",
        "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/64559312_p0.jpg",
        "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/69759328_p0.jpg",
        "http://marisa-kirisame.gitee.io/phw/MainBackground/ThemeAfternoonSeeing/86447654_p0.jpg",
        "http://marisa-kirisame.gitee.io/phw/MobileMainBackground/MobileMain1.jpg",
        "http://marisa-kirisame.gitee.io/phw/Avatar/Avatar.jpg",
      ],
    }
  },
  methods:{
    /* 用于产生指定范围内的随机数的函数 */
    randomNum:function (minNum,maxNum){
       switch(arguments.length){
         case 1:
           return parseInt(Math.random()*minNum+1,10);
         case 2:
           return parseInt(Math.random()*(maxNum-minNum+1)+minNum,10);
         default:
           return 0;
  }
}
},
  computed:{
    RandomNumber:function (){
      /*return Math.round((Math.random())*10*2);*/
      return this.randomNum(0,13);
    }
  },
  mounted() {
  }
}
</script>

<style scoped>
@import "../../assets/fonts/fonts.css";
@import "index.css";
</style>