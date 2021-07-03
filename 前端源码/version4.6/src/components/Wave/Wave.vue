<template>
    <svg id="WaveSVG" xmlns="http://www.w3.org/2000/svg" :width="PrintWidth" height="100">
      <g fill="rgba(255,255,255,0.2)">
        <path :d="wave_Middle_path"></path>
        <animateTransform attributeName="transform" attributeType="XML" type="translate" from="0" to="-600" dur="2.0s" repeatCount="indefinite"></animateTransform>
      </g>
      <g fill="rgba(255,255,255,0.7)">
        <path :d="wave_Big_path"></path>
        <animateTransform attributeName="transform" attributeType="XML" type="translate" from="0" to="-1200" dur="8.0s" repeatCount="indefinite"></animateTransform>
      </g>
      <g fill="rgba(255,255,255,0.5)">
        <path :d="wave_Small_path"></path>
        <animateTransform attributeName="transform" attributeType="XML" type="translate" from="0" to="-520" dur="4.0s" repeatCount="indefinite"></animateTransform>
      </g>
    </svg>
</template>
<script>
/* 组件功能: 产生波浪的视觉效果
*  组件使用状况: 已经投入使用
*  组件具体使用地方: HeadBackground.vue */

export default {
name: "Wave",
  props:{
    PrintWidth:Number,
  },
  data (){
    return{
      default_width:1600,
      wave_Middle_path:"M0 50 Q150 10,300 50 T600 50 T900 50 T1200 50 T1500 50 T1800 50 T2100 50 T2400 50 T2700 50 T3000 50 V150 H0 V0",
      wave_Big_path:"M0 50 Q300 0,600 50 T1200 50 T1800 50 T2400 50 T3000 50 T3600 50 T4200 50 T4800 50 T5400 50 T6000 50 V150 H0 V0",
      wave_Small_path:"M0 50 Q130 20,260 50 T520 50 T780 50 T1040 50 T1300 50 T1560 50 T1820 50 T2080 50 T2340 50 T2600 50 V150 H0 V0",
    }
  },
  computed:{
  },
  created() {

  }
}
</script>

<style scoped>
@import "index.css";
</style>