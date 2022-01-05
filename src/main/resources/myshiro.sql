/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100121
 Source Host           : localhost:3306
 Source Schema         : myshiro

 Target Server Type    : MySQL
 Target Server Version : 100121
 File Encoding         : 65001

 Date: 05/01/2022 16:06:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1);
INSERT INTO `role_permission` VALUES (1, 2);
INSERT INTO `role_permission` VALUES (1, 3);
INSERT INTO `role_permission` VALUES (2, 2);
INSERT INTO `role_permission` VALUES (2, 4);
INSERT INTO `role_permission` VALUES (1, 4);

-- ----------------------------
-- Table structure for system_shiro_permission
-- ----------------------------
DROP TABLE IF EXISTS `system_shiro_permission`;
CREATE TABLE `system_shiro_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of system_shiro_permission
-- ----------------------------
INSERT INTO `system_shiro_permission` VALUES (1, 'user:add', 'add', '/add');
INSERT INTO `system_shiro_permission` VALUES (2, 'user:update', 'update', '/update');
INSERT INTO `system_shiro_permission` VALUES (3, 'user:delete', 'delete', '/delete');
INSERT INTO `system_shiro_permission` VALUES (4, 'user:query', 'query', '/query');

-- ----------------------------
-- Table structure for system_shiro_role
-- ----------------------------
DROP TABLE IF EXISTS `system_shiro_role`;
CREATE TABLE `system_shiro_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of system_shiro_role
-- ----------------------------
INSERT INTO `system_shiro_role` VALUES (1, 'usermanager', 'manager');
INSERT INTO `system_shiro_role` VALUES (2, 'usereditor', 'editor');

-- ----------------------------
-- Table structure for system_shiro_user
-- ----------------------------
DROP TABLE IF EXISTS `system_shiro_user`;
CREATE TABLE `system_shiro_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of system_shiro_user
-- ----------------------------
INSERT INTO `system_shiro_user` VALUES (1, 'admin', '123456');
INSERT INTO `system_shiro_user` VALUES (2, 'editor', '123456');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
