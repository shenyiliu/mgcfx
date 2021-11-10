/*
 Navicat Premium Data Transfer

 Source Server         : admin
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : pear-admin

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 07/11/2021 21:36:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gp_mgc
-- ----------------------------
DROP TABLE IF EXISTS `gp_mgc`;
CREATE TABLE `gp_mgc`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `mgc_num` bigint NULL DEFAULT 0 COMMENT '次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '高频敏感词表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of gp_mgc
-- ----------------------------
INSERT INTO `gp_mgc` VALUES (1, '领导', 0);
INSERT INTO `gp_mgc` VALUES (2, '1', 0);
INSERT INTO `gp_mgc` VALUES (3, '信息', 0);
INSERT INTO `gp_mgc` VALUES (4, '招聘', 0);
INSERT INTO `gp_mgc` VALUES (5, '电话', 0);
INSERT INTO `gp_mgc` VALUES (6, '分析', 0);
INSERT INTO `gp_mgc` VALUES (7, '的', 0);
INSERT INTO `gp_mgc` VALUES (8, '52', 0);
INSERT INTO `gp_mgc` VALUES (9, '53', 0);
INSERT INTO `gp_mgc` VALUES (10, '54', 0);
INSERT INTO `gp_mgc` VALUES (11, '本', 0);
INSERT INTO `gp_mgc` VALUES (12, '政治', 0);
INSERT INTO `gp_mgc` VALUES (13, '装修', 0);
INSERT INTO `gp_mgc` VALUES (14, '领导', 0);
INSERT INTO `gp_mgc` VALUES (15, '1', 0);
INSERT INTO `gp_mgc` VALUES (16, '信息', 0);
INSERT INTO `gp_mgc` VALUES (17, '招聘', 0);
INSERT INTO `gp_mgc` VALUES (18, '电话', 0);
INSERT INTO `gp_mgc` VALUES (19, '分析', 0);
INSERT INTO `gp_mgc` VALUES (20, '的', 0);
INSERT INTO `gp_mgc` VALUES (21, '52', 0);
INSERT INTO `gp_mgc` VALUES (22, '53', 0);
INSERT INTO `gp_mgc` VALUES (23, '54', 0);
INSERT INTO `gp_mgc` VALUES (24, '本', 0);
INSERT INTO `gp_mgc` VALUES (25, '政治', 0);
INSERT INTO `gp_mgc` VALUES (26, '装修', 0);
INSERT INTO `gp_mgc` VALUES (27, '教育部', 0);
INSERT INTO `gp_mgc` VALUES (28, '1', 0);
INSERT INTO `gp_mgc` VALUES (29, '2', 0);
INSERT INTO `gp_mgc` VALUES (30, '3', 0);
INSERT INTO `gp_mgc` VALUES (31, '公告', 0);
INSERT INTO `gp_mgc` VALUES (32, '审查', 0);
INSERT INTO `gp_mgc` VALUES (33, '招聘', 0);
INSERT INTO `gp_mgc` VALUES (34, '转化', 0);
INSERT INTO `gp_mgc` VALUES (35, '443', 0);
INSERT INTO `gp_mgc` VALUES (36, '违纪', 0);
INSERT INTO `gp_mgc` VALUES (37, '中华人民共和国', 0);
INSERT INTO `gp_mgc` VALUES (38, '监督', 0);
INSERT INTO `gp_mgc` VALUES (39, '中华', 0);
INSERT INTO `gp_mgc` VALUES (40, '工作人员', 0);
INSERT INTO `gp_mgc` VALUES (41, '通知', 0);
INSERT INTO `gp_mgc` VALUES (42, '领导', 0);
INSERT INTO `gp_mgc` VALUES (43, '其他', 0);
INSERT INTO `gp_mgc` VALUES (44, '咨询', 0);
INSERT INTO `gp_mgc` VALUES (45, '信息', 0);
INSERT INTO `gp_mgc` VALUES (46, '电话', 0);
INSERT INTO `gp_mgc` VALUES (47, '公务员', 0);
INSERT INTO `gp_mgc` VALUES (48, '30', 0);
INSERT INTO `gp_mgc` VALUES (49, '中国', 0);
INSERT INTO `gp_mgc` VALUES (50, '40', 0);
INSERT INTO `gp_mgc` VALUES (51, '45', 0);
INSERT INTO `gp_mgc` VALUES (52, '的', 0);
INSERT INTO `gp_mgc` VALUES (53, '52', 0);
INSERT INTO `gp_mgc` VALUES (54, '53', 0);
INSERT INTO `gp_mgc` VALUES (55, '54', 0);
INSERT INTO `gp_mgc` VALUES (56, '60', 0);
INSERT INTO `gp_mgc` VALUES (57, '本', 0);
INSERT INTO `gp_mgc` VALUES (58, '测试', 0);
INSERT INTO `gp_mgc` VALUES (59, '领导', 0);
INSERT INTO `gp_mgc` VALUES (60, '1', 0);
INSERT INTO `gp_mgc` VALUES (61, '5', 0);
INSERT INTO `gp_mgc` VALUES (62, '28', 0);
INSERT INTO `gp_mgc` VALUES (63, '公告', 0);
INSERT INTO `gp_mgc` VALUES (64, '的', 0);
INSERT INTO `gp_mgc` VALUES (65, '52', 0);
INSERT INTO `gp_mgc` VALUES (66, '53', 0);
INSERT INTO `gp_mgc` VALUES (67, '54', 0);
INSERT INTO `gp_mgc` VALUES (68, '信息', 0);
INSERT INTO `gp_mgc` VALUES (69, '招聘', 0);
INSERT INTO `gp_mgc` VALUES (70, '中共', 0);
INSERT INTO `gp_mgc` VALUES (71, '通知', 0);
INSERT INTO `gp_mgc` VALUES (72, '电话', 0);
INSERT INTO `gp_mgc` VALUES (73, '名师', 0);

SET FOREIGN_KEY_CHECKS = 1;
