import Vue from "vue"
import svgIcon from "./index.vue"


//下面这个是导入svgIcon/svg下的所有svg文件
const requireAll = requireContext => requireContext.keys().map(requireContext)
const req = require.context('./svg', false, /\.svg$/)
requireAll(req);