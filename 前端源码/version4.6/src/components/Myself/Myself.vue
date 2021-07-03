<template>
  <div id="Myself-main-area">
    <div id="AvatarImageBlock">
    <span class="author-image-span">
      <img id="Author-Image" :src="Avatar" alt="想看本人什么的不可能的">
    </span>
    </div>
    <div id="DetailInfoBlock">
      <svg-icon class="svg-icon" data_iconName="github-alt" className="github-alt_icon"></svg-icon>
      <span id="AuthorName">雾雨霜星</span><br/>
      <svg-icon class="svg-icon" data_iconName="connectdevelop" className="connectdevelop_icon" />
      <span id="Signature">雾间觉雨，霜空望星</span><br/>
      <svg-icon class="svg-icon" data_iconName="safari" className="building_icon" />
      <span id="Location">地区: 粤中</span><br/>
      <svg-icon class="svg-icon" data_iconName="group" className="group_icon" />
      <span id="University">South China University of Technology(SCUT)</span><br/>
      <svg-icon class="svg-icon" data_iconName="graduation-cap" className="graduation-cap_icon"></svg-icon>
      <span id="profession">Electrical Engineering and Automation</span><br/>
    </div>
  </div>
</template>

<script>
export default {
  name: "Myself",
  data(){
    return{
      Avatar:"http://marisa-kirisame.gitee.io/phw/Avatar/Avatar.jpg",
    }
  }
}
</script>

<style scoped>
/*@import "../../assets/fonts/fonts.css";*/
@import "index.css";
</style>