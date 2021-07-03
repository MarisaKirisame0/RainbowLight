<template>
  <div class="PageButtonBackground">
    <div class="PageButton">
      <p class="ButtonText">{{ButtonContentText}}</p>
    </div>
  </div>
</template>

<script>
export default {
name: "PageButton",
  props:{
  ButtonContentText:String,
  },
}
</script>

<style scoped>
@import "index.css";
</style>
