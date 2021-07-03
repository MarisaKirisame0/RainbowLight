module.exports = {
  publicPath: './',
  outputDir: 'dist',  //build输出目录
  assetsDir: 'assets', //静态资源目录（js, css, img）
  lintOnSave: false, //是否开启eslint
  devServer: {
    open: true, //是否自动弹出浏览器页面
    host: "localhost", //表示启动的时候使用的域名，默认可以不写，则是使用localhost和本机IP
    port: '8081', // 设置端口号
    https: false,  //是否使用https协议
    hotOnly: true, //是否开启热更新
    proxy: {
      '/api': {
        target: 'http://localhost:8080/', //API服务器的地址
        ws: true, //代理websockets
        changeOrigin: true, // 是否跨域，虚拟的站点需要更管origin
        pathRewrite: {
          '^/api5': '/api',
          '^/api': '',
        }
      },
    },
  },
  chainWebpack: config => {
    const svgRule = config.module.rule("svg");
    svgRule.uses.clear();
    svgRule
        .use("svg-sprite-loader")
        .loader("svg-sprite-loader")
        .options({
          symbolId: "icon-[name]"
        });
  },
}