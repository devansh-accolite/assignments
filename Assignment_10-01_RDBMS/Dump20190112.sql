-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: taxi_management
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `customer_address` varchar(255) DEFAULT NULL,
  `customer_phno` bigint(20) NOT NULL,
  `customer_location` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `customer_location` (`customer_location`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`customer_location`) REFERENCES `location` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Customer 1','2',7345678976,3),(2,'Customer 2','6',8879213482,1),(3,'Customer 3','7',8894274928,7),(4,'Customer 4','3',9094827163,4),(5,'Customer 5','8',7000234039,8);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `driver` (
  `driver_id` int(11) NOT NULL,
  `driver_name` varchar(255) NOT NULL,
  `driver_address` varchar(255) DEFAULT NULL,
  `driver_phno` bigint(20) NOT NULL,
  `driver_rating` decimal(2,0) DEFAULT NULL,
  `driver_location` int(11) NOT NULL,
  `taxi_no` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`driver_id`),
  KEY `driver_location` (`driver_location`),
  KEY `taxi_no` (`taxi_no`),
  CONSTRAINT `driver_ibfk_1` FOREIGN KEY (`driver_location`) REFERENCES `location` (`location_id`),
  CONSTRAINT `driver_ibfk_2` FOREIGN KEY (`taxi_no`) REFERENCES `taxi` (`taxi_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (1,'Driver 1','6',9273874839,8,4,'KA12AB7868'),(2,'Driver 2','2',8345675442,4,8,'KA15AA6232'),(3,'Driver 3','3',9645467678,9,1,'KA22GS4523'),(4,'Driver 4','6',9544567876,2,1,'KA62EG5621'),(5,'Driver 5','1',7345678765,7,2,'KA15VF6712');
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `location` (
  `location_id` int(11) NOT NULL,
  `street_name` varchar(255) DEFAULT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Street #1','Bangalore'),(2,'Street #2','Bangalore'),(3,'Street #3','Mysore'),(4,'Street #4','Mysore'),(5,'Street #5','Bangalore'),(6,'Street #6','Hubli'),(7,'Street #7','Mangalore'),(8,'Street #8','Bangalore'),(9,'Street #9','Mysore'),(10,'Street #10','Bangalore');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `order_date` datetime NOT NULL,
  `order_amount` int(11) NOT NULL,
  `order_start_loc` int(11) NOT NULL,
  `order_end_loc` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `customer_id` (`customer_id`),
  KEY `driver_id` (`driver_id`),
  KEY `order_start_loc` (`order_start_loc`),
  KEY `order_end_loc` (`order_end_loc`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`driver_id`),
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`order_start_loc`) REFERENCES `location` (`location_id`),
  CONSTRAINT `orders_ibfk_4` FOREIGN KEY (`order_end_loc`) REFERENCES `location` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,5,'2019-01-02 12:50:57',150,3,8),(2,4,1,'2018-12-27 09:00:34',285,5,3),(3,5,2,'2018-11-12 06:47:00',670,8,9),(4,5,3,'2019-01-10 14:12:20',1280,8,1),(5,2,3,'2018-12-10 19:03:42',365,1,2);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `payment_status` varchar(10) NOT NULL,
  `payment_type` varchar(10) DEFAULT NULL,
  `payment_date` datetime NOT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `customer_id` (`customer_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,5,3,'SUCCESS','Cash','2018-11-12 12:48:32'),(2,2,5,'FAILED','Credit','2018-12-10 20:50:30'),(3,4,2,'SUCCESS','Credit','2018-12-27 12:03:41'),(4,1,1,'SUCCESS','Cash','2019-01-02 15:12:01'),(5,5,4,'FAILED','Cash','2019-01-10 22:44:14');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxi`
--

DROP TABLE IF EXISTS `taxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `taxi` (
  `taxi_no` varchar(10) NOT NULL,
  `taxi_model` varchar(255) DEFAULT NULL,
  `taxi_type` varchar(255) NOT NULL,
  PRIMARY KEY (`taxi_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxi`
--

LOCK TABLES `taxi` WRITE;
/*!40000 ALTER TABLE `taxi` DISABLE KEYS */;
INSERT INTO `taxi` VALUES ('KA12AB7868','Model #1','Sedan'),('KA15AA6232','Model #4','XUV'),('KA15VF6712','Model #5','XUV'),('KA22GS4523','Model #3','Hatchback'),('KA62EG5621','Model #1','Sedan');
/*!40000 ALTER TABLE `taxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'taxi_management'
--
/*!50003 DROP PROCEDURE IF EXISTS `getTotalAmountInYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getTotalAmountInYear`(
	in yearNo int,
    out totalAmt int
)
begin
	set @yn = concat(yearNo, "%");
	select sum(order_amount) from orders o, payment p where order_date like @yn and payment_status = "SUCCESS" and o.order_id = p.order_id;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-12 15:15:56
