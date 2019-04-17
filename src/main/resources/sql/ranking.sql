/*
Navicat MySQL Data Transfer

Source Server         : just
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : ranking

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-04-17 21:33:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for scoreflow
-- ----------------------------
DROP TABLE IF EXISTS `scoreflow`;
CREATE TABLE `scoreflow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(3) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL DEFAULT '0',
  `username` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of scoreflow
-- ----------------------------
INSERT INTO `scoreflow` VALUES ('4', '10', '1', 'kitty');
INSERT INTO `scoreflow` VALUES ('5', '10', '1', 'kitty');
INSERT INTO `scoreflow` VALUES ('6', '10', '1', 'kitty');
INSERT INTO `scoreflow` VALUES ('7', '10', '1', 'kitty');
INSERT INTO `scoreflow` VALUES ('8', '15', '2', 'mike');
INSERT INTO `scoreflow` VALUES ('9', '5', '3', 'tom');
INSERT INTO `scoreflow` VALUES ('10', '55', '4', 'simm');
INSERT INTO `scoreflow` VALUES ('11', '65', '5', 'luccy');
INSERT INTO `scoreflow` VALUES ('12', '10', '2', 'mike');

-- ----------------------------
-- Table structure for userscore
-- ----------------------------
DROP TABLE IF EXISTS `userscore`;
CREATE TABLE `userscore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(3) NOT NULL DEFAULT '0',
  `user_score` int(10) NOT NULL DEFAULT '0',
  `name` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of userscore
-- ----------------------------
INSERT INTO `userscore` VALUES ('1', '1', '40', 'kitty');
INSERT INTO `userscore` VALUES ('2', '2', '25', 'mike');
INSERT INTO `userscore` VALUES ('3', '3', '5', 'tom');
INSERT INTO `userscore` VALUES ('4', '4', '55', 'simm');
INSERT INTO `userscore` VALUES ('5', '5', '65', 'luccy');
