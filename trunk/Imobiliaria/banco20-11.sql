/*
SQLyog Ultimate v8.55 
MySQL - 5.5.28 : Database - imobiliaria
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`imobiliaria` /*!40100 DEFAULT CHARACTER SET latin1 */;

/*Table structure for table `imoveln` */

DROP TABLE IF EXISTS `imoveln`;

CREATE TABLE `imoveln` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `numero` int(9) DEFAULT NULL,
  `rua` varchar(80) DEFAULT NULL,
  `bairro` varchar(80) DEFAULT NULL,
  `cidade` varchar(80) DEFAULT NULL,
  `idPessoaProprietario` int(9) DEFAULT NULL,
  `valor` float(7,2) DEFAULT NULL,
  `vendido` int(1) DEFAULT NULL,
  `tamanho` float(7,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_imovelnPssPrp` (`idPessoaProprietario`),
  CONSTRAINT `FK_imovelnPssPrp` FOREIGN KEY (`idPessoaProprietario`) REFERENCES `pessoan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `imoveln` */

/*Table structure for table `pessoan` */

DROP TABLE IF EXISTS `pessoan`;

CREATE TABLE `pessoan` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `cpf` int(11) NOT NULL,
  `rua` varchar(80) DEFAULT NULL,
  `bairro` varchar(80) DEFAULT NULL,
  `cidade` varchar(80) DEFAULT NULL,
  `numero` int(9) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `pessoan` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `nome` varchar(80) DEFAULT '',
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `senha` varchar(15) DEFAULT NULL,
  `login` varchar(15) NOT NULL,
  `perfil` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`,`login`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`nome`,`id`,`senha`,`login`,`perfil`) values ('bruno',1,'123','bruno',1);

/*Table structure for table `venda` */

DROP TABLE IF EXISTS `venda`;

CREATE TABLE `venda` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `idPessoaProprietario` int(9) DEFAULT NULL,
  `idImovel` int(9) DEFAULT NULL,
  `valor` float(7,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_vendaPssPrp` (`idPessoaProprietario`),
  KEY `FK_vendaImv` (`idImovel`),
  CONSTRAINT `FK_vendaImv` FOREIGN KEY (`idImovel`) REFERENCES `imoveln` (`id`),
  CONSTRAINT `FK_vendaPssPrp` FOREIGN KEY (`idPessoaProprietario`) REFERENCES `pessoan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `venda` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
