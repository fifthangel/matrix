/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.15 : Database - managercenter
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `mc_role` */

CREATE TABLE `mc_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(200) DEFAULT NULL COMMENT '角色描述',
  `flag` int(6) DEFAULT '1' COMMENT '是否删除 1否 2是',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_user_id` int(11) DEFAULT NULL COMMENT '创建人',
  `update_user_id` int(11) DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

/*Data for the table `mc_role` */

insert  into `mc_role`(`id`,`role_name`,`role_desc`,`flag`,`create_time`,`update_time`,`create_user_id`,`update_user_id`,`remark`) values (30,'系统管理员','后台系统管理员拥有所有功能',1,'2017-05-02 10:51:58','2017-06-21 10:49:43',1,1,''),(31,'开发示例角色','给开发者使用的角色，快速复制现有代码完成开发任务',1,'2017-05-02 10:52:12','2017-06-14 17:34:54',1,1,''),(32,'系统权限角色','该角色拥有配置后台页面权限的能力，通常是开发者或高级管理员',1,'2017-05-02 10:52:23','2017-05-24 18:19:14',1,1,''),(33,'导航栏C','导航栏C全部功能',1,'2017-05-02 10:52:39','2017-05-24 18:19:31',1,1,''),(34,'898','898898898898',1,'2017-05-19 17:47:32','2017-05-22 18:31:18',1,1,''),(35,'开发者','平台开发者',1,'2017-05-19 21:29:52','2017-05-19 21:29:52',1,1,''),(38,'asdf','asdfasdf',1,'2017-05-22 18:49:25','2017-05-22 18:49:34',1,1,''),(39,'短发大师傅','阿斯达2',1,'2017-05-25 18:20:30','2017-05-25 21:44:58',1,1,'');

/*Table structure for table `mc_role_function` */

CREATE TABLE `mc_role_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'zid',
  `mc_role_id` int(11) DEFAULT NULL COMMENT 'mc_role表主键',
  `mc_sys_function_id` int(11) DEFAULT NULL COMMENT 'mc_sys_function表主键',
  `flag` int(6) DEFAULT NULL COMMENT '是否删除 1否 2是',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1501 DEFAULT CHARSET=utf8;

/*Data for the table `mc_role_function` */

insert  into `mc_role_function`(`id`,`mc_role_id`,`mc_sys_function_id`,`flag`,`create_time`,`update_time`,`create_user_id`,`update_user_id`,`remark`) values (961,34,75,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(962,34,77,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(963,34,79,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(964,34,83,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(965,34,168,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(966,34,167,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(967,34,170,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(968,34,169,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(969,34,126,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(970,34,171,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(971,34,192,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(972,34,187,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(973,34,208,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(974,34,127,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(975,34,172,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(976,34,193,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(977,34,188,1,'2017-05-22 18:31:18','2017-05-22 18:31:18',1,1,''),(994,38,75,1,'2017-05-22 18:49:34','2017-05-22 18:49:34',1,1,''),(995,38,77,1,'2017-05-22 18:49:34','2017-05-22 18:49:34',1,1,''),(996,38,79,1,'2017-05-22 18:49:34','2017-05-22 18:49:34',1,1,''),(997,38,83,1,'2017-05-22 18:49:34','2017-05-22 18:49:34',1,1,''),(998,38,168,1,'2017-05-22 18:49:34','2017-05-22 18:49:34',1,1,''),(999,38,167,1,'2017-05-22 18:49:34','2017-05-22 18:49:34',1,1,''),(1000,38,170,1,'2017-05-22 18:49:34','2017-05-22 18:49:34',1,1,''),(1001,38,169,1,'2017-05-22 18:49:34','2017-05-22 18:49:34',1,1,''),(1133,32,75,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1134,32,78,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1135,32,81,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1136,32,117,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1137,32,176,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1138,32,197,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1139,32,118,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1140,32,177,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1141,32,198,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1142,32,119,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1143,32,178,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1144,32,199,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1145,32,82,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1146,32,130,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1147,32,179,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1148,32,200,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1149,32,131,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1150,32,180,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1151,32,201,1,'2017-05-24 18:19:14','2017-05-24 18:19:14',1,1,''),(1152,33,75,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1153,33,109,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1154,33,110,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1155,33,120,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1156,33,181,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1157,33,202,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1158,33,121,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1159,33,182,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1160,33,203,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1161,33,122,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1162,33,183,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1163,33,204,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1164,33,111,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1165,33,123,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1166,33,184,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1167,33,205,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1168,33,124,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1169,33,185,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1170,33,206,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1171,33,125,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1172,33,186,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1173,33,207,1,'2017-05-24 18:19:31','2017-05-24 18:19:31',1,1,''),(1182,39,75,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1183,39,77,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1184,39,79,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1185,39,83,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1186,39,168,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1187,39,167,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1188,39,170,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1189,39,169,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1190,39,126,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1191,39,171,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1192,39,192,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1193,39,187,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1194,39,208,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1195,39,127,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1196,39,172,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1197,39,193,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1198,39,188,1,'2017-05-25 21:44:58','2017-05-25 21:44:58',1,1,''),(1290,31,75,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1291,31,77,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1292,31,79,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1293,31,83,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1294,31,167,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1295,31,168,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1296,31,170,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1297,31,169,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1298,31,126,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1299,31,171,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1300,31,192,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1301,31,187,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1302,31,208,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1303,31,127,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1304,31,172,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1305,31,193,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1306,31,188,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1307,31,209,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1308,31,210,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1309,31,211,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1310,31,212,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1311,31,213,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1312,31,214,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1313,31,215,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1314,31,80,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1315,31,84,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1316,31,173,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1317,31,189,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1318,31,194,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1319,31,128,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1320,31,174,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1321,31,190,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1322,31,195,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1323,31,220,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1324,31,227,1,'2017-06-14 17:34:54','2017-06-14 17:34:54',1,1,''),(1441,30,75,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1442,30,109,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1443,30,110,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1444,30,120,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1445,30,181,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1446,30,202,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1447,30,228,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1448,30,232,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1449,30,229,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1450,30,233,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1451,30,230,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1452,30,234,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1453,30,111,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1454,30,123,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1455,30,184,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1456,30,77,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1457,30,79,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1458,30,83,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1459,30,167,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1460,30,168,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1461,30,170,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1462,30,169,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1463,30,126,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1464,30,171,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1465,30,192,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1466,30,187,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1467,30,208,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1468,30,127,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1469,30,172,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1470,30,193,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1471,30,188,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1472,30,209,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1473,30,210,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1474,30,211,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1475,30,212,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1476,30,213,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1477,30,214,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1478,30,215,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1479,30,80,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1480,30,84,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1481,30,173,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1482,30,189,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1483,30,194,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1484,30,128,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1485,30,174,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1486,30,190,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1487,30,195,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1488,30,220,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1489,30,227,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1490,30,78,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1491,30,81,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1492,30,117,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1493,30,176,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1494,30,197,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1495,30,118,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1496,30,177,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1497,30,198,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1498,30,119,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1499,30,178,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,''),(1500,30,199,1,'2017-06-21 10:49:43','2017-06-21 10:49:43',1,1,'');

/*Table structure for table `mc_seller_company` */

CREATE TABLE `mc_seller_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'zid',
  `mc_company_name` varchar(50) DEFAULT NULL COMMENT '商户名称',
  `flag` int(6) DEFAULT NULL COMMENT '是否删除 1否 2是',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `symbiosis` int(2) DEFAULT NULL COMMENT '合作关系',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125017 DEFAULT CHARSET=utf8;

/*Data for the table `mc_seller_company` */

insert  into `mc_seller_company`(`id`,`mc_company_name`,`flag`,`create_time`,`update_time`,`create_user_id`,`update_user_id`,`remark`,`symbiosis`) values (125014,'惠家有',1,'2016-09-27 21:28:57','2016-09-27 21:28:57',1,1,'asdfasd',NULL),(125015,'Nick中国',1,'2016-09-27 21:29:39','2016-09-27 21:29:39',1,1,'c',NULL),(125016,'苹果中国',1,'2016-09-27 21:31:45','2016-09-27 21:31:45',1,1,'o',NULL);

/*Table structure for table `mc_sys_function` */

CREATE TABLE `mc_sys_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'zid',
  `mc_seller_company_id` int(11) NOT NULL DEFAULT '1' COMMENT '1为平台本身|还有其他商户|mc_seller_company表主键|据此过滤权限树',
  `name` varchar(40) NOT NULL COMMENT '功能名称 导航栏与菜单栏所显示的名称',
  `parent_id` varchar(12) NOT NULL COMMENT '父节点。root为0 其下为:商户->导航栏->一级菜单栏->二级菜单栏->页面按钮',
  `seqnum` int(6) NOT NULL COMMENT '顺序码 同一层次显示顺序：导航栏 一级菜单栏 二级菜单栏 对应的显示顺序',
  `nav_type` int(6) NOT NULL COMMENT '-1 根节点 0 商户名称 1 横向导航栏|2 为1级菜单栏|3 2级菜单栏 |4 页面按钮|5 内部跳转页面',
  `style_class` varchar(20) DEFAULT '' COMMENT '此项针对一级菜单栏 如：inbox   <a href="#example" class="inbox">开发者快速入门</a>',
  `style_key` varchar(50) DEFAULT '' COMMENT '此项针对一级菜单栏 如：example  <ul id="example">',
  `func_url` varchar(255) DEFAULT '' COMMENT '此项针对二级菜单栏 如：example/pageFormExample.do',
  `flag` int(6) DEFAULT '1' COMMENT '是否删除 1否 2是 3新加(数据库不会有此状态，只在页面新增节点时做判断用)',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `btn_area` varchar(20) DEFAULT '' COMMENT '按钮节点所在页面的位置。10001：功能区域；10002：查询区域；10003：数据区域',
  `ele_value` varchar(50) DEFAULT '' COMMENT '元素ID标识 配合btn_area使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=249 DEFAULT CHARSET=utf8;

/*Data for the table `mc_sys_function` */

insert  into `mc_sys_function`(`id`,`mc_seller_company_id`,`name`,`parent_id`,`seqnum`,`nav_type`,`style_class`,`style_key`,`func_url`,`flag`,`create_time`,`update_time`,`create_user_id`,`update_user_id`,`remark`,`btn_area`,`ele_value`) values (1,1,'root：系统功能树','-1',1,-1,'root','root','rool',1,'2016-06-05 14:19:24','2016-06-05 14:19:26',1,1,'系统根节点','',NULL),(75,1,'惠家有促销系统','1',1,0,'','','',1,'2017-04-05 17:14:11','2017-04-23 15:47:55',1,2,'惠家有促销系统2','',''),(77,1,'开发示例','75',2,1,'','','',1,'2017-04-05 17:15:33','2017-06-15 15:27:01',1,1,'为系统开发这提供的示例','',''),(78,1,'系统权限配置','75',3,1,'','','',1,'2017-04-05 17:16:31','2017-06-15 15:27:02',1,1,'系统权限与用户创建','',''),(79,1,'开发者快速入门','77',1,2,'editor','37c694131c304c2588c4b906567631b1','',1,'2017-04-05 17:16:48','2017-05-25 18:15:56',1,1,'开发者快速入门','',''),(80,1,'实例样本','77',2,2,'editor','0cf9aa57b07149d586cc8998af6cfe7d','',1,'2017-04-05 17:17:05','2017-05-15 22:51:07',1,1,'实例样本','',''),(81,1,'系统用户相关','78',1,2,'editor','b06962367f8640fcbf11d4bca147101b','',1,'2017-04-05 17:17:29','2017-05-18 11:05:45',1,1,'系统用户相关','',''),(83,1,'添加信息示例','79',1,3,'','','example/page_example_add_info.do',1,'2017-04-05 17:18:00','2017-05-25 18:15:45',1,1,'添加信息示例','',''),(84,1,'实际样本-A','80',1,3,'','','example/page_example_a.do',1,'2017-04-05 17:20:02','2017-05-15 22:51:46',1,1,'实际样本-A','',''),(109,1,'媒体站','75',1,1,'','','',1,'2017-04-11 14:49:05','2017-06-15 15:27:01',1,1,'媒体站相关信息','',''),(110,1,'素材管理','109',1,2,'editor','8d48144e422445a0b34a988748a29bc9','',1,'2017-04-19 16:41:36','2017-06-15 10:36:53',1,1,'素材管理','',''),(111,1,'分类管理','109',2,2,'editor','2790e43d9b1049d2adef830653927dd0','',1,'2017-04-19 16:41:58','2017-06-15 14:37:12',1,1,'分类管理','',''),(117,1,'系统用户列表','81',1,3,'','','manager/page_manager_user_list.do',1,'2017-04-20 21:55:45','2017-05-18 11:08:13',1,1,'系统用户列表','',''),(118,1,'系统角色列表','81',2,3,'','','sysrole/page_sysrole_mc_role_list.do',1,'2017-04-20 21:55:58','2017-05-19 14:00:37',1,1,'系统角色列表','',''),(119,1,'系统功能列表','81',3,3,'','','sysrole/page_sysrole_function.do',1,'2017-04-20 21:56:11','2017-05-23 14:23:44',1,1,'系统功能列表','',''),(120,1,'已发布文章列表','110',2,3,'','','media/page_media_released_list.do',1,'2017-04-20 21:57:22','2017-06-21 11:23:04',1,1,'已发布文章，所有人都可以见','',''),(123,1,'文章分类管理','111',1,3,'','','media/page_media_article_assort_manage.do',1,'2017-04-20 21:58:56','2017-06-15 14:56:07',1,1,'文章分类管理：海外购、生活电器、厨房用品等等。','',''),(126,1,'Ajax 分页示例','79',2,3,'','','example/page_example_ajax_form.do',1,'2017-04-20 21:59:43','2017-05-15 22:46:28',1,1,'Ajax 分页示例','',''),(127,1,'Ajax 分页+弹出窗体分页 示例','79',3,3,'','','example/page_example_ajax_form_dialog.do',1,'2017-04-20 21:59:54','2017-05-15 22:47:25',1,1,'Ajax 分页+弹出窗体分页 示例','',''),(128,1,'实际样本-B','80',2,3,'','','example/page_example_b.do',1,'2017-04-20 22:00:09','2017-05-15 22:52:17',1,1,'实际样本-B','',''),(167,1,'添加','83',1,4,'','','',1,'2017-04-30 21:23:59','2017-06-14 11:23:32',1,1,'123123','10001','btn-9bb559430eeb4b9290e0999776ace4b1'),(168,1,'修改','83',2,5,'','','exa/sdeia.do',1,'2017-04-30 22:34:31','2017-06-14 11:23:33',1,1,'修改','10003','btn-fbfc0859ab7b456699c8c2554d953f96'),(169,1,'查看','83',4,4,'','','',1,'2017-04-30 22:35:10','2017-06-14 11:23:36',1,1,'查看-按钮-查询区域-10002','10002','btn-d1842f1fa5004afe977237f5e9ff7478'),(170,1,'查询','83',3,4,'','','',1,'2017-04-30 22:36:40','2017-06-14 11:23:34',1,1,'查询','10002','btn-e138c2e419b642dba0587a237ce0e539'),(171,1,'查询','126',1,4,'','','',1,'2017-05-02 10:43:56','2017-05-15 23:07:26',1,1,'查询','10002','btn-0f380a0fef2544d19c7c62e1c273937d'),(172,1,'添加','127',1,4,'','','',1,'2017-05-02 10:44:28','2017-05-19 17:59:23',1,1,'添加','10001','btn-46867f49acea4feab584e75291f90b78'),(173,1,'添加','84',1,4,'','','',1,'2017-05-02 10:44:35','2017-05-02 10:44:35',1,1,'添加','10001','btn-c9e3aa249b084858b8cbd83bb8902eff'),(174,1,'添加','128',1,4,'','','',1,'2017-05-02 10:44:41','2017-05-02 10:44:41',1,1,'添加','10001','btn-0a00a3c05c134d1c8d86452096403683'),(176,1,'添加','117',1,4,'','','',1,'2017-05-02 10:45:09','2017-05-02 10:45:09',1,1,'添加','10001','btn-c570876129aa49068d8366130c7bd9ca'),(177,1,'添加','118',1,4,'','','',1,'2017-05-02 10:45:14','2017-05-02 10:45:14',1,1,'添加','10001','btn-e78f4fb8a8794b40b4aaccf7715f9904'),(178,1,'添加','119',1,4,'','','',1,'2017-05-02 10:45:22','2017-05-02 10:45:22',1,1,'添加','10001','btn-d671400a9d4b44a6bfaf52d697b3a413'),(181,1,'添加','120',1,4,'','','',1,'2017-05-02 10:45:45','2017-05-02 10:45:45',1,1,'添加','10001','btn-ff6c3c7ac34e47579a2e1861e74b1be6'),(184,1,'添加','123',1,4,'','','',1,'2017-05-02 10:46:07','2017-05-23 15:12:06',1,1,'添加','10002','btn-e80660c2b7d44736a806a53cfe32f163'),(187,1,'删除','126',3,4,'','','',1,'2017-05-02 10:46:47','2017-05-15 23:08:42',1,1,'删除','10003','btn-44d72c6a34f947c89ab0f7c8d94d7766'),(188,1,'修改','127',3,5,'','','asdfasdf',1,'2017-05-02 10:47:02','2017-05-19 17:59:23',1,1,'修改','10003','btn-fc096d69a8434ec6ada2d3a33dd5fd0a'),(189,1,'修改','84',2,5,'','','asdfasdf',1,'2017-05-02 10:47:13','2017-05-02 10:47:21',1,1,'修改','10003','btn-27159f8438de4f2582c8bf7058a9e814'),(190,1,'修改','128',2,5,'','','asdfasdf',1,'2017-05-02 10:47:34','2017-05-02 10:47:34',1,1,'asdfadf修改','10003','btn-8a5f1f9458874bd09ebfe555f1704e82'),(192,1,'重置','126',2,4,'','','',1,'2017-05-02 10:48:43','2017-05-15 23:07:57',1,1,'重置','10002','btn-a8e2930b381b45509f96fc2965b04386'),(193,1,'查看','127',2,4,'','','',1,'2017-05-02 10:48:50','2017-05-19 17:59:23',1,1,'查看','10001','btn-d0c8534ac13b47f7b2d0cb1fb9fd6774'),(194,1,'查看','84',3,4,'','','',1,'2017-05-02 10:48:55','2017-05-02 10:48:55',1,1,'查看','10001','btn-e0a8a4f349c44d1bb22d0715e4792d8a'),(195,1,'查看','128',3,4,'','','',1,'2017-05-02 10:49:01','2017-05-02 10:49:01',1,1,'查看','10001','btn-61e606c250eb494b9d768710cb7eaf69'),(197,1,'查询','117',2,4,'','','',1,'2017-05-02 10:49:33','2017-05-02 10:49:33',1,1,'查询','10001','btn-5e420538c3954b109a5afdc3fa4ed80c'),(198,1,'查询','118',2,4,'','','',1,'2017-05-02 10:49:47','2017-05-02 10:49:47',1,1,'查询','10001','btn-d9dc670ae66445dbbd0750c8b80d5d73'),(199,1,'查询','119',2,4,'','','',1,'2017-05-02 10:49:55','2017-05-02 10:49:55',1,1,'查询','10001','btn-bc18f0a001774234a82a7d113dad44fb'),(202,1,'查询','120',2,4,'','','',1,'2017-05-02 10:50:46','2017-05-02 10:50:46',1,1,'查询','10001','btn-eec2da8bfc3640059cfc01375f5a50ed'),(208,1,'修改','126',4,4,'','','',1,'2017-05-15 23:09:45','2017-05-15 23:09:45',1,1,'修改','10003','btn-8af25e9d48b54978893354701e73fc12'),(209,1,'自定义 alert confirm note 示例','79',4,3,'','','example/page_example_alert.do',1,'2017-05-18 09:58:27','2017-05-18 09:58:27',1,1,'自定义 alert confirm note 示例','',''),(210,1,'基本 Alert','209',1,4,'','','',1,'2017-05-18 09:59:35','2017-05-18 09:59:35',1,1,'基本 Alert','10001','btn-2c4941853b1849969c336522909ad99b'),(211,1,'确认对话框 confirm','209',2,4,'','','',1,'2017-05-18 09:59:48','2017-05-18 09:59:48',1,1,'确认对话框 confirm','10001','btn-5b4d350a836a4bcba7a1716bd3643bab'),(212,1,'输入对话框 prompt','209',3,4,'','','',1,'2017-05-18 09:59:58','2017-05-18 09:59:58',1,1,'输入对话框 prompt','10001','btn-8067f6befea34eebbb9ea8c8d8ca7f58'),(213,1,'alert 支持html标签','209',4,4,'','','',1,'2017-05-18 10:00:08','2017-05-18 10:00:08',1,1,'alert 支持html标签','10001','btn-b1044c816ea14c6e9b8ddd3b1087b530'),(214,1,'弹出层示例','79',5,3,'','','example/page_example_block_ui.do',1,'2017-05-18 23:44:06','2017-05-18 23:51:28',1,1,'介绍系统常见的弹出层','',''),(215,1,'添加','214',1,4,'','','',1,'2017-05-18 23:44:35','2017-05-18 23:44:35',1,1,'开头语','10001','btn-1a06b8d89eef48f6a2587fc0b4b47cfe'),(220,1,'缓存查看','80',3,3,'','','cache/page_cache_get_value.do',1,'2017-05-24 17:41:23','2017-05-24 17:41:23',1,1,'查看系统中的缓存信息','',''),(227,1,'ueditor编辑器示例','80',4,3,'','','example/page_example_ueditor.do',1,'2017-06-08 11:14:00','2017-06-08 11:14:00',1,1,'ueditor编辑器示例','',''),(228,1,'待发布文章列表','110',1,3,'','','media/page_media_unreleased_list.do',1,'2017-06-15 14:25:36','2017-06-28 11:16:13',1,1,'未发布文章列表，保存的是编辑从草稿箱中提交的文章。只有主管可见，内容发布行为则由主管负责','',''),(229,1,'草稿箱列表','110',3,3,'','','media/page_media_drafts_list.do',1,'2017-06-15 14:28:08','2017-06-21 11:23:04',1,1,'保存了编辑尚未提交到未发布状态的文章，只有编辑人员可见，编辑人员可以看到自己的草稿，不能看到别人的草稿','',''),(230,1,'回收站列表','110',4,3,'','','media/page_media_recycle_bin_list.do',1,'2017-06-15 14:33:24','2017-06-21 11:23:04',1,1,'回收站里是编辑人员从草稿箱中删除的文章，如果在回收站中删除了一片文章，则再也无法找回。','',''),(232,1,'查询','228',1,4,'','','',1,'2017-06-15 14:35:27','2017-06-15 14:35:27',1,1,'查询','10002','btn-e19afb12a5604aa1996be98b73424bda'),(233,1,'查询','229',1,4,'','','',1,'2017-06-15 14:35:36','2017-06-15 14:35:36',1,1,'查询','10002','btn-a1d297584c5742a9a627a8b67c268413'),(234,1,'查询','230',1,4,'','','',1,'2017-06-15 14:35:47','2017-06-15 14:35:47',1,1,'查询','10002','btn-0a168c0b61a84740b5f853aa0a608bf1');

/*Table structure for table `mc_user_info` */

CREATE TABLE `mc_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'zid',
  `mc_seller_company_id` int(11) DEFAULT '0' COMMENT 'mc_seller_company表主键',
  `user_name` varchar(25) DEFAULT '' COMMENT '用户姓名',
  `password` varchar(45) DEFAULT '' COMMENT '密码',
  `flag` int(2) DEFAULT '2' COMMENT '是否有效用户 1否 2是',
  `idcard` varchar(20) DEFAULT '' COMMENT '身份证号',
  `sex` int(6) DEFAULT '2' COMMENT '性别 1：男 2：女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` longtext COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1981 DEFAULT CHARSET=utf8 COMMENT='API表格';

/*Data for the table `mc_user_info` */

insert  into `mc_user_info`(`id`,`mc_seller_company_id`,`user_name`,`password`,`flag`,`idcard`,`sex`,`birthday`,`mobile`,`email`,`create_time`,`remark`) values (1,0,'admin','63a9f0ea7bb98050796b649e85481845',2,'4677',1,NULL,'13511112221','yangchenglin@huijiayou.cn','2017-04-05 11:15:13','admin edit this user'),(2,0,'程序员A','96e79218965eb72c92a549dd5a330112',2,'46770109',2,NULL,'13511112222','111111@pw.com','2017-04-05 11:15:15','admin edit this user'),(3,0,'权限B','96e79218965eb72c92a549dd5a330112',2,'467701090001',2,NULL,'13511112223','101002677','2017-04-05 11:15:16','admin edit this user'),(4,0,'权限C','96e79218965eb72c92a549dd5a330112',2,'46770109',2,NULL,'13511112224','101002677','2017-04-05 11:15:18','admin edit this user'),(5,0,'阿珂','96e79218965eb72c92a549dd5a330112',2,'12346453456',2,NULL,'13511112225','101002103@qq.com','2017-04-05 11:15:20','admin edit this user'),(6,0,'双儿','96e79218965eb72c92a549dd5a330112',2,'46770109',2,NULL,'13511112226','101002677@qq.com','2017-04-05 11:15:30','admin edit this user'),(7,0,'觉远','96e79218965eb72c92a549dd5a330112',2,'1343452345122345',1,NULL,'13511112227','1351111222','2017-04-05 11:15:32','admin edit this user'),(8,0,'张三丰','96e79218965eb72c92a549dd5a330112',2,'13511112221234',1,NULL,'13511112228','1351111222','2017-04-05 11:17:09','admin edit this user'),(9,0,'张无忌','96e79218965eb72c92a549dd5a330112',2,'135111122t6795676',1,NULL,'13511112229','1351111222','2017-04-05 11:17:05','admin edit this user'),(10,0,'郭靖','96e79218965eb72c92a549dd5a330112',2,'1351111222',1,NULL,'13511112230','211351223','2017-04-05 11:17:50','admin edit this user'),(11,0,'杨过','96e79218965eb72c92a549dd5a330112',2,'13511112235473',1,NULL,'13511112231','1351111223','2017-04-05 11:18:18','admin edit this user'),(12,0,'黄药师','96e79218965eb72c92a549dd5a330112',2,'1351111223',1,NULL,'13511112232','1351111223','2017-04-05 11:19:00','admin edit this user'),(13,0,'爱丽丝.布什','63a9f0ea7bb98050796b649e85481845',2,'1351111223',2,NULL,'13511112233','1351111223@huijiayou.com','2017-04-05 11:19:59','admin edit this user'),(14,0,'小龙女','96e79218965eb72c92a549dd5a330112',2,'',2,NULL,'1341234123412','xialongnv@sdxl.com','2017-05-18 22:39:43','admin create this user'),(15,0,'慕容龙城','96e79218965eb72c92a549dd5a330112',2,'',1,NULL,'1412342','asdfw@coad.com','2017-05-18 22:43:29','admin create this user'),(16,0,'cindy','96e79218965eb72c92a549dd5a330112',2,'',2,NULL,'11111111','cind@hjy.com','2017-05-19 11:47:22','admin create this user'),(17,0,'Rcindya','96e79218965eb72c92a549dd5a330112',2,'',1,NULL,'13900001111','Rcindya@hjy.com','2017-05-19 11:47:55','admin edit this user'),(18,0,'cs_Chen','63a9f0ea7bb98050796b649e85481845',2,'',2,NULL,'1111112','111111','2017-05-25 18:23:48','admin edit this user'),(1980,0,'测试','96e79218965eb72c92a549dd5a330112',2,'',1,NULL,'1390088068','111111@pw.com','2017-05-31 18:02:51','admin edit this user');

/*Table structure for table `mc_user_info_ext` */

CREATE TABLE `mc_user_info_ext` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_info_id` int(11) DEFAULT NULL COMMENT 'mc_user_info表主键',
  `pic_url` varchar(500) DEFAULT '' COMMENT '用户头像',
  `page_css` varchar(40) DEFAULT 'default' COMMENT '后台页面css样式',
  `platform` varchar(5) DEFAULT 'P01' COMMENT '所属后台系统名称 P01：管理后台',
  `parama` varchar(40) DEFAULT '',
  `paramb` varchar(40) DEFAULT '',
  `paramc` varchar(40) DEFAULT '',
  `paramd` varchar(40) DEFAULT '',
  `parame` varchar(40) DEFAULT '',
  `paramf` varchar(40) DEFAULT '',
  `paramg` varchar(40) DEFAULT '',
  `paramh` varchar(40) DEFAULT '',
  `parami` varchar(40) DEFAULT '',
  `paramj` varchar(40) DEFAULT '',
  `paramk` varchar(40) DEFAULT '',
  `paraml` varchar(40) DEFAULT '',
  `paramm` varchar(40) DEFAULT '',
  `paramn` varchar(40) DEFAULT '',
  `paramo` varchar(40) DEFAULT '',
  `paramp` varchar(40) DEFAULT '',
  `paramq` varchar(40) DEFAULT '',
  `paramr` varchar(40) DEFAULT '',
  `params` varchar(40) DEFAULT '',
  `paramt` varchar(40) DEFAULT '' COMMENT 'param a-t 为扩展字段，可以直接替换',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `mc_user_info_ext` */

insert  into `mc_user_info_ext`(`id`,`user_info_id`,`pic_url`,`page_css`,`platform`,`parama`,`paramb`,`paramc`,`paramd`,`parame`,`paramf`,`paramg`,`paramh`,`parami`,`paramj`,`paramk`,`paraml`,`paramm`,`paramn`,`paramo`,`paramp`,`paramq`,`paramr`,`params`,`paramt`) values (1,1,'','contrast','P01','','','','','','','','','','','','','','','','','','','',''),(2,2,'','','P01','','','','','','','','','','','','','','','','','','','',''),(3,3,'','','P01','','','','','','','','','','','','','','','','','','','',''),(4,4,'','','P01','','','','','','','','','','','','','','','','','','','',''),(5,5,'','','P01','','','','','','','','','','','','','','','','','','','',''),(6,6,'','','P01','','','','','','','','','','','','','','','','','','','',''),(7,7,'','','P01','','','','','','','','','','','','','','','','','','','',''),(8,8,'','','P01','','','','','','','','','','','','','','','','','','','',''),(9,9,'','','P01','','','','','','','','','','','','','','','','','','','',''),(10,10,'','','P01','','','','','','','','','','','','','','','','','','','',''),(11,11,'','','P01','','','','','','','','','','','','','','','','','','','',''),(12,12,'','','P01','','','','','','','','','','','','','','','','','','','',''),(13,13,'','','P01','','','','','','','','','','','','','','','','','','','',''),(14,14,'','','P01','','','','','','','','','','','','','','','','','','','',''),(15,15,'','','P01','','','','','','','','','','','','','','','','','','','',''),(16,16,'','','P01','','','','','','','','','','','','','','','','','','','',''),(17,17,'','contrast','P01','','','','','','','','','','','','','','','','','','','',''),(18,18,'','default','P01','','','','','','','','','','','','','','','','','','','',''),(19,1980,'','default','P01','','','','','','','','','','','','','','','','','','','','');

/*Table structure for table `mc_user_role` */

CREATE TABLE `mc_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'zid',
  `mc_user_id` int(11) DEFAULT NULL COMMENT 'mc_user_info 表 主键',
  `mc_role_id` int(11) DEFAULT NULL COMMENT 'mc_role表主键',
  `flag` int(6) DEFAULT NULL COMMENT '是否删除 1否 2是',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

/*Data for the table `mc_user_role` */

insert  into `mc_user_role`(`id`,`mc_user_id`,`mc_role_id`,`flag`,`create_time`,`update_time`,`create_user_id`,`update_user_id`,`remark`) values (44,2,31,1,'2017-05-02 10:53:37','2017-05-02 10:53:37',1,1,''),(59,3,31,1,'2017-05-19 17:15:40','2017-05-19 17:15:40',1,1,''),(60,4,30,1,'2017-05-19 17:15:41','2017-05-19 17:15:41',1,1,''),(68,4,31,1,'2017-05-24 16:54:04','2017-05-24 16:54:04',1,1,''),(69,4,32,1,'2017-05-24 16:56:50','2017-05-24 16:56:50',1,1,''),(70,3,32,1,'2017-05-24 16:57:24','2017-05-24 16:57:24',1,1,''),(71,3,30,1,'2017-05-24 16:58:29','2017-05-24 16:58:29',1,1,''),(73,6,31,1,'2017-05-24 17:34:54','2017-05-24 17:34:54',1,1,''),(76,2,32,1,'2017-05-24 18:20:19','2017-05-24 18:20:19',1,1,''),(79,7,33,1,'2017-05-25 18:28:32','2017-05-25 18:28:32',1,1,''),(83,5,33,1,'2017-05-26 13:29:57','2017-05-26 13:29:57',1,1,''),(92,1,30,1,'2017-06-08 11:14:41','2017-06-08 11:14:41',1,1,''),(93,17,31,1,'2017-06-13 18:10:49','2017-06-13 18:10:49',1,1,''),(94,18,31,1,'2017-06-14 17:05:54','2017-06-14 17:05:54',1,1,''),(95,13,31,1,'2017-06-14 17:32:50','2017-06-14 17:32:50',1,1,'');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
