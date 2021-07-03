<template>
  <a class="FriendLink" :href="FriendURL" target="_blank">
    <div class="FriendBlock">
      <img class="Friend-Avatar" :src="FriendAvatar"/>
      <div class="Friend-Name">{{Friend.name}}</div>
      <div class="Friend-Info">{{Friend.info}}</div>
    </div>
  </a>
</template>

<script>
/* 组件功能: 友链页面每个友链方块的组件
*  组件使用状况: 已经投入使用
*  组件具体使用地方: Friend.vue */

export default {
name: "Friend",
  props:{
  Friend:JSON,
  },
  data(){
  return{
    FriendURL:this.Friend.url,
    FriendAvatar:this.Friend.avatar,
  }
  },
  created() {
  }
}
</script>

<style scoped>
/*@import "../../assets/fonts/fonts.css";*/
@import "index.css";
</style>