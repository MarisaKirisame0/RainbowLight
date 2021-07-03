<template>
  <div id="FilePlaceBlock" v-if="FilePlaceFlag">
    <HeadQuote QuoteIndex=0 class="QuoteBlock"/>
    <div id="file-place">
      <Filebox class="file-place-box" v-for="(infos, index) in passage_file" :FileBoxInfo="infos"></Filebox>
    </div>
    <div id="NextAndLastBlock">
      <PageButton v-if="LastButtonLiveFunction" @click="LastButtonRecall" ButtonContentText="Back" />
      <PageButton v-if="NextButtonLiveFunction" @click="NextButtonRecall" ButtonContentText="Next" />
    </div>
  </div>
</template>

<script>
/* 组件功能: 归档页面
*  组件使用状况: 已经投入使用 */

import axios from 'axios';
import Filebox from "@/components/Filebox/Filebox";
import HeadQuote from "@/components/HeadQuote/HeadQuote";
import PageButton from "@/components/PageButton/PageButton";

export default {
name: "Fileplace",
  data (){
    return{
      LoadingLiveFlag:true,/* 控制Axios请求的Loading动画显示与否的变量 */
      FilePlaceFlag:false, /* 控制FilePlace区域显示与否的变量 */
      passage_file:"",
      PageIndex:1,
      NextButtonLiveFlag:true,
    }
  },
  components:{
    HeadQuote,
    Filebox,
    PageButton
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
  methods:{
    NextButtonRecall:function (){
      this.PageIndex = this.PageIndex + 1;
      let _this = this;
      axios.get('/api/PageReading/GetArticleInformationListByPage?AriticlesListPage='+_this.PageIndex)
          .then(function (response) {
            _this.passage_file = response.data;
          })
          .catch(function (error) {
            console.log(error);
          });
    },
    LastButtonRecall:function (){
      this.PageIndex = this.PageIndex - 1;
      let _this = this;
      axios.get('/api/PageReading/GetArticleInformationListByPage?AriticlesListPage='+_this.PageIndex)
          .then(function (response) {
            _this.passage_file = response.data;
          })
          .catch(function (error) {
            console.log(error);
          });
    },
  },
  created(){
    let _this = this;
    axios.get('/api/PageReading/GetArticleInformationListByPage?AriticlesListPage=' + _this.PageIndex)
        .then(function (response) {
          _this.passage_file = response.data;
          _this.LoadingLiveFlag = false;
          _this.FilePlaceFlag = true; //显示查询结果
        })
        .catch(function (error) {
          console.log(error);
          return error;
        });
  },
}
</script>

<style scoped>
#FilePlaceBlock{
  width:60%;
  margin:20px auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
  flex-wrap: wrap;
  background-color: rgba(255,255,255,0.8);
}
.QuoteBlock{
  margin:auto;
}
#file-place{
  width:100%;
  margin:20px auto;
  padding-top: 5px;
  padding-bottom: 20px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  flex-wrap: wrap;
}
.file-place-box{
  margin: 10px 10px 5px 0;
  width: 45%;
  height: 100px;
}
@media screen and (max-width: 650px) {
  #FilePlaceBlock{
    width:100%;
    padding-top: 5px;
    padding-bottom: 20px;
    margin:0 auto;
    background-color: rgba(255,255,255,0);
  }
  #file-place{
    position: absolute;
    top: 180px;
    width:100%;
    background-color: rgba(255,255,255,0.5);
    margin:0 auto;
    padding-top: 5px;
    padding-bottom: 20px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    flex-wrap: wrap;
  }
  .file-place-box{
    margin: 10px 10px 5px 0;
    width: 100%;
    height: 100px;
  }
  #NextAndLastBlock{
    position: absolute;
    left:37%;
    top: 700px;
    margin:0;
  }
}
</style>