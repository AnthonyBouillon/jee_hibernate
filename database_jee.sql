-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           10.2.14-MariaDB - mariadb.org binary distribution
-- SE du serveur:                Win64
-- HeidiSQL Version:             9.5.0.5293
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Listage de la structure de la base pour java_ee
CREATE DATABASE IF NOT EXISTS `java_ee` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `java_ee`;

-- Listage de la structure de la table java_ee. users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT '0',
  `password` varchar(255) DEFAULT '0',
  `email` varchar(50) DEFAULT '0',
  `sex` varchar(50) DEFAULT '0',
  `country` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8;

-- Listage des données de la table java_ee.users : ~1 rows (environ)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `name`, `password`, `email`, `sex`, `country`) VALUES
	(154, 'tttt', 'tt', 'tt@tt', 'Female', 'india');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
