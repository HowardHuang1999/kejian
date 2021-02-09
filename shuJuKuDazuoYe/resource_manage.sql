/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : resource_manage

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 29/05/2020 15:15:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cmessage
-- ----------------------------
DROP TABLE IF EXISTS `cmessage`;
CREATE TABLE `cmessage`  (
  `ID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `manageName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `managePhone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `graduation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cmessage
-- ----------------------------
INSERT INTO `cmessage` VALUES ('No.0001', '一号单位', '一号联系人', '18666666666', '30', '本科及以上', '游戏开发');
INSERT INTO `cmessage` VALUES ('No.0002', '二号单位', '10000000000', '10000000000', '1', '硕士及以上', '保安');
INSERT INTO `cmessage` VALUES ('No.0003', '三号单位', '三号联系人', '33333333333', '3', '博士', '清洁阿姨');
INSERT INTO `cmessage` VALUES ('No.1574', '哈哈集团', '狗蛋', '14517896545', '30', '本科及以上', '全栈');
INSERT INTO `cmessage` VALUES ('No.2654', '花花世界', 'Hua', '1451698565', '23', '本科及以上', '前端工程师');

-- ----------------------------
-- Table structure for qiuzhi
-- ----------------------------
DROP TABLE IF EXISTS `qiuzhi`;
CREATE TABLE `qiuzhi`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `companyid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `success` int(2) NOT NULL DEFAULT 0,
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userid`(`userid`) USING BTREE,
  INDEX `companyid`(`companyid`) USING BTREE,
  CONSTRAINT `qiuzhi_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `umessage` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `qiuzhi_ibfk_2` FOREIGN KEY (`companyid`) REFERENCES `cmessage` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qiuzhi
-- ----------------------------
INSERT INTO `qiuzhi` VALUES (9, '441422199802365412', 'No.2654', 0, '前端工程师');
INSERT INTO `qiuzhi` VALUES (13, '445555555555555555', 'No.0001', 1, '游戏开发');
INSERT INTO `qiuzhi` VALUES (14, '441111111111111111', 'No.0002', 1, '保安');
INSERT INTO `qiuzhi` VALUES (15, '333333333333333333', 'No.0003', 1, '清洁阿姨');

-- ----------------------------
-- Table structure for umessage
-- ----------------------------
DROP TABLE IF EXISTS `umessage`;
CREATE TABLE `umessage`  (
  `ID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `graduation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of umessage
-- ----------------------------
INSERT INTO `umessage` VALUES ('333333333333333333', '三号求职', '三号地址', '33333333333', '博士', '清洁阿姨');
INSERT INTO `umessage` VALUES ('441111111111111111', '二号求职', '二号地址', '1777777777', '硕士', '保安');
INSERT INTO `umessage` VALUES ('441422185905162351', '张三', '广东省广州市花都', '14517815222', '硕士', '算法工程师');
INSERT INTO `umessage` VALUES ('441422199802365412', '李四', '广东省广州市天河区', '17819632563', '本科', '算法工程师');
INSERT INTO `umessage` VALUES ('445555555555555555', '一号求职', '一号地址', '18888888888', '本科', '游戏开发');

-- ----------------------------
-- View structure for success_table
-- ----------------------------
DROP VIEW IF EXISTS `success_table`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `success_table` AS select `umessage`.`name` AS `name`,`cmessage`.`company` AS `company`,`qiuzhi`.`success` AS `success` from ((`qiuzhi` left join `umessage` on((`umessage`.`ID` = `qiuzhi`.`userid`))) left join `cmessage` on((`cmessage`.`ID` = `qiuzhi`.`companyid`)));

SET FOREIGN_KEY_CHECKS = 1;
