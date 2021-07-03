<template>
  <router-link class="router-link"
               :to="{path: '/postquery',query: {qc:query_condition, qk:query_keyword}}">
    <span :style="font_style" class="tag">{{tag.tagname}}</span>
  </router-link>
</template>

<script>
export default {
  name: "Tag",
  props:{
    index:Number,
    tag:JSON,
  },
  data (){
    return{
      query_condition:'Tags',
      query_keyword:this.tag.tagname,
      color:["maroon","deeppink", "crimson","fuchsia","blueviolet","violet","orangered","goldenrod","forestgreen",
        "mediumblue","deepskyblue","turquoise","darkcyan","black"],
      color_length:14,
    }
  },
  methods:{
    set_query_keyword(){

    },
  },
  computed:{
    font_style: function() {
      return  ("color:" + this.color[(this.index)%(this.color_length)] + ";");
    }
  },
}
</script>

<style scoped>
/*@import "../../assets/fonts/fonts.css";*/
@import "index.css";
</style>