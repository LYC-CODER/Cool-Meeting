-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: meeting
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `counter`
--

DROP TABLE IF EXISTS `counter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `counter` (
  `visitcount` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counter`
--

LOCK TABLES `counter` WRITE;
/*!40000 ALTER TABLE `counter` DISABLE KEYS */;
INSERT INTO `counter` VALUES (99),(99),(99);
/*!40000 ALTER TABLE `counter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `departmentid` int NOT NULL AUTO_INCREMENT,
  `departmentname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`departmentid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'技术部'),(2,'人事部'),(3,'财务部'),(4,'行政部'),(5,'运维部'),(9,'权益部');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employeeid` int NOT NULL AUTO_INCREMENT,
  `employeename` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `departmentid` int DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`employeeid`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'王晓华','wangxh','13671075406','wang@qq.com','2',1,'1','1'),(2,'林耀坤','linyk','13671075406','yang@qq.com','0',2,'1','1'),(3,'熊杰文','xiongjw','134555555','xiong@qq.com','-1',3,'1','1'),(4,'王敏','wangmin','1324554321','wangm@qq.com','-1',4,'1','1'),(5,'黄美玲','huangml002','1908289188','13567898765','2',4,'1','1'),(6,'王茜','wangmin002','13454332334','wang@qq.com','1',4,'1','1'),(7,'卢云冲','lyc','19336917948','2917905862@qq.com','1',1,'1','2'),(8,'关羽','gy','17988890988','123@qq.com','1',3,'1','1'),(9,'张飞','zf','19880987368','578947@qq.com','1',2,'1','1'),(10,'刘备','lb','15777891737','908798@qq.com','1',2,'1','1'),(11,'诸葛亮','zgl','11113344555','189266@qq.com','1',3,'1','1');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meeting`
--

DROP TABLE IF EXISTS `meeting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meeting` (
  `meetingid` int NOT NULL AUTO_INCREMENT,
  `meetingname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `roomid` int DEFAULT NULL,
  `reservationistid` int DEFAULT NULL,
  `numberofparticipants` int DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `reservationtime` datetime DEFAULT NULL,
  `canceledtime` datetime DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`meetingid`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meeting`
--

LOCK TABLES `meeting` WRITE;
/*!40000 ALTER TABLE `meeting` DISABLE KEYS */;
INSERT INTO `meeting` VALUES (1,'ces',5,7,12,'2015-01-12 10:00:00','2015-01-12 12:00:00','2015-01-10 23:02:39',NULL,NULL,'1'),(2,'测测',7,1,12,'2015-01-12 13:00:00','2015-01-12 15:00:00','2015-01-17 23:04:18','2015-01-11 01:06:20',NULL,'1'),(3,'我看看',6,7,12,'2015-01-13 23:06:06','2015-01-14 03:06:08','2015-01-10 23:06:33','2015-01-11 01:01:42','我看看','1'),(4,'运营会',5,2,12,'2015-01-10 23:26:11','2015-01-11 23:26:13','2015-01-10 23:16:16',NULL,'测试','0'),(5,'市场部会议',6,3,12,'2015-01-10 23:44:22','2015-01-11 23:44:24','2015-01-10 23:44:41',NULL,'市场部','0'),(6,'内部会议',10,8,12,'2015-01-10 23:55:59','2015-01-11 23:56:01','2015-01-10 23:56:20',NULL,'内部会议','0'),(7,'我的会议',9,5,12,'2015-01-12 16:33:16','2015-01-13 16:33:18','2015-01-11 16:35:11',NULL,'测试','0'),(8,'我的会议哈哈',5,6,10,'2015-01-12 16:40:31','2015-01-13 16:40:35','2015-01-11 16:40:50',NULL,'','0'),(9,'哈哈',6,8,12,'2015-01-12 16:41:45','2015-01-13 16:41:48','2015-01-11 16:42:09','2015-01-12 11:44:57','你好','1'),(10,'我的会议3',8,11,12,'2015-01-11 16:42:36','2015-01-13 16:42:38','2015-01-11 16:42:51',NULL,'测试','0'),(11,'我的会议',7,4,12,'2015-01-11 16:44:03','2015-01-11 16:44:05','2015-01-11 16:44:35',NULL,'','0'),(12,'我问问',7,8,12,'2015-01-11 16:56:57','2015-01-11 16:56:59','2015-01-11 16:57:56','2015-01-11 16:59:31','地点','1'),(13,'我的会议4',7,8,12,'2015-01-12 16:59:26','2015-01-12 16:59:31','2015-01-11 16:59:49',NULL,'我的会议','0');
/*!40000 ALTER TABLE `meeting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meetingparticipants`
--

DROP TABLE IF EXISTS `meetingparticipants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meetingparticipants` (
  `meetingid` int NOT NULL,
  `employeeid` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meetingparticipants`
--

LOCK TABLES `meetingparticipants` WRITE;
/*!40000 ALTER TABLE `meetingparticipants` DISABLE KEYS */;
INSERT INTO `meetingparticipants` VALUES (7,7),(28,23),(28,27),(28,16),(29,16),(19,13),(8,8),(30,15),(30,13),(30,8),(30,23),(27,7),(26,8),(25,8),(28,8),(31,8),(31,17),(31,23),(32,8),(32,17),(33,15),(34,8),(34,17),(35,8),(36,9),(36,7),(37,8),(37,23),(38,11),(38,16),(38,20),(39,13),(40,10),(40,2),(40,40);
/*!40000 ALTER TABLE `meetingparticipants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meetingroom`
--

DROP TABLE IF EXISTS `meetingroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meetingroom` (
  `roomid` int NOT NULL AUTO_INCREMENT,
  `roomnum` int NOT NULL,
  `roomname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `capacity` int DEFAULT NULL,
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`roomid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meetingroom`
--

LOCK TABLES `meetingroom` WRITE;
/*!40000 ALTER TABLE `meetingroom` DISABLE KEYS */;
INSERT INTO `meetingroom` VALUES (5,101,'第一次会议',15,'0','公共会议室'),(6,102,'第二会议室',5,'0','管理部门会议室'),(7,103,'第三会议室',12,'0','市场部门专用会议室'),(8,401,'第四会议室',15,'0','公共会议室'),(9,201,'第五会议室',15,'0','最大会议室'),(10,601,'第六会议室',12,'0','需要提前三天预定'),(11,301,'大型会议室',100,'1','无'),(12,317,'中型会议室',50,'1','无'),(13,317,'期末',50,'1','考试');
/*!40000 ALTER TABLE `meetingroom` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-04 13:27:22
