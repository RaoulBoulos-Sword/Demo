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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` bigint NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `availability` bit(1) DEFAULT NULL,
  `room_room_id` bigint DEFAULT NULL,
  `rotation_group_rotation_id` bigint DEFAULT NULL,
  `team_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `UK_mpps3d3r9pdvyjx3iqixi96fi` (`user_id`),
  KEY `FKb0ll63h24ly83wiy3gpil41fa` (`room_room_id`),
  KEY `FK62e01rddolf6pu0rw6d7ftk09` (`rotation_group_rotation_id`),
  KEY `FK8d7lrsr6kwirr93rx0tafnoqa` (`team_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (14,'Khaled','DIAB',_binary '',NULL,NULL,2,13),(16,'Mohammad','ITANI',_binary '',NULL,NULL,2,15),(18,'Rim','KOUBEISSI',_binary '',NULL,NULL,2,17),(20,'Edmond','ROUPHAEL',_binary '',NULL,NULL,2,19),(22,'Rabih','SADER',_binary '',NULL,NULL,2,21),(24,'Jhonny','RIZKO',_binary '',NULL,NULL,2,23),(26,'Jad','CHAHINE',_binary '',NULL,NULL,3,25),(28,'Wael','JRADY',_binary '',NULL,NULL,2,27),(30,'Malek','ITANY',_binary '',NULL,NULL,4,29),(32,'Khodr','KHALIL',_binary '',NULL,NULL,4,31),(34,'Mohamad','KHALIL',_binary '',NULL,NULL,4,33),(36,'Bechara','MAALOUF',_binary '',NULL,NULL,5,35),(38,'Frida','MAALOUF',_binary '',NULL,NULL,5,37),(40,'Ahmad','AWADA',_binary '',NULL,NULL,3,39),(42,'Abdo','BOUTANOS',_binary '',NULL,NULL,2,41),(44,'Malek','CHAHINE',_binary '',NULL,NULL,2,43),(46,'Antonio','KARAM',_binary '',NULL,NULL,2,45),(48,'Ahmad','KAWTHARANI',_binary '',NULL,NULL,4,47),(50,'Houssam','HAMMOUD',_binary '',NULL,NULL,4,49),(52,'Adel','KONTAR',_binary '',NULL,NULL,6,51),(54,'Hussein','SABRA',_binary '',NULL,NULL,10,53),(56,'Khaled','TAKI',_binary '',NULL,NULL,2,55),(58,'Rabih','YASSINE',_binary '',NULL,NULL,7,57),(60,'Roger','ABINADER',_binary '',NULL,NULL,2,59),(62,'Karim','KHALED',_binary '',NULL,NULL,2,61),(64,'Anthony','NAJOUR',_binary '',NULL,NULL,2,63),(66,'Ali','ITANI',_binary '',NULL,NULL,2,65),(68,'Rami','SAFADIEH',_binary '',NULL,NULL,8,67),(70,'Yahya','DEEB',_binary '',NULL,NULL,8,69),(72,'Mariam','ABBAS',_binary '',NULL,NULL,4,71),(74,'Mohamad','IZMERLI',_binary '',NULL,NULL,4,73),(76,'Joelle','SLEIMAN',_binary '',NULL,NULL,4,75),(78,'Saeid','DIAB',_binary '',NULL,NULL,4,77),(80,'Toufic','ELKHOURY',_binary '',NULL,NULL,6,79),(82,'Nasser','HAMMOUD',_binary '',NULL,NULL,5,81),(84,'Ralph','NADER',_binary '',NULL,NULL,9,83),(86,'Hady','HADDAD',_binary '',NULL,NULL,10,85),(88,'Ali Mortada','FNEISH',_binary '',NULL,NULL,10,87),(90,'Miled','FIKANI',_binary '',NULL,NULL,10,89),(92,'Jawdat','MERHY',_binary '',NULL,NULL,10,91),(94,'Mohamad','JARRAH',_binary '',NULL,NULL,10,93),(96,'Mostafa','SABBAHI',_binary '',NULL,NULL,10,95),(98,'Rabih','SAMHOUNE',_binary '',NULL,NULL,10,97),(100,'Georges','ABBOUD',_binary '',NULL,NULL,7,99),(102,'Hussein','BASSAM',_binary '',NULL,NULL,7,101),(104,'Zeinab','BACHIR',_binary '',NULL,NULL,7,103),(106,'Wael','ABBOUD',_binary '',NULL,NULL,7,105),(108,'Noura','ELKOBERSSY',_binary '',NULL,NULL,7,107),(110,'Mohamad','HAIDAR',_binary '',NULL,NULL,7,109),(112,'Hamze','FARROUKH',_binary '',NULL,NULL,7,111),(114,'Haytham','DOUAIHY',_binary '',NULL,NULL,7,113),(116,'Mahmoud','NAJA',_binary '',NULL,NULL,7,115),(118,'Fatima','KOUBAR',_binary '',NULL,NULL,7,117),(120,'Costantin','NEMER',_binary '',NULL,NULL,7,119),(122,'Bassam','ZOUEIN',_binary '',NULL,NULL,7,121),(124,'Toufic','TALIB',_binary '',NULL,NULL,7,123),(126,'Salim','ISMAIL',_binary '',NULL,NULL,7,125),(128,'Ramy','AZAR',_binary '',NULL,NULL,7,127),(130,'Ramzi','SAADEH',_binary '',NULL,NULL,7,129),(132,'Youssef','SIBLINI',_binary '',NULL,NULL,7,131),(134,'Mona','MOUTEIREK',_binary '',NULL,NULL,7,133),(136,'Amena','AMRO',_binary '',NULL,NULL,7,135);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
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
