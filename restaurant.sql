-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: restaurant
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `foodinfo`
--

DROP TABLE IF EXISTS `foodinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foodinfo` (
  `food_id` int(11) NOT NULL AUTO_INCREMENT,
  `restaurant_id` int(11) DEFAULT NULL,
  `food_name` varchar(32) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`food_id`),
  KEY `foodInfo_restaurantinfo__fk` (`restaurant_id`),
  CONSTRAINT `foodInfo_restaurantinfo__fk` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurantinfo` (`restaurant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foodinfo`
--

LOCK TABLES `foodinfo` WRITE;
/*!40000 ALTER TABLE `foodinfo` DISABLE KEYS */;
INSERT INTO `foodinfo` VALUES (1,1,'新疆大盘鸡',68),(2,1,'爆汁牛肉丸',32),(3,1,'羊肉串',2);
/*!40000 ALTER TABLE `foodinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderinfo`
--

DROP TABLE IF EXISTS `orderinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderinfo` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `food_id` int(11) DEFAULT NULL,
  `food_num` int(11) DEFAULT NULL,
  `taste` varchar(16) DEFAULT NULL,
  `table_id` int(11) NOT NULL,
  `order_status` varchar(16) DEFAULT 'ready' COMMENT '''start'',下单成功\n''ready''，准备制作\n''cancel''，用户取消\n''done'',制作完毕\n''end''，完成订单',
  PRIMARY KEY (`order_id`),
  KEY `orderinfo_foodinfo__fk` (`food_id`),
  KEY `orderinfo_tableinfo__fk` (`table_id`),
  CONSTRAINT `orderinfo_foodinfo__fk` FOREIGN KEY (`food_id`) REFERENCES `foodinfo` (`food_id`),
  CONSTRAINT `orderinfo_tableinfo__fk` FOREIGN KEY (`table_id`) REFERENCES `tableinfo` (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderinfo`
--

LOCK TABLES `orderinfo` WRITE;
/*!40000 ALTER TABLE `orderinfo` DISABLE KEYS */;
INSERT INTO `orderinfo` VALUES (1,1,2,'微辣',1,'end'),(2,2,2,'不辣',1,'end'),(3,1,2,'微辣',1,'end'),(4,2,2,'不辣',1,'end'),(5,1,6,'微辣',1,'end'),(6,2,2,'不辣',1,'end'),(7,1,6,'微辣',1,'end'),(8,2,2,'不辣',1,'end');
/*!40000 ALTER TABLE `orderinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurantinfo`
--

DROP TABLE IF EXISTS `restaurantinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurantinfo` (
  `restaurant_id` int(11) NOT NULL AUTO_INCREMENT,
  `restaurant_name` varchar(52) NOT NULL,
  `status` varchar(32) DEFAULT 'active',
  PRIMARY KEY (`restaurant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurantinfo`
--

LOCK TABLES `restaurantinfo` WRITE;
/*!40000 ALTER TABLE `restaurantinfo` DISABLE KEYS */;
INSERT INTO `restaurantinfo` VALUES (1,'新疆大盘鸡','active'),(2,'兰州拉面','active'),(3,'农家小炒菜','active');
/*!40000 ALTER TABLE `restaurantinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tableinfo`
--

DROP TABLE IF EXISTS `tableinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tableinfo` (
  `table_id` int(11) NOT NULL AUTO_INCREMENT,
  `restaurant_id` int(11) DEFAULT NULL,
  `capacity` int(11) DEFAULT '2',
  `status` varchar(32) DEFAULT 'wait',
  PRIMARY KEY (`table_id`),
  KEY `table_restaurantinfo__fk` (`restaurant_id`),
  CONSTRAINT `table_restaurantinfo__fk` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurantinfo` (`restaurant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tableinfo`
--

LOCK TABLES `tableinfo` WRITE;
/*!40000 ALTER TABLE `tableinfo` DISABLE KEYS */;
INSERT INTO `tableinfo` VALUES (1,1,4,'wait'),(2,1,8,'wait'),(3,2,6,'wait');
/*!40000 ALTER TABLE `tableinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-31 14:09:13
