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

/*Table structure for table `ac_request_info` */

DROP TABLE IF EXISTS `ac_request_info`;

CREATE TABLE `ac_request_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请求开放接口的组织机构信息表',
  `organization` varchar(50) DEFAULT '' COMMENT '组织机构名称',
  `key` varchar(52) DEFAULT '' COMMENT '组织机构标识',
  `value` varchar(52) DEFAULT '' COMMENT '组织结构秘钥',
  `source` int(1) DEFAULT '1' COMMENT '请求源  0:自己公司 1:第三方',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ac_request_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
