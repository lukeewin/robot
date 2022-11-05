# 智能聊天机器人项目

#### 一、介绍

这是一个基于图灵接口开发的网页端智能聊天机器人项目，该项目为第二代。

v2.0版本对v1.0版本做了以下方面的优化：

1. 修复了手机端输入框和发送按钮发生位移的bug。

2. 增加看板娘功能（注：只有PC端才会显示看板娘）。

3. 增加统计功能，包括统计项目上线以来访问次数的统计，以及每天对图灵接口的调用的统计。

4. 增加实时在线人数显示功能。

目前还存在的问题:

1. 兼容性问题，推荐用户使用谷歌浏览器，使用其它浏览器可能会发生异常，目前已知，在火狐浏览器中无法输入，在edge浏览器中显示聊天框会发生位移。

2. 统计功能没有使用WebSocket长链接，也没有http轮询，所以不能及时更新次数。

#### 二、运行效果

[预览效果](http://robotchat.lukeewin.top)

PC端

![PC端效果](https://image.lukeewin.top/img/202211051944039.png)

手机端效果

![手机端效果](https://image.lukeewin.top/img/202211051947277.png)

#### 三、软件架构

本项目使用的技术栈：SpringBoot+MyBatis+MySQL+Thymeleaf+WebSocket。

项目使用Maven进行管理，所以要下载本项目到本地前，需要先确保本地中已经安装并配置好Maven环境。

#### 四、安装教程

1. 在idea开始页面中选择Check out from Version Control，点击Git，然后把git@github.com:lukeewin/robot.git粘贴到输入框中。

![导入项目](https://image.lukeewin.top/img/202211051951779.png)

2. 如果上面的的操作无法clone到本地，可以改用https://gitee.com/lukeewin/robot.git。

3. 创建一个robot.sql文件，复制并粘贴以下sql代码，把robot.sql文件导入到本地MySQL数据库中。

```sql
/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : robot

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 05/11/2022 19:32:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for access_record
-- ----------------------------
DROP TABLE IF EXISTS `access_record`;
CREATE TABLE `access_record`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `count` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '记录用户访问数量',
  `access_ip` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '记录客户端访问ip地址',
  `access_device` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '记录客户端访问设备',
  `access_time` datetime(0) NULL DEFAULT NULL COMMENT '记录客户端访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 169 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `count` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '记录每天接口调用次数',
  `access_time` datetime(0) NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 124 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
```

4. 打开idea中导入的项目，找到application-dev.yml文件，把数据库密码改为自己本地数据库的密码。

5. 修改application-dev.yml中的turing.apiKey，修改为自己申请的apiKey，申请网址http://www.turingapi.com/。

6. 到此为止就已经完全了项目导入本地idea的操作。

7. 如果想要把项目部署到服务器上，可以到B站观看我的部署教程，[点击这里跳转到部署教程](https://www.bilibili.com/video/BV1WD4y1t76H/?vd_source=191895ae67d8ed13743a8c6017cc8758)

#### 五、其它

1. 最后如果大家觉得这个项目很有意思，记得点一下Star，让更多的人发现该项目。

2. 更多文档内容可以到[我的博客](https://blog.lukeewin.top)中阅读。

3. 更多视频内容可以到[我的B站](https://space.bilibili.com/674558378?spm_id_from=333.788.0.0)中观看。