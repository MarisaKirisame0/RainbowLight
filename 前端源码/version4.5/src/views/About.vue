<template>
  <div id="About">
    <div id="Me">
      <Myself/>
    </div>
    <div class="Info-block" style="border-top:1px solid mediumorchid">
      <div class="label" style="color: mediumorchid; background-color: mediumorchid;">
        <span class="label-text">Origin</span>
      </div>
      <p class="Info-block-text">&emsp;&emsp;雾间觉雨，霜空望星。<br/><br/>

        。。。。自我介绍

      </p>
    </div>
    <div class="Info-block" style="border-top:2px solid navajowhite">
      <div class="label" style="color: navajowhite; background-color: navajowhite;">
        <span class="label-text">Theme</span>
      </div>
      <p class="Info-block-text">
        &emsp;&emsp;萌新初学Web开发，第一次个人建站 <span style="text-decoration: line-through">(练手项目)</span>。在制作该网站时，把主题为Auroa的<a href="https://chanshiyu.com/#/" target="_blank" style="color: blueviolet;text-decoration: none">蝉时雨</a>的个人网站作为了实现的目标站，大量地方都复现了Auroa主题的样式，也加入了一些自己想到的创意。<br/><br/>
        &emsp;&emsp;前端采用VueCLI4.5进行搭建，没有引入jQUery依赖，动画依赖Vue的过渡与CSS进行完成，代码高亮使用Highlight.js。由于工程没有使用ui框架，很多样式我写的不尽其美，最终也包含了大量的CSS。前端采用Axios与后端进行交互，Markdown文章的解析是交由后端完成的。<br/>
        &emsp;&emsp;后端采用SpringBoot框架，结合MyBatisPlus插件进行搭建，数据库使用MySQL。目前的方法是文章托管于本地服务器，也可以修改为托管到GitHub或者Gitee，那样需要增加Java后端中网络数据访问，配合是可以自由搭建后端仓库的。<br/><br/>
        &emsp;&emsp;主题名为“RainbowLight”(虹光)。<br/>
        &emsp;&emsp;博客的前端后端工程已经开源到了我的<a href="https://gitee.com/marisa-kirisame" target="_blank" style="color: blueviolet;text-decoration: none"> Gitee </a>和<a href="https://github.com/MarisaKirisame0" target="_blank" style="color: blueviolet;text-decoration: none"> Github </a>上，可以免费食用。
      </p>
    </div>
    <div class="Info-block" style="border-top:2px solid pink">
      <div class="label" style="color: pink; background-color: pink;">
        <span class="label-text">TimeLine</span>
      </div>
      <p class="Info-block-text">
        。。。时间线
      </p>
    </div>
    <div class="Info-block" style="border-top:2px solid turquoise">
      <div class="label" style="color: turquoise; background-color: turquoise;">
        <span class="label-text">MySelf</span>
      </div>
      <p id="Info-block-text-Myself" class="Info-block-text">
        &emsp;Mail:&emsp;？？？？？&nbsp;<br/>
        &emsp;Gitee:&emsp;https://gitee.com/marisa-kirisame&nbsp;<br/>
        <br/>
        &emsp;Verloren sei uns der Tag,&nbsp;&nbsp;wo nicht Ein Mal getanzt wurde!<br/>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;——Friedrich Wilhelm Nietzsche
      </p>
    </div>
  </div>
</template>
<script>
/* 组件功能: 关于我页面
*  组件使用状况: 已经投入使用 */

import Myself from "@/components/Myself/Myself";
import SvgIcon from "@/svgIcon";
export default {
  components: {
    SvgIcon,
    Myself,
  }
}
</script>
<style>
#About{
  width:60%;
  margin:20px auto;
  padding: 5px 10px 10px 10px;
  background-color: rgba(255,255,255,0.9);
}
#Me{
  padding-left: 20px;
  padding-right: 20px;
}
.Info-block{
  position: relative;
  Margin-top:20px;
  Margin-left: 25px;
  Margin-right: 25px;
  padding-top: 10px;
  padding-bottom: 10px;
  box-shadow: 0 2px 10px lightgray;
  background-color: rgba(255,255,255,0.9);
  transition-property: all;
  transition-duration: 0.5s;
  font-family: Gabriola,cursive,FZKTJW,Serif,"宋体",Serif;
  font-size: larger;
}
.Info-block:hover{
  bottom: 1px;
  box-shadow: 0 10px 20px lightgray;
}
.Info-block-text{
  padding-left: 7px;
  padding-right: 7px;
}
#Info-block-text-Myself{
  font-size: larger;
}
.InfoTextTime{
  font-size:larger;
}
.Origin-text{
}
.label{
  width:10%;
  left:-16px;
  display:inline-block;
  margin: auto;
  padding-top: 5px;
  padding-bottom: 5px;
  position: relative;
  text-align: center;
}
.label:after{
  content: "";
  position: absolute;
  left: 0;
  top: 100%;
  width: 0;
  height: 0;
  border-style: solid;
  border-width: 0 16px 16px 0;
  border-color: transparent;
  border-right-color: currentColor;
  filter: brightness(120%);
}
.label-text{
  margin: auto;
  color: 	white;
  font-size: larger;
  letter-spacing: 1px;
}
@media screen and (max-width: 650px) {
  #About{
    position: absolute;
    top: 180px;
    width:100%;
    margin:0 auto;
    padding: 7px 0 10px 0;
    background-color: rgba(255,255,255,0.9);
  }
  .label{
    width:90px;
  }
  .label-text{
    font-size: large;
  }
  .Info-block{
    position: relative;
    Margin-top:20px;
    Margin-left: 10px;
    Margin-right: 10px;
    box-shadow: 0 0 0;
    font-family: FZKTJW,Serif,Arial,cursive,"宋体",Serif;
    font-size: large;
    transition-property: none;
  }
  #Info-block-text-Myself{
    font-size: medium;
  }
  .InfoTextTime{
    font-size:large;
  }
}
</style>