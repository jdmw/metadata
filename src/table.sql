/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.19-log : Database - finance
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
USE `finance`;

/*Table structure for table `metadata-entity` */

DROP TABLE IF EXISTS `metadata-entity`;

CREATE TABLE `metadata-entity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `parentid` int(11) DEFAULT '-1',
  `level` tinyint(1) DEFAULT NULL COMMENT '层次 1-n',
  `sort` smallint(6) DEFAULT '0',
  `disable` tinyint(1) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `metadata-fields` */

DROP TABLE IF EXISTS `metadata-fields`;

CREATE TABLE `metadata-fields` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(256) NOT NULL COMMENT '中文名称',
  `ename` varchar(256) DEFAULT NULL COMMENT '英文名称',
  `abbr` varchar(256) DEFAULT NULL COMMENT '英文缩写',
  `is_primary_key` tinyint(1) NOT NULL DEFAULT '0' COMMENT '主键',
  `is_foreign_key` tinyint(1) NOT NULL DEFAULT '0' COMMENT '外键',
  `is_nullable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可空',
  `default_value` varchar(256) DEFAULT NULL COMMENT '默认值',
  `extension` varchar(200) DEFAULT NULL COMMENT '其他属性',
  `bus_datatype` tinyint(1) NOT NULL DEFAULT '0' COMMENT '业务属性-数据类型 0:文本 1：数值 2：枚举 3：日期 4 ：时间 ',
  `bus_length` smallint(6) DEFAULT NULL COMMENT '业务属性-数据长度 ',
  `bus_format` tinyint(1) DEFAULT NULL COMMENT '业务属性-数据格式 ，如日期YYYY-MM-dd ，时间 hh:mm',
  `bus_unit` varchar(32) DEFAULT NULL COMMENT '业务属性-单位 ，如:亿元',
  `bus_rule` varchar(2000) DEFAULT NULL COMMENT '业务属性-业务规则 ',
  `field_type_id` int(11) DEFAULT NULL COMMENT '数据元类型域',
  `tech_datatype` varchar(32) DEFAULT NULL COMMENT '技术属性-数据类型',
  `tech_length` smallint(6) DEFAULT NULL COMMENT '技术属性-数据长度',
  `tech_precision` smallint(6) DEFAULT NULL COMMENT '技术属性-数据精度',
  `description` varchar(2000) DEFAULT NULL COMMENT '说明',
  `order` smallint(6) DEFAULT '0' COMMENT '表内字段排序',
  `disable` tinyint(1) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `metadata-fieldtype` */

DROP TABLE IF EXISTS `metadata-fieldtype`;

CREATE TABLE `metadata-fieldtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tech_datatype` varchar(32) DEFAULT NULL COMMENT '技术属性-数据类型',
  `tech_length` smallint(6) DEFAULT NULL COMMENT '技术属性-数据长度',
  `tech_precision` smallint(6) DEFAULT NULL COMMENT '技术属性-数据精度',
  `description` varchar(2000) DEFAULT NULL COMMENT '说明',
  `disable` tinyint(1) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `metadata-foreignkey` */

DROP TABLE IF EXISTS `metadata-foreignkey`;

CREATE TABLE `metadata-foreignkey` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key_name` varchar(256) NOT NULL,
  `entity_id` varchar(256) NOT NULL COMMENT '实体名称',
  `entity_field` varchar(256) NOT NULL COMMENT '外键属性',
  `foreign_id` varchar(256) NOT NULL COMMENT '参照实体',
  `foreign_field` varchar(256) NOT NULL COMMENT '参照属性',
  `radix` varchar(10) NOT NULL COMMENT '本实体中基数,“0,1,N”表示为“0,1,N”',
  `disable` tinyint(1) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
