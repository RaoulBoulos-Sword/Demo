-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: oamstest
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `user_auth_roles`
--

DROP TABLE IF EXISTS `user_auth_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_auth_roles` (
  `user_id` bigint NOT NULL,
  `auth_role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`auth_role_id`),
  KEY `FK1tcllxafukxfftjkpnkxkhnxr` (`auth_role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_auth_roles`
--

LOCK TABLES `user_auth_roles` WRITE;
/*!40000 ALTER TABLE `user_auth_roles` DISABLE KEYS */;
INSERT INTO `user_auth_roles` VALUES (1,1),(1,2),(1,3),(13,1),(15,1),(17,1),(19,1),(21,1),(23,1),(25,1),(27,1),(29,1),(31,1),(33,1),(35,1),(37,1),(39,1),(41,1),(43,1),(45,1),(47,1),(49,1),(51,1),(53,1),(55,1),(57,1),(59,1),(61,1),(63,1),(65,1),(67,1),(69,1),(71,1),(73,1),(75,1),(77,1),(79,1),(81,1),(83,1),(85,1),(87,1),(89,1),(91,1),(93,1),(95,1),(97,1),(99,1),(101,1),(103,1),(105,1),(107,1),(109,1),(111,1),(113,1),(115,1),(117,1),(119,1),(121,1),(123,1),(125,1),(127,1),(129,1),(131,1),(133,1),(135,1);
/*!40000 ALTER TABLE `user_auth_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-31 19:59:30
