/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : microclouds

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 01/01/2019 18:32:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id,唯一标识用户',
  `user_mail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户的账户,邮箱或者手机号',
  `password` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户的密码,使用MD5加密',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的角色',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `del_flag` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '状态,0-正常,1-已被删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1393203396@qq.com', '31d1a5bfffe8639abcec1b739edbb2fb', 'Fanqie22', 'user', '2018-12-30 05:10:48', NULL, NULL);
INSERT INTO `user` VALUES (2, '731856222@qq.com', '31d1a5bfffe8639abcec1b739edbb2fb', 'Murphy', 'user', '2018-12-30 05:12:48', NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
