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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL,
  `address` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `reset_password_token` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Lebanon','$2a$10$w7Qx9BxpYhbLfXSiX7WK/eqE7d1mOeUV3BJEFH8BZ577muNSrSlua',NULL,'admin@sword-group.com'),(13,'Lebanon','$2a$10$bsEJM.cuFWPQWqmi/EN1CeZXgYjk8StSFzoCoJwzPW1B2XCAzg.qe',NULL,'Khaled.DIAB@sword-group.com'),(15,'Lebanon','$2a$10$GFCECTREsecdzsyi.jguWugJfQIqClJguX0kc36X548pvDhFLYVxW',NULL,'Mohammad.ITANI@sword-group.com'),(17,'Lebanon','$2a$10$0ReRZ6o6gIaszIw0b53Y0eZpUvNFtagUqtfTH7SdUq4ZYRpE5JMwO',NULL,'Rim.KOUBEISSI@sword-group.com'),(19,'Lebanon','$2a$10$3ZQN3ZiSY9efvbbQBIYiqeWAdbqtxYDXecIFKASWwt9fMGal6gz22',NULL,'Edmond.ROUPHAEL@sword-group.com'),(21,'Lebanon','$2a$10$Ihsv9WZTfFmupExABv1GTeszCPvaBxS3tzJPdrX.zUbhiwpZ5mazi',NULL,'Rabih.SADER@sword-group.com'),(23,'Lebanon','$2a$10$0a4ZrUNJu32tyP79OxZuG.mGhfa/WlGgw5a7kwN8/dvFWrlHxZkC6',NULL,'Jhonny.RIZKO@sword-group.com'),(25,'Lebanon','$2a$10$B3Kb8dNSl228WjvFjFM9iuMRmjohqKDuuFnHeBvEuIMb4NPxfNZfi',NULL,'Jad.CHAHINE@sword-group.com'),(27,'Lebanon','$2a$10$K88Q.BCc3ZEGXO1s77QlX.TA9DvQ0.41sKtHBvzDBsK8CweqVX8PK',NULL,'Wael.JRADY@sword-group.com'),(29,'Lebanon','$2a$10$cEfZxJyqBNHBxA7OBceOluGGYF/HeUOex8Nvs/85K/p4j0BaJUBGe',NULL,'Malek.ITANY@sword-group.com'),(31,'Lebanon','$2a$10$IgDsqoYik0FGE7H.25fJpet4rvN3mF4VfkTAmEyq56jb8jO0rI2ki',NULL,'Khodr.KHALIL@sword-group.com'),(33,'Lebanon','$2a$10$DjN9ONaDIJzA7PpIoAofyOrQlIXlyq0Cej/2cNTQC4uiHzC4fnA02',NULL,'Mohamad.KHALIL@sword-group.com'),(35,'Lebanon','$2a$10$nocBminlGGEZKFHsg2uF3e2ANo2/uQQbCzSPhvb7IaxXBKxxyRFKu',NULL,'Bechara.MAALOUF@sword-group.com'),(37,'Lebanon','$2a$10$aY4etWF137zQk2FzrYlwCuql6VwgbXXfXUKBUJioF.jXMDrf7kjt6',NULL,'Frida.MAALOUF@sword-group.com'),(39,'Lebanon','$2a$10$iWA..oOhllJWbM8nnboFne4uvKBtGdkf1wXCObNkRLLX6My16O.xC',NULL,'Ahmad.AWADA@sword-group.com'),(41,'Lebanon','$2a$10$6S2pP0BKxrzWUK/NQ1Z2vO1A1LlPfMK48OX4YV5errsvTaJTu9kbS',NULL,'Abdo.BOUTANOS@sword-group.com'),(43,'Lebanon','$2a$10$kTbW26rQ9B6XYC03xsWxIOYGalPYvzVi5vS9wbCcjj3MLKmxsKmPq',NULL,'Malek.CHAHINE@sword-group.com'),(45,'Lebanon','$2a$10$e9JQoxR7krtEheBRJXtcJeapw.RdCltnLnrpu2lBpJbDG04IQ/woS',NULL,'Antonio.KARAM@sword-group.com'),(47,'Lebanon','$2a$10$xviivYqwnmB3tZJw5CDG1e.VXG57Hj/eKo51Tdv.ytamnN6TOCOw6',NULL,'Ahmad.KAWTHARANI@sword-group.com'),(49,'Lebanon','$2a$10$vBXpovB2FXvqd85oPrDRauYGXaRZ3PXqyfQQLnF5aokz6SldqnAmW',NULL,'Houssam.HAMMOUD@sword-group.com'),(51,'Lebanon','$2a$10$aj3CsxSfq3YaCH/MUi3Wku3UNfwmSp.BDsoSikaDmJLTG882aMUOG',NULL,'Adel.KONTAR@sword-group.com'),(53,'Lebanon','$2a$10$cU/W5/PTPC2zdcEE7uME3eG7zxo6XgpdxxQFG08L.kwbMq3b3zc2S',NULL,'Hussein.SABRA@sword-group.com'),(55,'Lebanon','$2a$10$K6eQAnasOECknEXDiUIEEOGCE.xlfPwehgl66eRM7zpDtC9WUAqSy',NULL,'Khaled.TAKI@sword-group.com'),(57,'Lebanon','$2a$10$Drd4DZm9IVeu2OGOuFqiHuh7wJipXfa6D4dHRgYokzyMxzcC7GYsm',NULL,'Rabih.YASSINE@sword-group.com'),(59,'Lebanon','$2a$10$FbcyMG6hSdhI0JJKzPCTP.L1Tk0wd8Ws.5f8SclfI7lg9.x1W.LNu',NULL,'Roger.ABINADER@sword-group.com'),(61,'Lebanon','$2a$10$qbX7QJD8lyhNHcpFYXR4eeFnaqLC4.AWxvhIVzpq2cynKk.xcLnUe',NULL,'Karim.KHALED@sword-group.com'),(63,'Lebanon','$2a$10$b7yCTxyjD9C2y7N8Onx8lOccqf6ckZ0PDL/.LyhFsQpiJji.cicdC',NULL,'Anthony.NAJOUR@sword-group.com'),(65,'Lebanon','$2a$10$iWijBYeiKcKP4r9IrBIQCeDguMxy0SJQSEdNW.WFiuuYWm7jIzdUC',NULL,'Ali.ITANI@sword-group.com'),(67,'Lebanon','$2a$10$H7Sh/5ETxqGZcUThiOelxeC9LT4QVaPBZyx5XO5HF4uPjQzixxgEe',NULL,'Rami.SAFADIEH@sword-group.com'),(69,'Lebanon','$2a$10$ORkpcuxFGtEmjR7imnOmmObIPhJ1MBYlWQWNMnk4GcFyqNNEWPFza',NULL,'Yahya.DEEB@sword-group.com'),(71,'Lebanon','$2a$10$b.4KqOJh2POHpFSSKnnHoOOzPeQ1vx42pFQDexdU08wM9wZctJXGa',NULL,'Mariam.ABBAS@sword-group.com'),(73,'Lebanon','$2a$10$C8LvQNrTPyJX91L7t.qa8OyA8e6GxSvSddxF2CvO5Zw8LmXgHgpGu',NULL,'Mohamad.IZMERLI@sword-group.com'),(75,'Lebanon','$2a$10$pBUCZrc1yHE10/FnCWRtN.Ve96WlOKEfRpQoEEseYRUKw78Fo6CWe',NULL,'Joelle.SLEIMAN@sword-group.com'),(77,'Lebanon','$2a$10$.9cEsomqJDhUb9Q8zpKneOrtktR3ejXipX9hpgQrqqVvRpZaHTxF.',NULL,'Saeid.DIAB@sword-group.com'),(79,'Lebanon','$2a$10$.ZSYsxLBkfqVHx4ILsH9FeUkGAMT3pXWJ470d/cRnILNdVaYZLbJO',NULL,'Toufic.ELKHOURY@sword-group.com'),(81,'Lebanon','$2a$10$NT.td9sgDXuNHsvtR9rOF.1.n.kBltE1zH1cwFTgJ.W3h7RY4fvs.',NULL,'Nasser.HAMMOUD@sword-group.com'),(83,'Lebanon','$2a$10$/EdBWDU7NQSnwIhgY0X75eJE/CkENocuQpXJr1tLdtmr/ZKRg2Y3e',NULL,'Ralph.NADER@sword-group.com'),(85,'Lebanon','$2a$10$AR2ZitSN6dk6u2NGgpGw0.5iG2sXJaQhqgPT5QfFjjzZ0FVE4q30.',NULL,'Hady.HADDAD@sword-group.com'),(87,'Lebanon','$2a$10$Ss3.y8ryhl857j5rcTadQ.1ruGukaTyWqyD/P00h20u9yQz2V9OkO',NULL,'Ali-Mortada.FNEISH@sword-group.com'),(89,'Lebanon','$2a$10$/Evvj4zTJ8mod34s8ZtngeoSaA/B8uzgkI8iq4nwXqTcJpA0W9lfq',NULL,'Miled.FIKANI@sword-group.com'),(91,'Lebanon','$2a$10$PxdCbQ1a4bfnLzhjAFaEnuJheV1kB/zkYqqNr199FXmLOvJfhTAC2',NULL,'Jawdat.MERHY@sword-group.com'),(93,'Lebanon','$2a$10$R6yFKrGrG.GDDolfTd7Pfu7lAq6JK2QFbfVBTqv5IRRGqIEk0nx7C',NULL,'Mohamad.JARRAH@sword-group.com'),(95,'Lebanon','$2a$10$K62qRUXkidv/WA0hNm.Tj./CXSoeUBWBogxPsXoEMW44jBN7Q17XG',NULL,'Mostafa.SABBAHI@sword-group.com'),(97,'Lebanon','$2a$10$nw1OUSHxYWXD7IVSoq1Hi.aDPGSL8i0M5dT4uaSYecutwLvGocPZu',NULL,'Rabih.SAMHOUNE@sword-group.com'),(99,'Lebanon','$2a$10$PJzsnLaYRNKyKRbuFn1m2.CUCq1/qyQS/ThoU.QZlrTdvRfIuYmlC',NULL,'Georges.ABBOUD@sword-group.com'),(101,'Lebanon','$2a$10$J7C8Q1DcUA2YDHMQVKzeMueTMw3YGVZe0pOyqgE3mIMRjpM9BIpsq',NULL,'Hussein.BASSAM@sword-group.com'),(103,'Lebanon','$2a$10$ECwu/6skWrXIFg2oo3qV1eJtVJuYkeIItPCL7cgXuShHLquWNH7FS',NULL,'Zeinab.BACHIR@sword-group.com'),(105,'Lebanon','$2a$10$eMEc80ZdCFvCMz9FMyG49eHfKD4uj5tZ.Cv4cWmGe7/aMS4c9GqMO',NULL,'Wael.ABBOUD@sword-group.com'),(107,'Lebanon','$2a$10$RaHd6v9L8b9kQ8ue5YMgP.VujjJKAdR/KdPmGteu4qcN71bCnuhRK',NULL,'Noura.ELKOBERSSY@sword-group.com'),(109,'Lebanon','$2a$10$1nfCkCjlQY.8/lGoW2gg8OZod2buqo.VZtcXidoeNTVbhd9hybhXG',NULL,'Mohamad.HAIDAR@sword-group.com'),(111,'Lebanon','$2a$10$oouZdwKXIYDl2EsP93WNdesYkuKIWxqPFt6augRqnI.2e6QAdMW.G',NULL,'Hamze.FARROUKH@sword-group.com'),(113,'Lebanon','$2a$10$h1/2GQO6s1Um/Z0wXxcxkOu5FDgr9rvuvZCNqum.5t8cZhy7TWDee',NULL,'Haytham.DOUAIHY@sword-group.com'),(115,'Lebanon','$2a$10$xltw1/JYB2oKo7I7Ox0/nOvs2DH8AZjV6LAxBLrVG.SVVpsVBxT3K',NULL,'Mahmoud.NAJA@sword-group.com'),(117,'Lebanon','$2a$10$GJn7bebfP5QAx2V23GuiEORN08ubUUa0nOhzKALsqFqu93y/vmFJ6',NULL,'Fatima.KOUBAR@sword-group.com'),(119,'Lebanon','$2a$10$MMeJv/vkpZVSzHP910vW5uhwEIzAdZgIVw3arlFjxjoPxA0malNam',NULL,'Costantin.NEMER@sword-group.com'),(121,'Lebanon','$2a$10$YKVE3C8WN4.CNCxF8sasQes7O8oLPXfFgDgyaopNBmToXQrOeAxSW',NULL,'Bassam.ZOUEIN@sword-group.com'),(123,'Lebanon','$2a$10$Tx7s7b163UnUUfPSU3aYIOrNCrEgO6tKuvr8u7p/XQ.uILekiXCqK',NULL,'Toufic.TALIB@sword-group.com'),(125,'Lebanon','$2a$10$y2XQ3rhM3hIuxVjWAxdjue4.IVgPzsemI6ywwhbGoOVk3Otuaja8a',NULL,'Salim.ISMAIL@sword-group.com'),(127,'Lebanon','$2a$10$/HxeW4P50n.tQqV8H/QVNeCV5CMDAx8Q4p8Hm9XXujAmmF7V6K/y6',NULL,'Ramy.AZAR@sword-group.com'),(129,'Lebanon','$2a$10$w32cee/cuayuE0/dSz/ID.RP5V3a.4pUweP4sKIeAwpTuq9eJq0K.',NULL,'Ramzi.SAADEH@sword-group.com'),(131,'Lebanon','$2a$10$ESvVRsUF1zJJjspUSD0L1uVESlyUm6xrtsLq.0XBvYGpytUboBSlO',NULL,'Youssef.SIBLINI@sword-group.com'),(133,'Lebanon','$2a$10$UPlV02ABTzwdX6VEt7AoQeGWZzPk7ToopqR1qGFc5wjoWKaTqMgRC',NULL,'Mona.MOUTEIREK@sword-group.com'),(135,'Lebanon','$2a$10$tykZxGzePaZfU.nlT8N2SOHt1bCiWVReGu7/ujmNvJlFVQ6aOUOn.',NULL,'Amena.AMRO@sword-group.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-31 19:59:31
