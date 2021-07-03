<template>
  <div id="TagsCategoryBlock">
    <HeadQuote QuoteIndex=2 class="QuoteBlock"/>
    <div id="TagsCategory-main-area">
      <Tag class="tag" v-for="(tag, index) in Tags" :tag="tag" :index="index"></Tag>
    </div>
  </div>
</template>

<script>
/* 组件功能: 标签分类页
*  组件使用状况: 已经投入使用 */

import axios from "axios";
import Tag from "@/components/Tag/Tag";
import HeadQuote from "@/components/HeadQuote/HeadQuote";

export default {
  name: "TagsCategory",
  components: {
    HeadQuote,
    Tag,
  },
  data (){
    return{
      Tags:[],  //从后端获取的标签列表
    }
  },
  created(){
    let _this = this;
    axios.get('/api/PageReading/GetTagsInformation')
        .then(function (response) {
          _this.Tags = response.data;
        })
        .catch(function (error) {
          console.log(error);
          return error;
        });
  }
}
</script>

<style scoped>
#TagsCategoryBlock{
  width: 40%;
  margin:20px auto;
  padding-left: 20px;
  padding-right: 20px;
  background-color: rgba(255,255,255,0.5);
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  justify-content: center;
}
#TagsCategory-main-area{
  width:100%;
  margin:20px auto;
  padding-left: 5px;
  padding-right: 15px;
  padding-bottom: 5px;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
}
.tag{
  margin: 5px 5px 5px 5px;
}
@media screen and (max-width: 650px) {
  .QuoteBlock{
    display: none;
  }
  #TagsCategoryBlock{
    position: absolute;
    width: 100%;
    top: 180px;
    margin:0 auto;
    padding-left: 1px;
    padding-right: 1px;
    display: block;
  }
  #TagsCategory-main-area{
    position: absolute;
    width:100%;
    margin:2px auto;
    background-color: rgba(255,255,255,0.1);
    padding-left: 1px;
    padding-right: 1px;
    padding-bottom: 10px;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: center;
  }
}
</style>