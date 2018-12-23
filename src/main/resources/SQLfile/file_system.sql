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

 Date: 23/12/2018 23:44:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for file_system
-- ----------------------------
DROP TABLE IF EXISTS `file_system`;
CREATE TABLE `file_system`  (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '文件系统表的自增id',
  `user_id` int(11) UNSIGNED NOT NULL COMMENT '文件所属的用户',
  `pid` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '文件对应的父节点',
  `file_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `file_type` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件的类型,文件夹为\'folder\'',
  `file_size` decimal(12, 2) UNSIGNED NULL DEFAULT NULL COMMENT '文件大小,以KB 为单位',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间,自动',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `file_icon` smallint(5) UNSIGNED NULL DEFAULT NULL COMMENT '文件类型对应的图标',
  `del_flag` smallint(5) UNSIGNED NULL DEFAULT NULL COMMENT '状态,0-正常,1-已被删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
