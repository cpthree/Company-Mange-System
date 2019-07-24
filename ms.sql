/*
Navicat MySQL Data Transfer

Source Server         : link
Source Server Version : 50644
Source Host           : localhost:3306
Source Database       : ms

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2019-07-25 07:34:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '人事部');
INSERT INTO `department` VALUES ('2', '项目部');
INSERT INTO `department` VALUES ('3', '财务部');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) NOT NULL,
  `login_password` varchar(255) NOT NULL,
  `real_name` varchar(255) NOT NULL,
  `sex_id` int(5) NOT NULL,
  `department_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `telephone` bigint(20) NOT NULL,
  `birth_date` datetime NOT NULL,
  `entry_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_name` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'hby', '123', '胡八一', '0', '1', '4', '15578915423', '1981-08-01 00:00:00', '2010-06-16 00:00:00');
INSERT INTO `employee` VALUES ('2', 'wkx', '123', '王凯旋', '0', '1', '3', '13984845612', '1983-08-04 00:00:00', '2010-08-18 00:00:00');
INSERT INTO `employee` VALUES ('3', 'xly', '123', 'shiry杨', '1', '3', '4', '18845621845', '1988-07-06 00:00:00', '2012-05-10 00:00:00');
INSERT INTO `employee` VALUES ('4', 'wx', '456', '吴邪', '0', '2', '1', '18845612138', '1994-06-03 00:00:00', '2016-01-02 00:00:00');
INSERT INTO `employee` VALUES ('6', 'xg', '456', '小哥', '0', '2', '3', '13946412856', '1991-07-19 00:00:00', '2014-02-03 00:00:00');
INSERT INTO `employee` VALUES ('8', 'pz', '456', '胖子', '0', '2', '2', '18845612138', '1987-10-30 00:00:00', '2015-12-31 00:00:00');
INSERT INTO `employee` VALUES ('9', 'zmz', '789', '张牧之', '0', '3', '4', '13645874569', '1978-10-25 00:00:00', '2010-01-31 00:00:00');
INSERT INTO `employee` VALUES ('10', 'mbd', '789', '马邦德', '0', '3', '2', '13946412856', '1979-12-21 00:00:00', '2010-12-01 00:00:00');
INSERT INTO `employee` VALUES ('11', 'hsl', '789', '黄四郎', '0', '3', '4', '15514578945', '1975-09-30 00:00:00', '2010-12-26 00:00:00');

-- ----------------------------
-- Table structure for `finance`
-- ----------------------------
DROP TABLE IF EXISTS `finance`;
CREATE TABLE `finance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pay_name` varchar(255) DEFAULT NULL,
  `pay_advance` double(20,2) DEFAULT NULL,
  `pay_total` double(20,2) DEFAULT NULL,
  `pay_state` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of finance
-- ----------------------------
INSERT INTO `finance` VALUES ('1', '万达城', '36154.12', '105784.91', '1');
INSERT INTO `finance` VALUES ('2', '迪士尼', '51154.12', '204874.56', '2');

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `land_area` bigint(20) NOT NULL,
  `build_area` bigint(20) NOT NULL,
  `floor` int(11) NOT NULL,
  `eia_people` varchar(255) DEFAULT NULL,
  `permit` varchar(255) DEFAULT NULL,
  `audit_flag` int(11) NOT NULL,
  `success_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '万达城', '万达广场A座', '8263400', '63005', '34', '', '', '0', '2017-08-19 16:25:00');
INSERT INTO `project` VALUES ('2', '迪士尼', '香港旺角', '7354500', '76000', '29', '', '', '2', '2017-08-19 12:21:24');
INSERT INTO `project` VALUES ('5', '环贸公馆', '中央大街', '467544', '12134', '31', '', '', '2', '2017-08-19 12:47:35');
INSERT INTO `project` VALUES ('6', '精绝古城', '沙漠戈壁', '1354123', '456423', '9', '', '', '1', '2017-08-19 14:44:25');

-- ----------------------------
-- Table structure for `project_attachment`
-- ----------------------------
DROP TABLE IF EXISTS `project_attachment`;
CREATE TABLE `project_attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_id` bigint(20) NOT NULL,
  `file_name` varchar(255) NOT NULL,
  `file_path` varchar(255) NOT NULL,
  `createby` bigint(20) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `project_attachment_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_attachment
-- ----------------------------
INSERT INTO `project_attachment` VALUES ('29', '2', '6 遗留问题.txt', 'E:\\fileput\\20170819092638_6 遗留问题.txt', '4', '2017-08-19 09:26:38');
INSERT INTO `project_attachment` VALUES ('30', '1', '6 遗留问题.txt', 'E:\\fileput\\20170819102935_6 遗留问题.txt', '4', '2017-08-19 10:29:35');

-- ----------------------------
-- Table structure for `report`
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `report_name` varchar(255) DEFAULT NULL,
  `cost` double(20,2) DEFAULT NULL,
  `price` double(20,2) DEFAULT NULL,
  `profit` double(20,2) DEFAULT NULL,
  `tax_profit` double(20,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES ('1', '万达城', '2001546.00', '5004786.00', '3003457.00', '1602138.00');
INSERT INTO `report` VALUES ('2', '迪士尼', '2401546.00', '6012148.45', '3458754.18', '2001548.00');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '实习生');
INSERT INTO `role` VALUES ('2', '正式员工');
INSERT INTO `role` VALUES ('3', '组长');
INSERT INTO `role` VALUES ('4', '经理');
