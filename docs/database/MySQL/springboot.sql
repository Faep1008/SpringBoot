/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : springboot

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 30/06/2020 13:59:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for salarydetail
-- ----------------------------
DROP TABLE IF EXISTS `salarydetail`;
CREATE TABLE `salarydetail`  (
  `rowguid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一标识',
  `userguid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户标识',
  `opratedate` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `outlay` decimal(10, 2) NULL DEFAULT NULL COMMENT '支出金额',
  `income` decimal(10, 2) NULL DEFAULT NULL COMMENT '收入金额',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型，1为收入，2为支出',
  PRIMARY KEY (`rowguid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salarydetail
-- ----------------------------
INSERT INTO `salarydetail` VALUES ('2b884f08-bbab-4c13-aad7-5082b94db173', '744396a7-f65d-4020-9aaf-fa6e93b29f30', '2020-06-30 13:47:15', NULL, 888.00, '1');
INSERT INTO `salarydetail` VALUES ('70d1c236-a192-47e3-94f1-5dd125d82d62', '744396a7-f65d-4020-9aaf-fa6e93b29f30', '2020-06-30 13:51:57', 222.00, NULL, '2');
INSERT INTO `salarydetail` VALUES ('8f42f2a6-05f8-4b26-91a3-263eab7eb19d', '744396a7-f65d-4020-9aaf-fa6e93b29f30', '2020-06-30 13:51:53', 222.00, NULL, '2');
INSERT INTO `salarydetail` VALUES ('f277aaf6-945b-47b8-8a51-31b09b750f72', '744396a7-f65d-4020-9aaf-fa6e93b29f30', '2020-06-30 13:48:02', 222.00, NULL, '2');
INSERT INTO `salarydetail` VALUES ('ff8042ca-03ee-4a7d-bdd1-03deaded9449', '744396a7-f65d-4020-9aaf-fa6e93b29f30', '2020-06-30 13:51:54', 222.00, NULL, '2');

-- ----------------------------
-- Table structure for totalsalary
-- ----------------------------
DROP TABLE IF EXISTS `totalsalary`;
CREATE TABLE `totalsalary`  (
  `rowguid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一标识',
  `totalsalary` decimal(10, 2) NULL DEFAULT NULL COMMENT '总资产',
  `opratedate` datetime(0) NULL DEFAULT NULL COMMENT '最近操作时间',
  `userguid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户标识',
  PRIMARY KEY (`rowguid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of totalsalary
-- ----------------------------
INSERT INTO `totalsalary` VALUES ('e88c2675-ef82-437c-a8d0-c537feb7cdee', 0.00, '2020-06-30 13:51:57', '744396a7-f65d-4020-9aaf-fa6e93b29f30');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `rowguid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一标识',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `loginid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户登录名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户登录密码',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `lastlogintime` datetime(0) NULL DEFAULT NULL COMMENT '最近登录时间',
  `enabled` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否允许登录（未锁定）1标识可以登录',
  PRIMARY KEY (`rowguid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('744396a7-f65d-4020-9aaf-fa6e93b29f30', 'Faep', 'Faep', '11111', '18888888888', '2020-06-18 09:54:43', '1');

SET FOREIGN_KEY_CHECKS = 1;
