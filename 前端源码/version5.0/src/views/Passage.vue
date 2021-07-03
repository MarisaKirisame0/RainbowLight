<template>
<div id="passage">
  <img id="passage-cover" :src="passage_cover_url" alt="Loading...">
  <div id="passage-main-area" v-html="passage_article" v-highlight></div>
</div>
</template>

<script>
/* 组件功能: 文章详情页
*  组件使用状况: 已经投入使用 */

import axios from "axios";
import globalVariable from '@/components/MathJax/globalVariable'

export default {
name: "Passage",
data(){
  return{
    passage_cover_url:"https://i.loli.net/2021/03/20/Q1hWdqNgb9p3eYG.jpg", //文章的封面的路径
    passage_article:"",   //文章内容
  }
 },
methods:{
  GetPassage:function (){
    let _this = this;
    // 端设置的Controller路径，获取相应的ID指定文章
    axios.get('/api/PageReading/GetArticleInfoByID?ArticleID='+ _this.$route.query.id)
        .then(function (response) {
          _this.passage_article = response.data.Content;
          _this.passage_cover_url = response.data.Info.cover;
        })
        .catch(function (error) {
          console.log(error);
        });
    if(globalVariable.isMathjaxConfig){
      globalVariable.initMathjaxConfig();
    }
    globalVariable.MathQueue("passage-main-area");//渲染文章里面的LaTeX公式
  },
},
created() {
  this.GetPassage();
  globalVariable.MathQueue("passage-main-area");
  },
  mounted(){
    this.$nextTick(function () { //这里要注意，使用$nextTick等组件数据渲染完之后再调用MathJax渲染方法，要不然会获取不到数据
      if(globalVariable.isMathjaxConfig){globalVariable.initMathjaxConfig();}
      globalVariable.MathQueue("passage-main-area");//传入组件id，让组件被MathJax渲染
    })
  },
  updated() {
    globalVariable.MathQueue("passage-main-area");
  },
}
</script>

<style lang="css" scoped>
#passage{
  width:60%;
  margin:20px auto;
  background-color: rgba(255,255,255,0.8);
  padding-left: 15px;
  padding-right: 20px;
  padding-bottom: 5px;
}
#passage-cover{
  width: 100%;
}
#passage-main-area >>> h1{
  font-family: FZSKBXKJW,sans-serif,"宋体",Serif;
  font-weight: bolder;
  font-size: 2.2rem;
  text-align: center;
}
#passage-main-area >>> h2{
  font-family: FZSKBXKJW,sans-serif,"宋体",Serif;
  font-weight: bolder;
  font-size: 1.8rem;
  display: inline-block;
}
#passage-main-area >>> h3{
  font-family: FZSKBXKJW,sans-serif,"宋体",Serif;
  font-weight: bolder;
  font-size: 2.2rem;
}
#passage-main-area >>> h4{
  font-family: FZSKBXKJW,sans-serif,"宋体",Serif;
  font-size: 2.0rem;
}
#passage-main-area >>> h5{
  font-family: FZSKBXKJW,sans-serif,"宋体",Serif;
  font-size: 1.7rem;
}
#passage-main-area >>> h6{
  font-family: "KaiTi",Serif,'Fira Code',sans-serif;
  font-size: 1.3rem;
}
#passage-main-area >>> p{
  font-family: FZSKBXKJW,sans-serif,"宋体",Serif;
  font-weight: normal;
  font-size: large;
}
#passage-main-area >>> li{
  font-family: FZSKBXKJW,sans-serif,"宋体",Serif;
}
#passage-main-area >>> pre{
  font-size: 1.0rem;
}
@media screen and (max-width: 650px) {
  #passage{
    position: absolute;
    top:180px;
    width:100%;
    margin:20px 0 0 0;
    background-color: rgba(255,255,255,0);
    padding-left: 0;
    padding-right: 0;
    padding-bottom: 10px;
  }
  #passage-main-area >>> h1{
    font-size: 2.0rem;
    padding-left: 5px;
    padding-right: 5px;
  }
  #passage-main-area >>> h2{
    font-size: 1.6rem;
    padding-left: 5px;
    padding-right: 5px;
  }
  #passage-main-area >>> h3{
    font-size: 1.6rem;
    padding-left: 5px;
    padding-right: 5px;
  }
  #passage-main-area >>> h4{
    font-size: 1.5rem;
    padding-left: 5px;
    padding-right: 5px;
  }
  #passage-main-area >>> h5{
    font-size: 1.3rem;
    padding-left: 5px;
    padding-right: 5px;
  }
  #passage-main-area >>> h6{
    font-size: 1.1rem;
    padding-left: 5px;
    padding-right: 5px;
  }
  #passage-main-area >>> p{
    font-weight: normal;
    font-size: medium;
    padding-left: 5px;
    padding-right: 5px;
  }
  #passage-main-area >>> pre{
    font-size: 1.1rem;
    padding: 0;
  }
}
</style>