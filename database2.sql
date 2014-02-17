CREATE DATABASE  IF NOT EXISTS `whouse` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `whouse`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: whouse
-- ------------------------------------------------------
-- Server version	5.7.3-m13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories_commodity`
--

DROP TABLE IF EXISTS `categories_commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories_commodity` (
  `CATEGORIES_id` bigint(20) NOT NULL,
  `commodityList_id` bigint(20) NOT NULL,
  UNIQUE KEY `commodityList_id` (`commodityList_id`),
  KEY `FK9A360AADAAB7D81` (`commodityList_id`),
  CONSTRAINT `FK9A360AADAAB7D81` FOREIGN KEY (`commodityList_id`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories_commodity`
--

LOCK TABLES `categories_commodity` WRITE;
/*!40000 ALTER TABLE `categories_commodity` DISABLE KEYS */;
/*!40000 ALTER TABLE `categories_commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_commodity`
--

DROP TABLE IF EXISTS `category_commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_commodity` (
  `CATEGORY_id` bigint(20) NOT NULL,
  `commodityList_id` bigint(20) NOT NULL,
  UNIQUE KEY `commodityList_id` (`commodityList_id`),
  KEY `FK9770290CDAAB7D81` (`commodityList_id`),
  CONSTRAINT `FK9770290CDAAB7D81` FOREIGN KEY (`commodityList_id`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_commodity`
--

LOCK TABLES `category_commodity` WRITE;
/*!40000 ALTER TABLE `category_commodity` DISABLE KEYS */;
/*!40000 ALTER TABLE `category_commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity`
--

DROP TABLE IF EXISTS `commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commodity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `measurementUnit` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `storage_id` bigint(20) DEFAULT NULL,
  `MEASUREMENT` int(11) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4D84270D3F04DE12` (`storage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity`
--

LOCK TABLES `commodity` WRITE;
/*!40000 ALTER TABLE `commodity` DISABLE KEYS */;
INSERT INTO `commodity` VALUES (2,'Бур Hitachi 40mm',0,'Бур Hitachi 40mm',NULL,0,NULL),(3,'Дюбель универсальный 6*40',0,'Дюбель 6*40',NULL,0,NULL),(4,'Манометричний коллектор',0,'Манометричний коллектор',NULL,0,NULL),(5,'Трубогиб пружинный 1/4 СТ-102-04',0,'Трубогиб пружинный 1/4',NULL,0,NULL),(6,'Трубогиб пружинный 3/8 СТ-102-06',0,'Трубогиб пружинный 3/8',NULL,0,NULL),(7,'Труборез CT 127 (3-16 мм)',0,'Труборез 3-16 мм',NULL,0,NULL),(8,'Вальцовка СТ-806АМ дюймовая',0,'Вальцовка дюймовая',NULL,0,NULL),(9,'Манометрический коллектор 536G R-22,12,407+3шланга (90см.) в комплекте Харьков',0,'Манометрический коллектор 536G ',NULL,0,NULL),(10,'хладагентом R22.Прикольний',2,'хладагентом R22',NULL,0,NULL),(11,'хладагентом R32.Круче',2,'хладагентом R32',NULL,0,NULL),(12,'Ізолента чорна',4,'Ізолента чорна',NULL,0,NULL),(13,'Цвяхи стальні 100мм',1,'Цвяхи і 100мм',NULL,0,NULL);
/*!40000 ALTER TABLE `commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flowitems`
--

DROP TABLE IF EXISTS `flowitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flowitems` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `commodity_id` bigint(20) DEFAULT NULL,
  `flow_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK4D3D83326C06C5F` (`commodity_id`),
  KEY `FK4D3D833225A8D972` (`flow_id`),
  CONSTRAINT `FK4D3D833225A8D972` FOREIGN KEY (`flow_id`) REFERENCES `flows` (`id`),
  CONSTRAINT `FK4D3D83326C06C5F` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flowitems`
--

LOCK TABLES `flowitems` WRITE;
/*!40000 ALTER TABLE `flowitems` DISABLE KEYS */;
/*!40000 ALTER TABLE `flowitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flows`
--

DROP TABLE IF EXISTS `flows`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flows` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK3FE2CE5B83427D5` (`user_id`),
  CONSTRAINT `FK3FE2CE5B83427D5` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flows`
--

LOCK TABLES `flows` WRITE;
/*!40000 ALTER TABLE `flows` DISABLE KEYS */;
/*!40000 ALTER TABLE `flows` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flows_flowitems`
--

DROP TABLE IF EXISTS `flows_flowitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flows_flowitems` (
  `FLOWS_id` bigint(20) NOT NULL,
  `flowItems_id` bigint(20) NOT NULL,
  UNIQUE KEY `flowItems_id` (`flowItems_id`),
  KEY `FK12499058CC53923B` (`FLOWS_id`),
  KEY `FK12499058B9953101` (`flowItems_id`),
  CONSTRAINT `FK12499058B9953101` FOREIGN KEY (`flowItems_id`) REFERENCES `flowitems` (`id`),
  CONSTRAINT `FK12499058CC53923B` FOREIGN KEY (`FLOWS_id`) REFERENCES `flows` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flows_flowitems`
--

LOCK TABLES `flows_flowitems` WRITE;
/*!40000 ALTER TABLE `flows_flowitems` DISABLE KEYS */;
/*!40000 ALTER TABLE `flows_flowitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitems`
--

DROP TABLE IF EXISTS `orderitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderitems` (
  `ORDERS_id` bigint(20) NOT NULL,
  `store_id` bigint(20) NOT NULL,
  UNIQUE KEY `store_id` (`store_id`),
  KEY `FK4A8CAD329384F17B` (`ORDERS_id`),
  KEY `FK4A8CAD3211613B92` (`store_id`),
  CONSTRAINT `FK4A8CAD3211613B92` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`),
  CONSTRAINT `FK4A8CAD329384F17B` FOREIGN KEY (`ORDERS_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitems`
--

LOCK TABLES `orderitems` WRITE;
/*!40000 ALTER TABLE `orderitems` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `completed` tinyint(1) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8B7256E5B83427D5` (`user_id`),
  CONSTRAINT `FK8B7256E5B83427D5` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage`
--

DROP TABLE IF EXISTS `storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `commodity_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKBA7BCE5B6C06C5F` (`commodity_id`),
  CONSTRAINT `FKBA7BCE5B6C06C5F` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage`
--

LOCK TABLES `storage` WRITE;
/*!40000 ALTER TABLE `storage` DISABLE KEYS */;
/*!40000 ALTER TABLE `storage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage_commodity`
--

DROP TABLE IF EXISTS `storage_commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage_commodity` (
  `STORAGE_STORAGE_ID` bigint(20) NOT NULL,
  `commodity_COMMODITY_ID` bigint(20) NOT NULL,
  UNIQUE KEY `commodity_COMMODITY_ID` (`commodity_COMMODITY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage_commodity`
--

LOCK TABLES `storage_commodity` WRITE;
/*!40000 ALTER TABLE `storage_commodity` DISABLE KEYS */;
/*!40000 ALTER TABLE `storage_commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `commodity_COMMODITY_ID` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4B900C1F4600872` (`order_id`),
  CONSTRAINT `FK4B900C1F4600872` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'order','OrderUser','order',2),(2,'mind','Sergiy Lesko','medusa',2),(3,'war','Worker','war',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-17 22:27:56
