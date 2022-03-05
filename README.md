# robot

#### 介绍
这是一个人机对话项目

#### 软件架构
软件架构说明
本项目基于SpringBoot和Thymeleaf开发的人机对话项目。
前端通过ajax异步提交post请求到到后端。
后端通过调用图灵机器人api来获取返回的聊天文本内容。


#### 安装教程

1.  下载本项目到idea中。
2.  使用mvn package打包项目。
3.  或者使用idea中的maven插件进行打包。
4.  使用java -jar命令运行项目。

#### 使用说明

1.  可以免费直接使用，但推荐修改apiKey，把SendRequestService类中的userInfo.setApiKey("169e1daebd7a4138a7ec36e09af9aa43")的apiKay值改为自己apiKey。 这个apiKey可以从图灵中获取。先要去[图灵机器人官网](http://www.turingapi.com/)申请图灵机器人。

#### 预览效果

[人机对话](http://www.lukeewin.top:8080)


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
