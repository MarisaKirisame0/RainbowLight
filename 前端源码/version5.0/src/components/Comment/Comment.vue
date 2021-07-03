<template>
  <div>
    <div id="vcomments"></div>
  </div>
</template>

<script>
/* 组件功能: 评论留言组件
*  组件使用状况: 已经投入使用
*  组件具体使用地方: LeftMessage */

export default {
 name: "Comment",
 methods:{
   /* 该函数用于在vue组件内部引入外联js，valine使用外部js不进行下载 */
   GetValineJS:function (){
     const s = document.createElement('script');
     s.type = 'text/JavaScript';
     s.src = 'Valine.min.js';
     document.body.appendChild(s);
   },
   /* 该函数用于创建valine对象，配置相关内容，从而实现评论留言区域可视化
   相关参数请参考valine官方文档
   * */
  SetValineObject:function (){
    new Valine({
      el: '#vcomments',
      enable:true,
      /* 此app设置自己的LenCLoud上应用的Id和Key */
      appId:'',
      appKey:'',
      /* 此路径指定自己的LenCLoud上设置的二级域名 */
      serverURLs: '',
      placeholder:'既然来了，说点什么吧~',
      requiredFields:['nick'],
    })
  }
 },
 created() {
   this.GetValineJS();
 },
  mounted() {
   this.SetValineObject();
 }
}
</script>

<style>

</style>