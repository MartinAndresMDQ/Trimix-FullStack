/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 10.4.14-MariaDB : Database - trimixdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`trimixdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `trimixdb`;

/*Table structure for table `persona` */

DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `perId` bigint(20) NOT NULL AUTO_INCREMENT,
  `perApellido` varchar(255) DEFAULT NULL,
  `perFechaNacimiento` date DEFAULT NULL,
  `perNombre` varchar(255) DEFAULT NULL,
  `perNumeroDocumento` bigint(20) DEFAULT NULL,
  `perTipoDocumento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`perId`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

/*Data for the table `persona` */

insert  into `persona`(`perId`,`perApellido`,`perFechaNacimiento`,`perNombre`,`perNumeroDocumento`,`perTipoDocumento`) values 
(1,'Lencina','1993-02-20','Martin',37058145,'DNI'),
(2,'Martinez','2000-10-20','Juan',22231456,'DNI'),
(3,'Lamba','1993-03-30','Sol',32000212,'Pasaporte'),
(4,'Cebada','1999-12-02','Matias',22234564,'Cedula'),
(5,'Tania','1994-12-03','Maria',36054322,'Pasaporte'),
(6,'Chica','1980-10-20','Adriana',22333444,'Cedula'),
(7,'Nueva','1940-01-01','Noelia',12345670,'Pasaporte'),
(8,'Ramirez','1985-10-31','Leandro',28520258,'DNI'),
(9,'Idea','2010-10-29','Franco',68642100,'DNI'),
(10,'Starita','1972-05-10','Santiago',12020234,'Cedula'),
(11,'Leiva','1990-11-07','Karen',33569312,'DNI');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
