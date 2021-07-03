<template>
  <div id="FriendLink-MainArea">
    <div id="FriendLinkInfo-Area">
      <p class="InfoText" id="InfoHead"><strong>欢迎来到我的小站！交个朋友，交换友链吗？╰(*°▽°*)╯</strong></p>
      <p class="InfoText"><strong>title</strong>: 雾雨霜星</p>
      <p class="InfoText"><strong>link</strong>: http://www.shuangxing.top</p>
      <p class="InfoText"><strong>intro</strong>: 雾间觉雨，霜空望星</p>
      <p class="InfoText"><strong>avatar</strong>: http://marisa-kirisame.gitee.io/phw/Avatar.jpg</p>
      <p class="InfoText"><strong>contact me</strong>: 2496760896@qq.com</p>
    </div>
    <div id="FriendLinkBox-Area">
      <Friend v-for="(FriendInfo, index) in FriendLinkGroup" :Friend="FriendInfo" />
    </div>
  </div>
</template>

<script>
/* 组件功能: 友链页面
*  组件使用状况: 已经投入使用 */

import axios from "axios";
import Friend from "@/components/Frinend/Friend";

export default {
  name: "FriendLink",
  data(){
    return{
      FriendLinkGroup:[],
    }
  },
  components:{
    Friend,
  },
  created() {
    let _this = this;
    axios.get('/api/PageReading/GetFriendLink')
        .then(function (response) {
          _this.FriendLinkGroup = response.data;
          console.log(_this.FriendLinkGroup)
        })
        .catch(function (error) {
          console.log(error);
        });
  }
}
</script>

<style scoped>
#FriendLink-MainArea{
  margin: 20px auto;
  padding-top: 5px;
  width: 60%;
  background-color: rgba(255,255,255,0.8);
  padding-bottom: 20px;
}
#FriendLinkInfo-Area{
  padding: 20px 10px 10px 10px;
  backdrop-filter:blur(25px);
  font-family: "FZKTJW",serif;
  font-size: large;
}
.InfoText{
  color: blueviolet;
  margin: 0;
  padding: 1px 0;
}
#InfoHead{
  padding: 10px 0 10px 0;
}
#FriendLinkBox-Area{
  padding: 10px 10px 10px 10px;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: left;
}
@media screen and (max-width: 650px) {
  #FriendLink-MainArea{
    position: absolute;
    margin: 0 auto;
    top: 180px;
    width: 100%;
  }
  #FriendLinkInfo-Area{
    font-size: medium;
  }
}
</style>