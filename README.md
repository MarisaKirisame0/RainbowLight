# RainbowLight博客系统

Time：2021-07-03

Author：霜星酱

###### 前言

从2020年底开始自学全栈技术，最终做了一个前后端分离的博客系统，搭建了自己的个人网站，也是比较满意了，达到了偶尔自己浏览也可以会心一笑的程度。

前端基础(html、css、js)是W3C网站自学的，框架技术都是在bilibili网站学的，几乎全套(Webpack、Vue)看的是CodeWhy老师，也有看李江南大师的Vue教程。后端是自己看书学的，看的是Java8实用教程，学完java，去看bilibili的尚硅谷快速入门了Springboot。

个人网站：[雾雨霜星 | DA☆ZE (shuangxing.top)](https://www.shuangxing.top)



## 系统介绍

前后端分离工程，实际的源码工程项目，目前还未开发兼容Hexo等其余博客平台。

需要自己准备服务器，分别部署前端工程和后端工程。

 "虹光"(RainbowLight)：一款具有二次元风格的博客主题，采用前后端分离的技术栈进行实现。 

前端：Vue框架，VueCLI4.5工程。采用Axios与后端交互；采用highlight.js实现代码高亮；加入Valine评论系统。

后端：Spring框架，SpringBoot工程。采用MyBatisPlus与MySQL数据库进行交互；加入SpringSecurity。



## 前端自改提示：

1. 需要具备NodeJs的开发环境，使用npm进行模块安装的包管理。
2. 需要具备VueCLI4.5的开发环境，使用npm安装即可。
3. 需要安装Axios，使用npm安装即可。
4. 在App.vue里面的mounted方法处设置loading动画的时长，目前已经从9s设置到4s。
5. 评论系统设置：Comment.vue组件中找到SetValineObject函数，在其内进行配置，用的是Valine，需要自备LeanCloud账户。
6. 网站浏览器页标题：index.html中修改title标签内容。
7. 其余均写明注释。
8. 没有使用jQuery。



## 后端自改提示：

1. 需要具备jdk1.8开发环境。

2. 安装MySQL并建立自己的数据库，需要设置数据库4个表格：

   articles、friendlink、tags、types

   各个表格设置字段：

   * articles：

     | id   | name | address | time | type | tags | clicktimes | cover | introduction |
     | ---- | ---- | ------- | ---- | ---- | ---- | ---------- | ----- | ------------ |
     |      |      |         |      |      |      |            |       |              |

   * friendlink：

     | name | url  | info | content | avatar | id   |
     | ---- | ---- | ---- | ------- | ------ | ---- |
     |      |      |      |         |        |      |

   * tags：

     | id   | tagname | usetimes | articles_id |
     | ---- | ------- | -------- | ----------- |
     |      |         |          |             |

   * types：

     | id   | typename | usetimes | articles_id |
     | ---- | -------- | -------- | ----------- |
     |      |          |          |             |

   相应的各个字段的类型，可以在后端工程的bean文件中查找到，表格名就是class，属性变量的数据类型即相应的数据库字段数据类型。

3. 在后端工程的application.xml(resource文件夹中)中设置自己数据库的连接路径和账户信息。

   不设置或者设置错误均无法启动后端应用，出现报错。



## 部署

具体的部署过程可以参考我的文章：

前后端部署：https://www.shuangxing.top/#/passage?id=18



## 鸣谢

前端主题是仿照 蝉时雨 的，附上其个人网站：[蝉時雨 | 蝉鸣如雨 花宵道中 (chanshiyu.com)](https://chanshiyu.com/#/)

也正是蝉时雨大佬，说清楚了目前国内技术环境，让我坚决走上后端使用spring框架的道路。

前端许多样式仿照而已，代码我自己写的。所以相比于蝉时雨大佬，我对各个实例方法不熟悉，在源码工程的可读性和效率方面肯定比不上他，可以前去学习，那是他的自己的博客主题：Auroa，在其github开源了源码。

RainbowLight也是对Auroa的致敬。

在搭建网站过程给予我帮助的还有许多后端群友，以及几位大佬解答我在前端方面诸多疑惑。

实在不易，在此感谢。