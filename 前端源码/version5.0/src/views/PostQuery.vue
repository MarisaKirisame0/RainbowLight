<template>
  <div id="query-main-area">
    <HeadQuote QuoteIndex=1 class="QuoteBlock"/>
    <Filebox class="query-result" v-for="infos in query_result" :FileBoxInfo="infos"></Filebox>
    <div id="NextAndLastBlock">
      <PageButton v-if="LastButtonLiveFunction" @click="LastButtonRecall" ButtonContentText="Back" />
      <PageButton v-if="NextButtonLiveFunction" @click="NextButtonRecall" ButtonContentText="Next" />
    </div>
  </div>
</template>

<script>
/* 组件功能: 按照分类或者标签的文章查询详情页
*  组件使用状况: 已经投入使用 */

import axios from "axios";
import Filebox from "@/components/Filebox/Filebox";
import HeadQuote from "@/components/HeadQuote/HeadQuote";
import PageButton from "@/components/PageButton/PageButton";

export default {
name: "PostQuery",
  components: {
    PageButton,
    HeadQuote,
    Filebox,
  },
  props:{
  },
  data () {
  return{
    query_result:[],  //从后端按类型或者标签查询的文章列表结果
    PageIndex:1,      //查询结果的当前页码
    MaxPageIndex:2,   //从后端获取的数据库分页查询最大页码
  }
  },
  computed:{
    NextButtonLiveFunction:function (){
     /*return this.PageIndex < this.MaxPageIndex;*/
      return true;
    },
    LastButtonLiveFunction:function (){
      return this.PageIndex > 1;
    }
  },
  methods: {
    Query:function (){
      let _this = this;
      if(this.$route.query.qc === 'Type'){
        // 后端设置的Controller路径，按照指定Type查询获取文章第一页
        axios.get('/api/PageQuery/QueryTypeRecords?Type='+ _this.$route.query.qk + '&Index=' + _this.PageIndex)
            .then(function (response) {
              _this.query_result = response.data.PostList;
              _this.MaxPageIndex = response.data.MaxPageIndex;
            })
            .catch(function (error) {
              console.log(error);
            });
      }
      if(this.$route.query.qc === 'Tags'){
        // 后端设置的Controller路径，按照指定Tag查询获取文章第一页
        axios.get('/api/PageQuery/QueryTagsRecords?Tags='+ _this.$route.query.qk + '&Index=' + _this.PageIndex)
            .then(function (response) {
              _this.query_result = response.data.PostList;
              _this.MaxPageIndex = response.data.MaxPageIndex;
            })
            .catch(function (error) {
              console.log(error);
            });
      }
    },
    NextButtonRecall:function (){
      this.PageIndex = this.PageIndex + 1;
      this.Query();
    },
    LastButtonRecall:function (){
      this.PageIndex = this.PageIndex - 1;
      this.Query();
    },
    },
  created() {
  this.Query();
  }
}
</script>

<style scoped>
#query-main-area{
  width: 60%;
  padding-bottom: 20px;
  background-color: rgba(255,255,255,0.9);
  margin:20px auto;
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  justify-content: center;
  opacity: 0.9;
}
.query-result{
  margin: 10px 10px 10px 10px;
}
@media screen and (max-width: 650px){
  #query-main-area{
    position: absolute;
    top: 180px;
    width: 100%;
    padding-bottom: 20px;
    background-color: rgba(255,255,255,0.6);
    margin:0 auto;
  }
  .QuoteBlock{
    display: none;
  }
}
</style>