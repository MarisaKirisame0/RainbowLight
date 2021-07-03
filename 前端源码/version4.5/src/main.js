import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import hljs from "highlight.js"

/*import 'highlight.js/styles/github-gist.css'*/
import 'highlight.js/styles/atelier-seaside-light.css'

import '@/svgIcon/index.js'
import svgIcon from "@/svgIcon/index.vue";

/*createApp(App).use(router).mount('#app')*/

const app = createApp(App)
app.use(router)
app.component('svg-icon',svgIcon)
app.mount('#app')

// 定义一个全局指令 v-highlight:用于显示代码高亮
app.directive('highlight',function (el) {
    let blocks = el.querySelectorAll('pre code');
    blocks.forEach((block)=>{
        hljs.highlightBlock(block)
    })
})