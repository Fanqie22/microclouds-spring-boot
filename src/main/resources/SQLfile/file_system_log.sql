/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : microclouds

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-12 14:45:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for file_system_log
-- ----------------------------
DROP TABLE IF EXISTS `file_system_log`;
CREATE TABLE `file_system_log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `log_date` datetime DEFAULT NULL,
  `log_type` varchar(20) DEFAULT NULL,
  `file_name` varchar(150) DEFAULT NULL,
  `upload_status` varchar(20) DEFAULT NULL,
  `file_size` decimal(12,0) DEFAULT NULL,
  `del_flag` tinyint(1) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
