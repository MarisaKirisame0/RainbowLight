<template>
  <div id="QuoteBlock">
    <svg-icon class="svg-icon" id="QuoteIconLeft" data_iconName="quote-left" className="quote-left_icon"></svg-icon>
    <br/>
    <span id="QuoteText">{{QuotePoemGroup[QuoteIndex]}}</span>
    <br/>
    <svg-icon class="svg-icon" id="QuoteIconRight" data_iconName="quote-right" className="quote-right_icon"></svg-icon>
  </div>
</template>

<script>
import SvgIcon from "@/svgIcon";
export default {
  name: "HeadQuote",
  components: {
    SvgIcon
  },
  props:{
    QuoteIndex:Number,
  },
  data (){
    return{
      QuotePoemGroup:[
          "晓风袭人，心旷神怡",
          "残月盈辉，光沐大地",
          "华鸟风月，恬静婉约",
          "",
      ],
    }
  }
}
</script>

<style scoped>
@import "index.css";
</style>