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
-- Table structure for table `articlequote`
--

DROP TABLE IF EXISTS `articlequote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articlequote` (
  `id` bigint(12) unsigned NOT NULL AUTO_INCREMENT,
  `articleid` bigint(12) NOT NULL,
  `quotetext` varchar(500) DEFAULT NULL,
  `quoteauthor` varchar(45) DEFAULT NULL,
  `timestamp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `articleid_UNIQUE` (`articleid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articlequote`
--

LOCK TABLES `articlequote` WRITE;
/*!40000 ALTER TABLE `articlequote` DISABLE KEYS */;
INSERT INTO `articlequote` VALUES (1,9,'test','test','2019.03.05.01.15.02'),(2,10,'test','test','2019.03.05.01.15.10'),(3,11,'test','test','2019.03.05.01.17.26'),(4,12,'test','test','2019.03.05.01.52.11'),(5,22,'test','test','2019.03.05.02.52.31'),(6,23,'test','test','2019.03.05.03.26.32'),(7,24,'test','test','2019.03.05.03.26.49'),(8,25,'test','test','2019.03.05.03.27.40'),(9,26,'set','set','2019.03.05.03.32.01'),(10,27,'test','test','2019.03.05.17.23.23'),(11,28,'sdf','sdf','2019.03.05.17.57.47'),(12,29,'qwe','qwe','2019.03.05.18.29.07'),(13,30,'asd','asd','2019.03.05.18.30.55'),(14,31,'article 1','article 1','2019.03.06.03.16.43'),(15,32,'article 2','article 2','2019.03.06.03.17.12'),(16,33,'article 3','article 3','2019.03.06.03.17.44'),(17,34,'article 4','article 4','2019.03.06.03.18.16'),(18,35,'article 5','article 5','2019.03.06.03.18.44'),(19,36,'article 6','article 6','06 March 2019');
/*!40000 ALTER TABLE `articlequote` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-24 10:25:04
