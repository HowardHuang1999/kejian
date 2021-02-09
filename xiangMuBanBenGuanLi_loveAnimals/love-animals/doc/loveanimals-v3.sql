/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 8.0.13 : Database - loveanimals-v3
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
USE `loveanimals-v3`;

/*Table structure for table `adopttable` */

DROP TABLE IF EXISTS `adopttable`;

CREATE TABLE `adopttable` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci NOT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `age` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci NOT NULL,
  `address` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci NOT NULL,
  `idcard` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci NOT NULL,
  `unitname` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `house` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `idphoto` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `introduce` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `animalsid` int(10) DEFAULT NULL,
  `animalsphoto` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci DEFAULT '0',
  `create_time` date DEFAULT NULL,
  `buserid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `a` (`animalsid`),
  KEY `b` (`buserid`),
  CONSTRAINT `a` FOREIGN KEY (`animalsid`) REFERENCES `animalstable` (`id`),
  CONSTRAINT `b` FOREIGN KEY (`buserid`) REFERENCES `busertable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci;

/*Data for the table `adopttable` */

insert  into `adopttable`(`id`,`name`,`sex`,`age`,`phone`,`address`,`idcard`,`unitname`,`house`,`idphoto`,`introduce`,`animalsid`,`animalsphoto`,`status`,`create_time`,`buserid`) values (2,'庞志聪',NULL,NULL,'13531104031','广东湛江','440804199901011122',NULL,NULL,NULL,'喜欢小动物',20,NULL,NULL,'2020-09-26',NULL),(3,'庞志聪',NULL,NULL,'13531104031','广东湛江','440804199901011122',NULL,NULL,NULL,'喜欢小动物',19,NULL,'0','2020-10-11',NULL),(7,'庞志聪',NULL,NULL,'13531104031','广东','440804199901011122',NULL,NULL,NULL,'喜欢小动物',19,NULL,'0','2020-10-11',NULL),(8,'庞志聪',NULL,NULL,'13531104031','广东','440804199901011122',NULL,NULL,NULL,'喜欢小动物',19,NULL,'0','2020-10-11',NULL),(10,'庞志聪',NULL,NULL,'13531104031','广东','440804199901011122',NULL,NULL,NULL,'喜欢小动物',19,NULL,'0','2020-10-11',NULL),(11,'111','男','111','111','111','','111','租赁',NULL,'1111',19,NULL,'0','2020-10-23',NULL),(12,'111','男','111','111','111','','111','租赁',NULL,'1111',19,NULL,'0','2020-10-23',NULL),(13,'111','男','111','111','111','','111','租赁',NULL,'1111',19,NULL,'0','2020-10-23',NULL),(14,'111','男','111','111','111','','111','租赁',NULL,'1111',19,NULL,'0','2020-10-23',NULL),(15,'111','男','11','111','111','','111','租赁',NULL,'1111',19,NULL,'0','2020-10-23',NULL),(17,'2222','男','22233','333','33','','333','租赁',NULL,'1111',19,NULL,'0','2020-10-23',NULL),(18,'333','女','3333','333','333','','3333','租赁',NULL,'aaaa',20,NULL,'0','2020-10-23',NULL),(19,'99999','男','99','9999','99999','','99999','租赁',NULL,'2222',21,NULL,'0','2020-10-23',NULL);

/*Table structure for table `animalscollection` */

DROP TABLE IF EXISTS `animalscollection`;

CREATE TABLE `animalscollection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buserid` int(11) DEFAULT NULL,
  `animalsid` int(11) DEFAULT NULL,
  `collection` varchar(2) COLLATE utf8_unicode_ci DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `f` (`buserid`),
  KEY `g` (`animalsid`),
  CONSTRAINT `f` FOREIGN KEY (`buserid`) REFERENCES `busertable` (`id`),
  CONSTRAINT `g` FOREIGN KEY (`animalsid`) REFERENCES `animalstable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `animalscollection` */

insert  into `animalscollection`(`id`,`buserid`,`animalsid`,`collection`) values (1,1,19,'1'),(2,1,20,'1');

/*Table structure for table `animalstable` */

DROP TABLE IF EXISTS `animalstable`;

CREATE TABLE `animalstable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `animals_image` blob,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `aintroduce` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo1` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo2` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo3` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo4` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo5` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '0',
  `create_time` date DEFAULT NULL,
  `weight` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `animalstable` */

insert  into `animalstable`(`id`,`aname`,`animals_image`,`sex`,`age`,`aintroduce`,`photo1`,`photo2`,`photo3`,`photo4`,`photo5`,`status`,`create_time`,`weight`) values (19,'老大','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2998635495,2714432347&fm=26&gp=0.jpg','哥哥','1-2岁','狗的特点有dao忠诚、对主人友du善、爱啃骨头zhi 、聪明，不同dao的犬还有其版他不同的特点，权很难一概而论。贝灵顿绠犬 性情温柔活泼，不掉毛，不用担心家里狗毛乱飞，也从不乱叫，不用担心扰邻，此犬稀有，外形酷似绵羊，一般适合小孩：忠诚主人；适合城市生活；即能适应炎热的天气也能适应寒冷的气候；是优秀的守门犬','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2998635495,2714432347&fm=26&gp=0.jpg','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2998635495,2714432347&fm=26&gp=0.jpg','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2393757598,2038562536&fm=26&gp=0.jpg','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2393757598,2038562536&fm=26&gp=0.jpg','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2393757598,2038562536&fm=26&gp=0.jpg','1','2020-10-07',NULL),(20,'小吉','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2393757598,2038562536&fm=26&gp=0.jpg','妹妹','3-5岁','淘气',NULL,NULL,NULL,NULL,NULL,'1','2020-10-07',NULL),(21,'老斑点','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1234000028,2879776889&fm=26&gp=0.jpg','妹妹','1-2岁','听话',NULL,NULL,NULL,NULL,NULL,'1','2020-10-07',NULL),(22,'小黄','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1350849671,1426294603&fm=26&gp=0.jpg','妹妹','1-2岁','听话',NULL,NULL,NULL,NULL,NULL,'0','2020-10-07',NULL),(23,'小黑','https://ns-strategy.cdn.bcebos.com/ns-strategy/upload/fc_big_pic/part-00679-2876.jpg','哥哥','1-2岁','活泼',NULL,NULL,NULL,NULL,NULL,'0','2020-10-07',NULL),(31,'aaa','http://localhost:8080/images/2020/11/09/16fed8dba9af4838a6925ac443cab854.jpg','哥哥','1-2岁','调皮，可爱',NULL,NULL,NULL,NULL,NULL,'0','2020-11-09',NULL);

/*Table structure for table `ausertable` */

DROP TABLE IF EXISTS `ausertable`;

CREATE TABLE `ausertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `apwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `idcard` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '0',
  `photo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `ausertable` */

insert  into `ausertable`(`id`,`aname`,`apwd`,`name`,`idcard`,`status`,`photo`,`address`) values (1,'admin1','admin1',NULL,NULL,'0',NULL,NULL),(3,'admin2','admin2',NULL,NULL,'0',NULL,NULL),(4,'ad','ad',NULL,NULL,'0',NULL,NULL),(5,'ad1','ad1',NULL,NULL,'0',NULL,NULL),(6,'aaa','admin',NULL,NULL,'0',NULL,NULL),(7,'admin3','admin3','庞志聪','440804199901011122','0','http://localhost:8080/images/2020/11/09/caf2c0b1424a427aba160130c3880b3b.jpg','广东湛江');

/*Table structure for table `busertable` */

DROP TABLE IF EXISTS `busertable`;

CREATE TABLE `busertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `bpwd` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `headphoto` varchar(300) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(2) COLLATE utf8_unicode_ci DEFAULT '1',
  `username` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `busertable` */

insert  into `busertable`(`id`,`bname`,`bpwd`,`headphoto`,`status`,`username`) values (1,'user1','user1','https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1605430951&di=546e28c155c4e63388da79b6460eb1cf&src=http://bbs.jf311.com/data/attachment/forum/201505/25/113407e6v4pom4yen44ee4.jpg','1','小李子'),(2,'user2','user2','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2393757598,2038562536&fm=26&gp=0.jpg','1','八阿哥');

/*Table structure for table `donatepeople` */

DROP TABLE IF EXISTS `donatepeople`;

CREATE TABLE `donatepeople` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `message` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `money` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `moneyway` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `buserid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `c` (`buserid`),
  CONSTRAINT `c` FOREIGN KEY (`buserid`) REFERENCES `busertable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci;

/*Data for the table `donatepeople` */

insert  into `donatepeople`(`id`,`name`,`phone`,`email`,`message`,`money`,`moneyway`,`create_time`,`buserid`) values (1,'庞志聪','18211295134',NULL,NULL,'11',NULL,'2020-10-23',NULL),(2,'庞志聪','13531104031','1767064249@qq.com',NULL,'11',NULL,'2020-11-12',1),(3,'庞志聪','13531104031','1767064249@qq.com',NULL,'11',NULL,'2020-11-12',1),(4,'庞志聪','13531104031','1767064249@qq.com',NULL,'11',NULL,'2020-11-12',1),(5,'庞志聪','13531104031','1767064249@qq.com',NULL,'11',NULL,'2020-11-12',1),(6,'庞志聪','13531104031','1767064249@qq.com',NULL,'11',NULL,'2020-11-12',1);

/*Table structure for table `email` */

DROP TABLE IF EXISTS `email`;

CREATE TABLE `email` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `receiver` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `text` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `email` */

insert  into `email`(`id`,`sender`,`receiver`,`text`,`title`) values (1,'1767064249@qq.com',NULL,'aaaaa','aaaa'),(2,NULL,'1767064249@qq.com','aaaaa','aaaa'),(3,'176706424','1767064249@qq.com','aaaaa','aaaa'),(4,'1767064249@qq.com','1767064249@qq.com','aaaaa','aaaa'),(5,'1767064249','1767064249@qq.com','aaaaa','aaaa'),(6,'A1767064249@163.com','1767064249@qq.com','aaaaa','aaaa'),(7,'A1767064249@163.com','1767064249@qq.com','aaaaa','aaaa'),(8,'A1767064249@163.com','1767064249@qq.com','aaaaa','aaaa'),(9,'1767064249@qq.com','1767064249@qq.com','aaaaa','aaaa'),(10,'1767064249@qq.com','1767064249@qq.com','aaaaa','aaaa'),(11,'1767064249@qq.com','1767064249@qq.com','aaaaa','aaaa'),(12,'1767064249@qq.com','1767064249@qq.com','aaaa','aaa'),(13,'1767064249@qq.com','1767064249@qq.com','','aaa');

/*Table structure for table `helptable` */

DROP TABLE IF EXISTS `helptable`;

CREATE TABLE `helptable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `introduce` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '0',
  `photo1` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo2` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo3` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `buserid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `d` (`buserid`),
  CONSTRAINT `d` FOREIGN KEY (`buserid`) REFERENCES `busertable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `helptable` */

insert  into `helptable`(`id`,`name`,`phone`,`address`,`introduce`,`status`,`photo1`,`photo2`,`photo3`,`create_time`,`buserid`) values (16,'aaaa','231312321','adsfafd','adfaadfafd','1',NULL,NULL,NULL,NULL,1),(17,'庞志聪','13531104031','广东湛江','喜欢小动物','0',NULL,NULL,NULL,'2020-10-23',NULL),(18,'11','11','11','11','0',NULL,NULL,NULL,'2020-11-15',NULL);

/*Table structure for table `messageboard` */

DROP TABLE IF EXISTS `messageboard`;

CREATE TABLE `messageboard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buserid` int(11) DEFAULT NULL,
  `title` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `content` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `n` (`buserid`),
  CONSTRAINT `n` FOREIGN KEY (`buserid`) REFERENCES `busertable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `messageboard` */

insert  into `messageboard`(`id`,`buserid`,`title`,`content`,`create_time`) values (8,1,'“中国流浪动物救助联盟”首次筹备沟通会圆满举行','这是正文&&搜索功能不能使用和个人空间投稿页面不能访问的问题已经修复完毕，感谢各位的及时反馈。如果还有同样问题发生请在该动态下反馈。','2020-11-15 17:01:02'),(9,2,'“中国流浪动物救助联盟”首次筹备沟通会圆满举行','这是正文&&搜索功能不能使用和个人空间投稿页面不能访问的问题已经修复完毕，感谢各位的及时反馈。如果还有同样问题发生请在该动态下反馈。','2020-11-15 17:01:32');

/*Table structure for table `noticetable` */

DROP TABLE IF EXISTS `noticetable`;

CREATE TABLE `noticetable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ntitle` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ncontent` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '1',
  `photo1` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo2` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo3` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo4` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo5` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `noticetable` */

insert  into `noticetable`(`id`,`ntitle`,`ncontent`,`status`,`photo1`,`photo2`,`photo3`,`photo4`,`photo5`,`create_time`) values (5,'中国小动物保护协会流浪动物救助试点基地 授牌仪式在京举行','10月19日，中国小动物保护协会流浪动物救助试点基地授牌仪式在北京举行。北京太大犬流浪救助基地成为中国小动物保护协会首家合作试点基地。据不完全统计，2014年中国流浪犬数量已达2000万，而近几年这一数字已经攀升至4000万。另一方面，近几年来，中国家庭养宠数量快递攀升，目前宠物犬猫数量已经突破1亿只，宠物依然在上涨。同时宠物弃养、宠物丢失以及流浪繁殖，导致每年新增的流浪动物数量也在增长。如此之多的流浪动物，他们中幸运的话会被一些民间自发组织或者收容所救助，不幸的话，它们面临的就是被屠杀或者惨死街头的命运。','1','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2393757598,2038562536&fm=26&gp=0.jpg',NULL,NULL,NULL,NULL,'2020-09-12'),(6,'京东、河北卫视与中国小动物保护协会三方签订战略协议','10月19日，中国小动物保护协会流浪动物救助试点基地授牌仪式在北京举行。北京太大犬流浪救助基地成为中国小动物保护协会首家合作试点基地。据不完全统计，2014年中国流浪犬数量已达2000万，而近几年这一数字已经攀升至4000万。另一方面，近几年来，中国家庭养宠数量快递攀升，目前宠物犬猫数量已经突破1亿只，宠物依然在上涨。同时宠物弃养、宠物丢失以及流浪繁殖，导致每年新增的流浪动物数量也在增长。如此之多的流浪动物，他们中幸运的话会被一些民间自发组织或者收容所救助，不幸的话，它们面临的就是被屠杀或者惨死街头的命运。','1','https://ns-strategy.cdn.bcebos.com/ns-strategy/upload/fc_big_pic/part-00679-2876.jpg',NULL,NULL,NULL,NULL,'2020-09-24'),(7,'首届中国（聊城）萌宠文化节开幕！','10月19日，中国小动物保护协会流浪动物救助试点基地授牌仪式在北京举行。北京太大犬流浪救助基地成为中国小动物保护协会首家合作试点基地。据不完全统计，2014年中国流浪犬数量已达2000万，而近几年这一数字已经攀升至4000万。另一方面，近几年来，中国家庭养宠数量快递攀升，目前宠物犬猫数量已经突破1亿只，宠物依然在上涨。同时宠物弃养、宠物丢失以及流浪繁殖，导致每年新增的流浪动物数量也在增长。如此之多的流浪动物，他们中幸运的话会被一些民间自发组织或者收容所救助，不幸的话，它们面临的就是被屠杀或者惨死街头的命运。','1','https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1350849671,1426294603&fm=26&gp=0.jpg',NULL,NULL,NULL,NULL,'2020-10-05');

/*Table structure for table `privateletter` */

DROP TABLE IF EXISTS `privateletter`;

CREATE TABLE `privateletter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buserid` int(11) DEFAULT NULL,
  `content` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `readstatus` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `v` (`buserid`),
  CONSTRAINT `v` FOREIGN KEY (`buserid`) REFERENCES `busertable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `privateletter` */

/*Table structure for table `volunteertable` */

DROP TABLE IF EXISTS `volunteertable`;

CREATE TABLE `volunteertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vname` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `vphone` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `vaddress` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `image` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `vintroduce` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varbinary(5) DEFAULT '0',
  `create_time` date DEFAULT NULL,
  `buserid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `e` (`buserid`),
  CONSTRAINT `e` FOREIGN KEY (`buserid`) REFERENCES `busertable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `volunteertable` */

insert  into `volunteertable`(`id`,`vname`,`vphone`,`email`,`sex`,`age`,`vaddress`,`image`,`vintroduce`,`status`,`create_time`,`buserid`) values (13,'阿道夫','421434141',NULL,NULL,NULL,'广东省湛江市坡头区龙头镇',NULL,'我是一个对理想有着执着追求的人，坚信是金子总会发光。','1',NULL,NULL),(15,'阿道夫','3423423434',NULL,NULL,NULL,'的发生大发发',NULL,'撒范德萨发','1','2020-09-24',NULL),(16,'阿道夫','3423423434',NULL,NULL,NULL,'的发生大发发',NULL,'撒范德萨发','1','2020-09-26',NULL),(17,'阿道夫','3423423434','11111','1','111','的发生大发发',NULL,'撒范德萨发','0','2020-10-23',NULL),(18,'阿道夫','3423423434','1767064249@qq.com','1','111','的发生大发发','http://localhost:8080/images/2020/11/09/0cc691a172e64bb4a0cd23c71fd49867.jpg','撒范德萨发','0','2020-11-09',1),(19,'阿道夫','3423423434','1767064249@qq.com','11','111','的发生大发发',NULL,'撒范德萨发','0','2020-11-10',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
