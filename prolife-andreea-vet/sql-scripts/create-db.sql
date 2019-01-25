DROP SCHEMA IF EXISTS `prolife-andreea-vet`;

CREATE SCHEMA `prolife-andreea-vet`;

use `prolife-andreea-vet`;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `proprietar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `telefon` varchar(45) DEFAULT NULL,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `animal`;

CREATE TABLE `animal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) DEFAULT NULL,
  `specie` varchar(45) DEFAULT NULL,
  `rasa` varchar(45) DEFAULT NULL,
  `greutate` double DEFAULT NULL,
  `data_nasterii` date,
  `proprietar_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idz` (`proprietar_id`),
  CONSTRAINT `FK_DETAILs` FOREIGN KEY (`proprietar_id`) 
  REFERENCES `proprietar` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `animal_detail`;

CREATE TABLE `animal_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `anamneza` text,
  `tratament` text,
  `observatii` text,
  `animal_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`animal_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`animal_detail_id`) 
  REFERENCES `animal_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;











SET FOREIGN_KEY_CHECKS = 1;
