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
  `ac_request_info_id` int(11) DEFAULT NULL,
  `ac_include_domain_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ac_api_domain` */

/*Table structure for table `ac_api_info` */

DROP TABLE IF EXISTS `ac_api_info`;

CREATE TABLE `ac_api_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'api信息表',
  `target` varchar(50) DEFAULT '' COMMENT 'api名称',
  `atype` varchar(10) DEFAULT 'private' COMMENT '接口类型 private:私有 即公司内部使用的接口| public:公开，即开放给第三方的接口',
  `module` varchar(20) DEFAULT '' COMMENT 'maven sub module name  比如：matrix-file',
  `processor` varchar(300) DEFAULT '' COMMENT '业务处理接口的类 com.matrix.processor.publics.example.TestPublicProcessor',
  `domain` int(2) DEFAULT '0' COMMENT '接口是否拥有跨域行为 0 不允许  1 允许跨域访问|ac_api_domain表作为关联',
  `project_id` int(11) DEFAULT NULL COMMENT '所属内部项目id,用于树形结构展示|ac_api_project表id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ac_api_info` */

/*Table structure for table `ac_api_project` */

DROP TABLE IF EXISTS `ac_api_project`;

CREATE TABLE `ac_api_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'api所属项目-应对可能出现的多项目',
  `target` varchar(25) DEFAULT '' COMMENT '项目名称',
  `aflag` int(2) DEFAULT '1' COMMENT '是否有效 0无效 1有效',
  `create_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `ac_api_project` */

insert  into `ac_api_project`(`id`,`target`,`aflag`,`create_time`,`create_user_id`,`update_time`,`update_user_id`) values (1,'测试api组-内部',1,'2017-11-14 14:47:19',1,'2017-11-14 15:22:16',1),(2,'open-api',1,'2017-11-14 15:13:24',1,'2017-11-19 13:29:21',1),(3,'动画片',0,'2017-11-14 15:13:55',1,'2017-11-14 17:05:09',1),(4,'asdf',0,'2017-11-14 15:29:19',1,'2017-11-14 17:05:12',1),(5,'999795792',0,'2017-11-14 15:31:24',1,'2017-11-14 16:07:19',1),(6,'app',1,'2017-11-14 16:56:08',1,'2017-11-19 13:44:28',1);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `ac_include_domain` */

insert  into `ac_include_domain`(`id`,`domain`,`company_name`,`project`,`flag`,`create_time`,`create_user_id`,`update_time`,`update_user_id`,`remark`) values (1,'www.baidu.com','百度','',1,'2017-11-17 23:29:11',1,'2017-11-17 23:29:11',1,NULL),(2,'www.baihe.com','阿斯蒂芬','',0,'2017-11-17 23:30:20',1,'2017-11-19 13:40:19',1,NULL),(3,'www.sina.com','sina','',1,'2017-11-18 21:47:25',1,'2017-11-18 21:47:25',1,NULL);

/*Table structure for table `ac_request_info` */

DROP TABLE IF EXISTS `ac_request_info`;

CREATE TABLE `ac_request_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请求开放接口的组织机构信息表|字典表-缓存化',
  `organization` varchar(50) DEFAULT '' COMMENT '组织机构名称',
  `key` varchar(52) DEFAULT '' COMMENT '组织机构标识',
  `value` varchar(52) DEFAULT '' COMMENT '组织结构秘钥',
  `atype` varchar(8) DEFAULT 'private' COMMENT '请求权限  private:私有 即公司内部使用的接口| public:公开，即开放给第三方的接口',
  `create_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ac_request_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
