/*
Navicat MySQL Data Transfer

Source Server         : 12
Source Server Version : 50558
Source Host           : 10.3.105.8:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2018-08-04 14:20:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', '21');
INSERT INTO `person` VALUES ('2', '12');
INSERT INTO `person` VALUES ('3', '121');
INSERT INTO `person` VALUES ('6', '16');
INSERT INTO `person` VALUES ('5', '1');
INSERT INTO `person` VALUES ('4', '13');
