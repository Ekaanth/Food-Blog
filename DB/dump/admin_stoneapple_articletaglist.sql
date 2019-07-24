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
-- Table structure for table `articletaglist`
--

DROP TABLE IF EXISTS `articletaglist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articletaglist` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `articleid` varchar(45) DEFAULT NULL,
  `tagid` varchar(45) DEFAULT NULL,
  `tagName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articletaglist`
--

LOCK TABLES `articletaglist` WRITE;
/*!40000 ALTER TABLE `articletaglist` DISABLE KEYS */;
INSERT INTO `articletaglist` VALUES (1,'11','43','fresh'),(2,'12','43','fresh'),(3,'12','45','fresh'),(4,'12','38','fresh'),(5,'12','40','fresh'),(6,'12','39','fresh'),(7,'22','44','fresh'),(8,'22','43','drinks'),(9,'22','37','food'),(10,'22','38','health'),(11,'22','45','heel'),(12,'22','40','salad'),(13,'22','39','summer'),(14,'22','42','wind'),(15,'22','41','winer'),(16,'23','44','fresh'),(17,'23','43','drinks'),(18,'23','37','food'),(19,'23','38','health'),(20,'23','45','heel'),(21,'23','40','salad'),(22,'23','39','summer'),(23,'23','42','wind'),(24,'23','41','winer'),(25,'24','44','fresh'),(26,'24','43','drinks'),(27,'24','37','food'),(28,'24','38','health'),(29,'24','45','heel'),(30,'24','40','salad'),(31,'24','39','summer'),(32,'24','42','wind'),(33,'24','41','winer'),(34,'25','44','fresh'),(35,'25','43','drinks'),(36,'25','37','food'),(37,'25','38','health'),(38,'25','45','heel'),(39,'25','40','salad'),(40,'25','39','summer'),(41,'25','42','wind'),(42,'25','41','winer'),(43,'26','44','fresh'),(44,'26','43','drinks'),(45,'26','37','food'),(46,'27','43','drinks'),(47,'27','37','food'),(48,'27','44','fresh'),(49,'27','38','health'),(50,'27','45','heel'),(51,'27','40','salad'),(52,'27','39','summer'),(53,'27','42','wind'),(54,'27','41','winer'),(55,'28','43','drinks'),(56,'28','37','food'),(57,'28','44','fresh'),(58,'28','38','health'),(59,'28','45','heel'),(60,'28','40','salad'),(61,'28','39','summer'),(62,'28','42','wind'),(63,'28','41','winer'),(64,'29','43','drinks'),(65,'29','37','food'),(66,'29','44','fresh'),(67,'29','38','health'),(68,'29','45','heel'),(69,'29','40','salad'),(70,'29','39','summer'),(71,'29','42','wind'),(72,'29','41','winer'),(73,'30','43','drinks'),(74,'30','37','food'),(75,'30','44','fresh'),(76,'30','38','health'),(77,'30','45','heel'),(78,'30','40','salad'),(79,'30','39','summer'),(80,'30','42','wind'),(81,'30','41','winer'),(82,'31','43','drinks'),(83,'31','37','food'),(84,'32','37','food'),(85,'32','44','fresh'),(86,'33','38','health'),(87,'33','45','heel'),(88,'34','38','health'),(89,'34','45','heel'),(90,'35','38','health'),(91,'35','40','salad'),(92,'35','45','heel'),(93,'36','45','heel'),(94,'36','37','food'),(95,'36','44','fresh'),(96,'36','38','health');
/*!40000 ALTER TABLE `articletaglist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-24 10:24:59
