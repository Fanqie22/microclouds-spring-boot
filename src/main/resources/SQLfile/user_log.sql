/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : microclouds

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2019-01-02 11:06:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_log
-- ----------------------------
DROP TABLE IF EXISTS `user_log`;
CREATE TABLE `user_log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `log_date` datetime DEFAULT NULL,
  `user_ip` varchar(32) DEFAULT NULL,
  `log_type` varchar(20) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL COMMENT '日志描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
