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

 Date: 09/11/2021 12:33:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_power
-- ----------------------------
DROP TABLE IF EXISTS `sys_power`;
CREATE TABLE `sys_power`  (
  `power_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限编号',
  `power_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `power_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限类型',
  `power_code` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `power_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限路径',
  `open_type` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '打开方式',
  `parent_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父类编号',
  `icon` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `sort` int NULL DEFAULT NULL COMMENT '排序',
  `create_by` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `enable` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否开启',
  PRIMARY KEY (`power_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_power
-- ----------------------------
INSERT INTO `sys_power` VALUES ('1', '系统管理', '0', '', '', NULL, '0', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1284020948269268992', '用户列表', '2', 'sys:user:data', '', '', '2', 'layui-icon-username', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1284022967767924736', '用户保存', '2', 'sys:user:add', '', '', '2', 'layui-icon-username', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1302180351979814912', '布局构建', '1', 'generator:from:main', 'component/code/index.html', '_iframe', '442417411065516032', 'layui-icon-senior', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310206853057085440', '用户修改', '2', 'sys:user:edit', '', '', '2', 'layui-icon-vercode', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310208636370288640', '用户删除', '2', 'sys:user:remove', '', '', '2', 'layui-icon-vercode', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310209696916832256', '角色新增', '2', 'sys:role:add', '', '', '3', 'layui-icon-vercode', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310209900478988288', '角色删除', '2', 'sys:role:remove', '', '', '3', 'layui-icon-vercode', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310210054728712192', '角色修改', '2', 'sys:role:edit', '', '', '3', 'layui-icon-vercode', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310211965188046848', '角色授权', '2', 'sys:role:power', '', '', '3', 'layui-icon-vercode', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310226416867999744', '权限列表', '2', 'sys:power:data', '', '', '4', 'layui-icon-vercode', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310226976593674240', '权限新增', '2', 'sys:power:add', '', '', '4', 'layui-icon-vercode', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310227130998587392', '权限修改', '2', 'sys:power:edit', '', '', '4', 'layui-icon-vercode', 2, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310227300935008256', '权限删除', '2', 'sys:power:remove', '', '', '4', 'layui-icon-vercode', 3, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310232350285627392', '操作日志', '2', 'sys:log:operateLog', '', '', '450300705362808832', 'layui-icon layui-icon-vercode', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310232462562951168', '登录日志', '2', 'sys:log:loginLog', '', '', '450300705362808832', 'layui-icon layui-icon-vercode', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310238229588344832', '配置列表', '2', 'sys:config:data', '', '', '1307299332784914432', 'layui-icon-vercode', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310238417082122240', '配置新增', '2', 'sys:config:add', '', '', '1307299332784914432', 'layui-icon-vercode', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310238574355939328', '配置修改', '2', 'sys:config:edit', '', '', '1307299332784914432', 'layui-icon-vercode', 2, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310238700705153024', '配置删除', '2', 'sys:config:remove', '', '', '1307299332784914432', 'layui-icon-vercode', 3, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310243862937075712', '文件列表', '2', 'sys:file:data', '', '', '1304793451996381184', 'layui-icon-vercode', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310244103824343040', '文件新增', '2', 'sys:file:add', '', '', '1304793451996381184', 'layui-icon-vercode', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310244248884346880', '文件删除', '2', 'sys:file:remove', '', '', '1304793451996381184', 'layui-icon-vercode', 3, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310395250908332032', '日志列表', '2', 'sch:log:data', '', '', '442651158935375872', 'layui-icon-vercode', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1310397832091402240', '任务恢复', '2', 'sch:job:resume', '', '', '442650770626711552', 'layui-icon-vercode', NULL, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1313142510486290432', '公告列表', '1', 'sys:notice:data', '/system/notice/data', '0', '1313142171393589248', 'layui-icon-notice', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1313482983558086656', '公告新增', '2', 'sys:notice:add', '', '', '1313142171393589248', 'layui-icon-vercode', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1313483090852577280', '公告修改', '2', 'sys:notice:edit', '', '', '1313142171393589248', 'layui-icon-vercode', 2, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1313483189850734592', '公告删除', '2', 'sys:notice:remove', '', '', '1313142171393589248', 'layui-icon-vercode', 3, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1320969572051845120', '111111', '2', '', '', '', '1284020948269268992', 'layui-icon-login-qq', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_power` VALUES ('1322085079861690368', '用户管理', '1', 'sys:user:main', '/system/user/main', '_iframe', '1', 'layui-icon layui-icon layui-icon layui-icon layui-icon-rate', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1322085270392143872', '用户列表', '2', 'sys:user:data', '', '', '1322085079861690368', 'layui-icon layui-icon layui-icon layui-icon-vercode', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1322085393021009920', '用户新增', '2', 'sys:user:add', '', '', '1322085079861690368', 'layui-icon layui-icon-vercode', NULL, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1322085497798918144', '用户修改', '2', 'sys:user:edit', '', '', '1322085079861690368', 'layui-icon layui-icon layui-icon-vercode', 2, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1322085659766161408', '用户删除', '2', 'sys:user:remove', '', '', '1322085079861690368', 'layui-icon layui-icon-rate', 3, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1329349076189184000', '', '1', '', '', '', '451002662209589248', 'layui-icon', NULL, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1330865171429588992', '在线用户', '1', 'sys:online:main', '/system/online/main', '_iframe', '694203021537574912', 'layui-icon layui-icon layui-icon-username', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1348562759603716096', '在线列表', '1', 'sys:online:data', '/system/online/data', '_iframe', '1330865171429588992', 'layui-icon layui-icon-username', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1349016358033031168', '环境监控', '1', 'sys:monitor:main', '/system/monitor/main', '_iframe', '694203021537574912', 'layui-icon layui-icon-vercode', 9, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1370412169610395648', '公告管理', '1', 'system:notice:main', '/system/notice/main', '_iframe', '1453546386023776256', 'layui-icon layui-icon layui-icon layui-icon layui-icon-set-fill', 8, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1370412169610395649', '消息列表', '2', 'system:notice:data', '', NULL, '1370412169610395648', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1370412169610395650', '消息新增', '2', 'system:notice:add', '', NULL, '1370412169610395648', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1370412169610395651', '消息修改', '2', 'system:notice:edit', '', NULL, '1370412169610395648', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1370412169610395652', '消息删除', '2', 'system:notice:remove', '', NULL, '1370412169610395648', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1370974716822552576', '修改设置', '2', 'sys:setup:add', '', '', '1355962888132493312', 'layui-icon layui-icon-vercode', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1453542364613181440', '获取文章菜单', '1', 'system:newe:main', '/system/newe/main', '_iframe', '${parentMenuId}', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1453542364613181441', '获取文章列表', '2', 'system:newe:data', '', NULL, '1453542364613181440', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1453542364613181442', '获取文章新增', '2', 'system:newe:add', '', NULL, '1453542364613181440', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1453542364613181443', '获取文章修改', '2', 'system:newe:edit', '', NULL, '1453542364613181440', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1453542364613181444', '获取文章删除', '2', 'system:newe:remove', '', NULL, '1453542364613181440', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1453546386023776256', '数据管理', '0', '', '', '', '0', 'layui-icon layui-icon-tabs', 2, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1453547112779218944', '文章分析', '1', 'system:newe:main', '/system/newe/main', '_iframe', '1453546386023776256', 'layui-icon layui-icon-template', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1453964130410037248', '爬取文章', '2', 'system:newe:getNew', '', '', '1453547112779218944', 'layui-icon layui-icon-download-circle', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1455500800569638912', '敏感词表菜单', '1', 'system:newbadword:main', '/system/newbadword/main', '_iframe', '${parentMenuId}', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1455500800569638913', '敏感词表列表', '2', 'system:newbadword:data', '', NULL, '1455500800569638912', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1455500800569638914', '敏感词表新增', '2', 'system:newbadword:add', '', NULL, '1455500800569638912', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1455500800569638915', '敏感词表修改', '2', 'system:newbadword:edit', '', NULL, '1455500800569638912', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1455500800569638916', '敏感词表删除', '2', 'system:newbadword:remove', '', NULL, '1455500800569638912', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1455505479110230016', '敏感词管理', '1', 'system:newbadword:main', '/system/newbadword/main', '_iframe', '1453546386023776256', 'layui-icon layui-icon-vercode', 2, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1455506779394801664', '新增', '2', 'system:newbadword:add', '', '', '1455505479110230016', 'layui-icon ', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1456063754574757888', '高频敏感词菜单', '1', 'system:mgc:main', '/system/mgc/main', '_iframe', '${parentMenuId}', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1456063754574757889', '高频敏感词列表', '2', 'system:mgc:data', '', NULL, '1456063754574757888', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1456063754574757890', '高频敏感词新增', '2', 'system:mgc:add', '', NULL, '1456063754574757888', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1456063754574757891', '高频敏感词修改', '2', 'system:mgc:edit', '', NULL, '1456063754574757888', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1456063754574757892', '高频敏感词删除', '2', 'system:mgc:remove', '', NULL, '1456063754574757888', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1456070060694044672', '高频敏感词菜单', '1', 'system:mgc:main', '/system/mgc/main', '_iframe', '${parentMenuId}', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1456070060694044673', '高频敏感词列表', '2', 'system:mgc:data', '', NULL, '1456070060694044672', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1456070060694044674', '高频敏感词新增', '2', 'system:mgc:add', '', NULL, '1456070060694044672', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1456070060694044675', '高频敏感词修改', '2', 'system:mgc:edit', '', NULL, '1456070060694044672', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1456070060694044676', '高频敏感词删除', '2', 'system:mgc:remove', '', NULL, '1456070060694044672', 'layui-icon layui-icon-set-fill', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('1456210130260459520', '词云分析', '1', 'system:mgc:main', '/system/mgc/main', '_iframe', '1453546386023776256', 'layui-icon ', 3, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('2', '用户管理', '2', '', '', '_iframe', '1320969572051845120', 'layui-icon layui-icon layui-icon-username', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('3', '角色管理', '1', 'sys:role:main', '/system/role/main', '_iframe', '1', 'layui-icon layui-icon-user', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('4', '权限管理', '1', 'sys:power:main', '/system/power/main', '_iframe', '1', 'layui-icon layui-icon-vercode', 2, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('442359447487123456', '角色列表', '2', 'sys:role:data', '', '', '3', 'layui-icon layui-icon-rate', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('442417411065516032', '开发工具', '0', '', '', '', '0', 'layui-icon layui-icon layui-icon-senior', 4, NULL, NULL, NULL, NULL, NULL, '0');
INSERT INTO `sys_power` VALUES ('442418188639145984', '代码生成', '1', 'exp:template:main', '/generate/main', '_iframe', '442417411065516032', 'layui-icon layui-icon layui-icon layui-icon layui-icon layui-icon-template-1', 1, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('450300705362808832', '行为日志', '1', 'sys:log:main', '/system/log/main', '_iframe', '694203021537574912', 'layui-icon layui-icon layui-icon layui-icon  layui-icon-chart', 7, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('451002662209589248', '工作空间', '1', '', '', '', '451002662209589248', 'layui-icon layui-icon layui-icon-home', 0, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('694203021537574912', '系统监控', '0', '', '', '', '0', 'layui-icon  layui-icon-console', 3, NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_power` VALUES ('694203311615639552', '接口文档', '1', 'sys:doc:main', '/system/doc/main', '_iframe', '442417411065516032', 'layui-icon layui-icon layui-icon layui-icon  layui-icon-chart', 9, NULL, NULL, NULL, NULL, NULL, '1');

SET FOREIGN_KEY_CHECKS = 1;
