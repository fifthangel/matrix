/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.15 : Database - apicenter
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`apicenter` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `apicenter`;

/*Table structure for table `ac_api_domain` */

DROP TABLE IF EXISTS `ac_api_domain`;

CREATE TABLE `ac_api_domain` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ac_api_info 与 ac_include_domain 的关联表',
  `ac_api_info_id` int(11) DEFAULT NULL,
  `ac_include_domain_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `ac_api_domain` */

insert  into `ac_api_domain`(`id`,`ac_api_info_id`,`ac_include_domain_id`) values (3,80160004,4),(4,80160004,5),(5,80160005,4),(6,80160006,4),(9,80160008,5),(16,80160001,4),(17,80160001,5),(18,80160007,4),(19,80160007,5);

/*Table structure for table `ac_api_info` */

DROP TABLE IF EXISTS `ac_api_info`;

CREATE TABLE `ac_api_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'api信息表',
  `name` varchar(50) DEFAULT '' COMMENT '接口中文描述   树展示使用',
  `target` varchar(50) DEFAULT NULL COMMENT '系统接口名称 比如：TEST-PUBLIC-PROCESSOR，访问标识',
  `atype` varchar(10) DEFAULT 'private' COMMENT '接口类型 private:私有 即公司内部使用的接口| public:公开，即开放给第三方的接口',
  `module` varchar(20) DEFAULT 'matrix-api' COMMENT 'maven sub module name  比如：matrix-file',
  `processor` varchar(300) DEFAULT '' COMMENT '业务处理接口的类 com.matrix.processor.publics.example.TestPublicProcessor',
  `domain` int(2) DEFAULT '0' COMMENT '接口是否拥有跨域行为 0 不允许  1 允许跨域访问|ac_api_domain表作为关联',
  `parent_id` int(11) DEFAULT NULL COMMENT '所属内部项目id,用于树形结构展示|ac_api_project表id',
  `seqnum` int(11) DEFAULT NULL COMMENT '顺序码 同一层次显示顺序',
  `discard` int(2) DEFAULT '1' COMMENT '这个api是否废弃|0:废弃 1:使用中',
  `remark` longtext COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80160009 DEFAULT CHARSET=utf8 COMMENT='alter table `ac_api_info` AUTO_INCREMENT=80160001';

/*Data for the table `ac_api_info` */

insert  into `ac_api_info`(`id`,`name`,`target`,`atype`,`module`,`processor`,`domain`,`parent_id`,`seqnum`,`discard`,`remark`,`create_time`,`create_user_id`,`update_time`,`update_user_id`) values (80160001,'订单信息','ORDER-INFO','private','matrix-api','private.order.OrderInfomation',1,1,1,1,'ORDER-INFO','2017-11-29 10:35:54',1,'2017-11-30 22:33:25',1),(80160004,'开放订单','OPEN-API-ORDER-INFO','public','matrix-api','public.order.aaa',1,2,1,1,'OPEN-API-ORDER-INFO','2017-11-29 11:24:07',1,'2017-11-29 11:24:07',1),(80160007,'测试接口1','TEST-INTERFACE-ONE','private','matrix-api','private.test.aaasdfiProdess',1,1,2,0,'private.test.aaasdfiProdess','2017-11-29 15:04:16',1,'2017-12-01 19:12:00',1),(80160008,'测试接口2','TEST-INTERFACE-TWO','private','matrix-api','private.test.aidwlprocesser',1,1,3,1,'TEST-INTERFACE-TWO','2017-11-29 15:12:11',1,'2017-11-29 15:12:11',1);

/*Table structure for table `ac_api_project` */

DROP TABLE IF EXISTS `ac_api_project`;

CREATE TABLE `ac_api_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'api所属项目-应对可能出现的多项目',
  `target` varchar(25) DEFAULT '' COMMENT '项目名称',
  `atype` varchar(10) DEFAULT 'private' COMMENT '接口类型 private:私有 即公司内部使用的接口| public:公开，即开放给第三方的接口',
  `aflag` int(2) DEFAULT '1' COMMENT '是否有效 0无效 1有效',
  `create_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `ac_api_project` */

insert  into `ac_api_project`(`id`,`target`,`atype`,`aflag`,`create_time`,`create_user_id`,`update_time`,`update_user_id`) values (1,'测试api组-内部','private',1,'2017-11-14 14:47:19',1,'2017-11-14 15:22:16',1),(2,'open-api','public',1,'2017-11-14 15:13:24',1,'2017-11-19 13:29:21',1),(3,'动画片','private',0,'2017-11-14 15:13:55',1,'2017-11-14 17:05:09',1),(6,'app','private',1,'2017-11-14 16:56:08',1,'2017-11-19 13:44:28',1),(9,'蔷薇','public',1,'2017-11-28 17:09:03',1,'2017-11-28 17:09:03',1);

/*Table structure for table `ac_include_domain` */

DROP TABLE IF EXISTS `ac_include_domain`;

CREATE TABLE `ac_include_domain` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录系统允许跨域的域名',
  `domain` varchar(100) DEFAULT '' COMMENT '域名',
  `company_name` varchar(100) DEFAULT '' COMMENT '所属公司',
  `project` varchar(25) DEFAULT '' COMMENT '所属项目名称',
  `flag` int(2) DEFAULT '1' COMMENT '状态位-是否有效 0无效 1有效',
  `create_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `remark` longtext COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `ac_include_domain` */

insert  into `ac_include_domain`(`id`,`domain`,`company_name`,`project`,`flag`,`create_time`,`create_user_id`,`update_time`,`update_user_id`,`remark`) values (4,'http://api.baidu.com','百度','',1,'2017-11-28 11:17:47',1,'2017-11-28 11:17:47',1,NULL),(5,'http://sub.model.firos.com.cn','氢氧焰','',1,'2017-11-28 11:19:23',1,'2017-12-02 22:59:14',1,NULL);

/*Table structure for table `ac_request_info` */

DROP TABLE IF EXISTS `ac_request_info`;

CREATE TABLE `ac_request_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请求开放接口的组织机构信息表|字典表-缓存化',
  `organization` varchar(50) DEFAULT '' COMMENT '组织机构名称',
  `key` varchar(52) DEFAULT '' COMMENT '组织机构标识',
  `value` varchar(52) DEFAULT '' COMMENT '组织结构秘钥',
  `atype` varchar(8) DEFAULT 'private' COMMENT '请求权限  private:私有 即公司内部使用的接口| public:公开，即开放给第三方的接口',
  `flag` int(2) DEFAULT '1' COMMENT '启用1 禁用 0',
  `create_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `ac_request_info` */

insert  into `ac_request_info`(`id`,`organization`,`key`,`value`,`atype`,`flag`,`create_time`,`create_user_id`,`update_time`,`update_user_id`) values (1,'IOS乘客端','133C9C129D53','6DFA608D49324E47A5D69A13523BDFDA','private',1,'2017-12-01 17:13:47',1,'2017-12-01 17:13:47',1),(2,'广州交委','133C9C12A19B','20840A21482E464FB8B86FF15EACE399','public',1,'2017-12-01 17:24:42',1,'2017-12-01 17:24:43',1);

/*Table structure for table `ac_request_open_api` */

DROP TABLE IF EXISTS `ac_request_open_api`;

CREATE TABLE `ac_request_open_api` (
  `id` int(11) NOT NULL COMMENT 'open-api与第三方请求者关联信息',
  `ac_request_info_id` int(11) DEFAULT NULL,
  `ac_api_info_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ac_request_open_api` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
