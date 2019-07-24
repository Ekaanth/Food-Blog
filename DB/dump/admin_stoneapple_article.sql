-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 13.233.93.0    Database: admin_stoneapple
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `articleheading` varchar(200) NOT NULL,
  `articleby` varchar(50) NOT NULL,
  `artcleimage` longtext,
  `articlemaintag` varchar(45) NOT NULL,
  `articlefirst` longtext NOT NULL,
  `articlesecond` longtext,
  `articletimestamp` varchar(45) DEFAULT NULL,
  `articlestatus` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (31,'article 1','article 1','https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png','drinks','article 1','article 1','06 March 2019','ACTIVE'),(32,'article 2','article 2','https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png','drinks','article 2','article 2','06 March 2019','ACTIVE'),(33,'article 3','article 3','https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png','drinks','article 3','article 3','06 March 2019','ACTIVE'),(34,'article 4','article 4','https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png','drinks','article 4','article 4','06 March 2019','ACTIVE'),(35,'article 5','article 5','https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png','drinks','article 5','article 5','06 March 2019','ACTIVE'),(36,'article 6','article 6','https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png','drinks','article 6','article 6','06 March 2019','ACTIVE');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-24 10:25:08
