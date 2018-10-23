CREATE DATABASE  IF NOT EXISTS `pl_center` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pl_center`;

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
-- Table structure for table `auth`
--

DROP TABLE IF EXISTS `auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth` (
  `user_code` int(11) unsigned NOT NULL,
  `auth` int(11) unsigned NOT NULL,
  UNIQUE KEY `user_code` (`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth`
--

LOCK TABLES `auth` WRITE;
/*!40000 ALTER TABLE `auth` DISABLE KEYS */;
INSERT INTO `auth` VALUES (1,3),(2,2),(3,2),(4,1),(5,1),(6,0),(7,0),(8,0),(9,0),(10,0),(11,0),(12,0),(13,0),(14,0),(15,0),(16,0),(17,0),(18,0),(19,0),(20,0),(21,0),(22,0),(23,0),(24,0),(25,0),(26,0),(27,0),(28,0),(29,0),(30,0),(31,0),(32,0),(33,0),(34,0),(35,0),(36,0),(37,0),(38,0),(39,0),(40,0),(41,0),(42,0),(43,0),(44,0),(45,0),(46,0),(47,0),(48,0),(49,0),(50,0),(51,0),(52,0),(53,0),(54,0),(55,0),(56,0),(57,0),(58,0),(59,0),(60,0),(61,0),(62,0),(63,0),(64,0),(65,0),(66,0),(67,0),(68,0),(69,0),(70,0),(71,0),(72,0),(73,0),(74,0),(75,0),(76,0),(77,0),(78,0),(79,0),(80,0),(81,0),(82,0),(83,0),(84,0),(85,0),(86,0),(87,0),(88,0),(89,0),(90,0),(91,0),(92,0),(93,0),(94,0),(95,0),(96,0),(97,0),(98,0),(99,0),(100,0),(101,0),(102,0),(103,0),(104,0),(105,0),(106,0),(107,0),(108,0),(109,0),(110,0),(111,0),(112,0),(113,0),(114,0),(115,0),(116,0),(117,0),(118,0),(119,0),(120,0),(121,0),(122,0);
/*!40000 ALTER TABLE `auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `year` int(11) NOT NULL,
  `semester` int(11) NOT NULL,
  `class_no` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `year` (`year`),
  KEY `semester` (`semester`),
  KEY `class_no` (`class_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,2011,1,1),(2,2012,2,2),(3,2013,1,3);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_std`
--

DROP TABLE IF EXISTS `class_std`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_std` (
  `class_id` int(11) unsigned NOT NULL,
  `user_code` int(11) unsigned NOT NULL,
  UNIQUE KEY `class_id` (`class_id`,`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_std`
--

LOCK TABLES `class_std` WRITE;
/*!40000 ALTER TABLE `class_std` DISABLE KEYS */;
INSERT INTO `class_std` VALUES (1,6),(1,7),(2,6),(3,7);
/*!40000 ALTER TABLE `class_std` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `col_dept`
--

DROP TABLE IF EXISTS `col_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `col_dept` (
  `col_id` int(11) unsigned NOT NULL,
  `dept_id` int(11) unsigned NOT NULL,
  UNIQUE KEY `col_id` (`col_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `col_dept`
--

LOCK TABLES `col_dept` WRITE;
/*!40000 ALTER TABLE `col_dept` DISABLE KEYS */;
INSERT INTO `col_dept` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(2,8),(2,9),(2,10),(2,11),(2,12),(2,13),(2,14),(2,15),(2,16),(2,17),(2,18),(3,19),(3,20),(3,21),(3,22),(3,23),(3,24),(4,25),(4,26),(4,27),(4,28),(4,29),(4,30),(4,31),(4,32),(5,33);
/*!40000 ALTER TABLE `col_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `college`
--

DROP TABLE IF EXISTS `college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `college` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `college` varchar(11) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college`
--

LOCK TABLES `college` WRITE;
/*!40000 ALTER TABLE `college` DISABLE KEYS */;
INSERT INTO `college` VALUES (1,'공공정책대학'),(2,'과학기술대학'),(3,'글로벌비즈니스대학'),(4,'문화스포츠대학'),(5,'약학대학');
/*!40000 ALTER TABLE `college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `counsel`
--

DROP TABLE IF EXISTS `counsel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `counsel` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `counselor_user_code` int(11) unsigned NOT NULL,
  `class_id` int(11) unsigned NOT NULL,
  `user_code` int(11) unsigned NOT NULL,
  `counsel_datetime` datetime NOT NULL,
  `counsel_contents` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `class_id` (`class_id`),
  KEY `user_code` (`user_code`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counsel`
--

LOCK TABLES `counsel` WRITE;
/*!40000 ALTER TABLE `counsel` DISABLE KEYS */;
INSERT INTO `counsel` VALUES (1,4,1,6,'2017-11-01 00:00:00','printf'),(2,5,2,7,'2017-11-02 00:00:00','scanf'),(3,4,3,6,'2017-11-03 00:00:00','include'),(4,4,1,6,'2017-11-01 00:00:00','Paging 1'),(5,4,1,6,'2017-11-01 00:00:00','Paging 2'),(6,4,1,6,'2017-11-01 00:00:00','Paging 3'),(7,4,1,6,'2017-11-01 00:00:00','Paging 4'),(8,4,1,6,'2017-11-01 00:00:00','Paging 5'),(9,4,1,6,'2017-11-01 00:00:00','Paging 6'),(10,4,1,6,'2017-11-01 00:00:00','Paging 7'),(11,4,1,6,'2017-11-01 00:00:00','Paging 8'),(12,4,1,6,'2017-11-01 00:00:00','Paging 9'),(13,4,1,6,'2017-11-01 00:00:00','Paging 10'),(14,4,1,6,'2017-11-01 00:00:00','Paging 11'),(15,4,1,6,'2017-11-01 00:00:00','Paging 12'),(16,4,1,6,'2017-11-01 00:00:00','Paging 13'),(17,4,1,6,'2017-11-01 00:00:00','Paging 14'),(18,4,1,6,'2017-11-01 00:00:00','Paging 15'),(19,4,1,6,'2017-11-01 00:00:00','Paging 16'),(20,4,1,6,'2017-11-01 00:00:00','Paging 17'),(21,4,1,6,'2017-11-01 00:00:00','Paging 18'),(22,4,1,6,'2017-11-01 00:00:00','Paging 19'),(23,4,1,6,'2017-11-01 00:00:00','Paging 20'),(24,4,1,6,'2017-11-01 00:00:00','Paging 21'),(25,4,1,6,'2017-11-01 00:00:00','Paging 22'),(26,4,1,6,'2017-11-01 00:00:00','Paging 23'),(27,4,1,6,'2017-11-01 00:00:00','Paging 24'),(28,4,1,6,'2017-11-01 00:00:00','Paging 25'),(29,4,1,6,'2017-11-01 00:00:00','Paging 26'),(30,4,1,6,'2017-11-01 00:00:00','Paging 27'),(31,4,1,6,'2017-11-01 00:00:00','Paging 28'),(32,4,1,6,'2017-11-01 00:00:00','Paging 29'),(33,4,1,6,'2017-11-01 00:00:00','Paging 30'),(34,4,1,6,'2017-11-01 00:00:00','Paging 31'),(35,4,1,6,'2017-11-01 00:00:00','Paging 32'),(36,4,1,6,'2017-11-01 00:00:00','Paging 33'),(37,4,1,6,'2017-11-01 00:00:00','Paging 34'),(38,4,1,6,'2017-11-01 00:00:00','Paging 35'),(39,4,1,6,'2017-11-01 00:00:00','Paging 36'),(40,4,1,6,'2017-11-01 00:00:00','Paging 37'),(41,4,1,6,'2017-11-01 00:00:00','Paging 38'),(42,4,1,6,'2017-11-01 00:00:00','Paging 39'),(43,4,1,6,'2017-11-01 00:00:00','Paging 40'),(44,4,1,6,'2017-11-01 00:00:00','Paging 41'),(45,4,1,6,'2017-11-01 00:00:00','Paging 42'),(46,4,1,6,'2017-11-01 00:00:00','Paging 43'),(47,4,1,6,'2017-11-01 00:00:00','Paging 44'),(48,4,1,6,'2017-11-01 00:00:00','Paging 45'),(49,4,1,6,'2017-11-01 00:00:00','Paging 46'),(50,4,1,6,'2017-11-01 00:00:00','Paging 47'),(51,4,1,6,'2017-11-01 00:00:00','Paging 48'),(52,4,1,6,'2017-11-01 00:00:00','Paging 49'),(53,4,1,6,'2017-11-01 00:00:00','Paging 50'),(54,4,1,6,'2017-11-01 00:00:00','Paging 51'),(55,4,1,6,'2017-11-01 00:00:00','Paging 52'),(56,4,1,6,'2017-11-01 00:00:00','Paging 53'),(57,4,1,6,'2017-11-01 00:00:00','Paging 54'),(58,4,1,6,'2017-11-01 00:00:00','Paging 55'),(59,4,1,6,'2017-11-01 00:00:00','Paging 56'),(60,4,1,6,'2017-11-01 00:00:00','Paging 57'),(61,4,1,6,'2017-11-01 00:00:00','Paging 58'),(62,4,1,6,'2017-11-01 00:00:00','Paging 59'),(63,4,1,6,'2017-11-01 00:00:00','Paging 60'),(64,4,1,6,'2017-11-01 00:00:00','Paging 61'),(65,4,1,6,'2017-11-01 00:00:00','Paging 62'),(66,4,1,6,'2017-11-01 00:00:00','Paging 63'),(67,4,1,6,'2017-11-01 00:00:00','Paging 64'),(68,4,1,6,'2017-11-01 00:00:00','Paging 65'),(69,4,1,6,'2017-11-01 00:00:00','Paging 66'),(70,4,1,6,'2017-11-01 00:00:00','Paging 67'),(71,4,1,6,'2017-11-01 00:00:00','Paging 68'),(72,4,1,6,'2017-11-01 00:00:00','Paging 69'),(73,4,1,6,'2017-11-01 00:00:00','Paging 70'),(74,4,1,6,'2017-11-01 00:00:00','Paging 71'),(75,4,1,6,'2017-11-01 00:00:00','Paging 72'),(76,4,1,6,'2017-11-01 00:00:00','Paging 73'),(77,4,1,6,'2017-11-01 00:00:00','Paging 74'),(78,4,1,6,'2017-11-01 00:00:00','Paging 75'),(79,4,1,6,'2017-11-01 00:00:00','Paging 76'),(80,4,1,6,'2017-11-01 00:00:00','Paging 77'),(81,4,1,6,'2017-11-01 00:00:00','Paging 78'),(82,4,1,6,'2017-11-01 00:00:00','Paging 79'),(83,4,1,6,'2017-11-01 00:00:00','Paging 80'),(84,4,1,6,'2017-11-01 00:00:00','Paging 81'),(85,4,1,6,'2017-11-01 00:00:00','Paging 82'),(86,4,1,6,'2017-11-01 00:00:00','Paging 83'),(87,4,1,6,'2017-11-01 00:00:00','Paging 84'),(88,4,1,6,'2017-11-01 00:00:00','Paging 85'),(89,4,1,6,'2017-11-01 00:00:00','Paging 86'),(90,4,1,6,'2017-11-01 00:00:00','Paging 87'),(91,4,1,6,'2017-11-01 00:00:00','Paging 88'),(92,4,1,6,'2017-11-01 00:00:00','Paging 89'),(93,4,1,6,'2017-11-01 00:00:00','Paging 90'),(94,4,1,6,'2017-11-01 00:00:00','Paging 91'),(95,4,1,6,'2017-11-01 00:00:00','Paging 92'),(96,4,1,6,'2017-11-01 00:00:00','Paging 93'),(97,4,1,6,'2017-11-01 00:00:00','Paging 94'),(98,4,1,6,'2017-11-01 00:00:00','Paging 95'),(99,4,1,6,'2017-11-01 00:00:00','Paging 96'),(100,4,1,6,'2017-11-01 00:00:00','Paging 97'),(101,4,1,6,'2017-11-01 00:00:00','Paging 98'),(102,4,1,6,'2017-11-01 00:00:00','Paging 99'),(103,4,1,6,'2017-11-01 00:00:00','Paging 100'),(104,4,1,6,'2017-11-01 00:00:00','Paging 101'),(105,4,1,6,'2017-11-01 00:00:00','Paging 102'),(106,4,1,6,'2017-11-01 00:00:00','Paging 103'),(107,4,1,6,'2017-11-01 00:00:00','Paging 104'),(108,4,1,6,'2017-11-01 00:00:00','Paging 105'),(109,4,1,6,'2017-11-01 00:00:00','Paging 106'),(110,4,1,6,'2017-11-01 00:00:00','Paging 107'),(111,4,1,6,'2017-11-01 00:00:00','Paging 108'),(112,4,1,6,'2017-11-01 00:00:00','Paging 109'),(113,4,1,6,'2017-11-01 00:00:00','Paging 110'),(114,4,1,6,'2017-11-01 00:00:00','Paging 111'),(115,4,1,6,'2017-11-01 00:00:00','Paging 112'),(116,4,1,6,'2017-11-01 00:00:00','Paging 113'),(117,4,1,6,'2017-11-01 00:00:00','Paging 114'),(118,4,1,6,'2017-11-01 00:00:00','Paging 115');
/*!40000 ALTER TABLE `counsel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dept` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `dept` varchar(24) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` VALUES (1,'경제정책학전공'),(2,'공공사회학전공'),(3,'국가통계전공'),(4,'빅데이터전공'),(5,'사회복지융합전공'),(6,'정부행정학부'),(7,'통일외교안보전공'),(8,'데이터계산과학전공'),(9,'디스플레이융합전공'),(10,'반도체물리전공'),(11,'사이버보안전공'),(12,'생명정보공학과'),(13,'식품생명공학과'),(14,'신소재화학과'),(15,'전자/기계융합공학과'),(16,'전자및정보공학과'),(17,'컴퓨터융합소프트웨어학과'),(18,'환경시스템공학과'),(19,'글로벌경영전공'),(20,'독일학전공'),(21,'디지털경영전공'),(22,'영미학전공'),(23,'중국학전공'),(24,'한국학전공'),(25,'국제스포츠학부'),(26,'고고미술사학전공'),(27,'디지털매체문화융합전공'),(28,'문화ICT융합전공'),(29,'문화콘텐츠전공'),(30,'미디어문예창작학전공'),(31,'스포츠과학전공'),(32,'스포츠비즈니스전공'),(33,'약학대학');
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `contents` text NOT NULL,
  `writer` int(11) unsigned NOT NULL,
  `write_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `views` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (1,'Paging 1','Paging 1',1,'2017-11-01 00:00:00',159),(2,'Paging 2','Paging 2',1,'2017-11-01 00:00:00',0),(3,'Paging 3','Paging 3',1,'2017-11-01 00:00:00',0),(4,'Paging 4','Paging 4',1,'2017-11-01 00:00:00',0),(5,'Paging 5','Paging 5',1,'2017-11-01 00:00:00',0),(6,'Paging 6','Paging 6',1,'2017-11-01 00:00:00',0),(7,'Paging 7','Paging 7',1,'2017-11-01 00:00:00',0),(8,'Paging 8','Paging 8',1,'2017-11-01 00:00:00',0),(9,'Paging 9','Paging 9',1,'2017-11-01 00:00:00',0),(10,'Paging 10','Paging 10',1,'2017-11-01 00:00:00',0),(11,'Paging 11','Paging 11',1,'2017-11-01 00:00:00',0),(12,'Paging 12','Paging 12',1,'2017-11-01 00:00:00',0),(13,'Paging 13','Paging 13',1,'2017-11-01 00:00:00',0),(14,'Paging 14','Paging 14',1,'2017-11-01 00:00:00',0),(15,'Paging 15','Paging 15',1,'2017-11-01 00:00:00',0),(16,'Paging 16','Paging 16',1,'2017-11-01 00:00:00',0),(17,'Paging 17','Paging 17',1,'2017-11-01 00:00:00',0),(18,'Paging 18','Paging 18',1,'2017-11-01 00:00:00',0),(19,'Paging 19','Paging 19',1,'2017-11-01 00:00:00',0),(20,'Paging 20','Paging 20',1,'2017-11-01 00:00:00',0),(21,'Paging 21','Paging 21',1,'2017-11-01 00:00:00',0),(22,'Paging 22','Paging 22',1,'2017-11-01 00:00:00',0),(23,'Paging 23','Paging 23',1,'2017-11-01 00:00:00',0),(24,'Paging 24','Paging 24',1,'2017-11-01 00:00:00',0),(25,'Paging 25','Paging 25',1,'2017-11-01 00:00:00',0),(26,'Paging 26','Paging 26',1,'2017-11-01 00:00:00',0),(27,'Paging 27','Paging 27',1,'2017-11-01 00:00:00',0),(28,'Paging 28','Paging 28',1,'2017-11-01 00:00:00',0),(29,'Paging 29','Paging 29',1,'2017-11-01 00:00:00',0),(30,'Paging 30','Paging 30',1,'2017-11-01 00:00:00',0),(31,'Paging 31','Paging 31',1,'2017-11-01 00:00:00',0),(32,'Paging 32','Paging 32',1,'2017-11-01 00:00:00',0),(33,'Paging 33','Paging 33',1,'2017-11-01 00:00:00',0),(34,'Paging 34','Paging 34',1,'2017-11-01 00:00:00',0),(35,'Paging 35','Paging 35',1,'2017-11-01 00:00:00',0),(36,'Paging 36','Paging 36',1,'2017-11-01 00:00:00',0),(37,'Paging 37','Paging 37',1,'2017-11-01 00:00:00',0),(38,'Paging 38','Paging 38',1,'2017-11-01 00:00:00',0),(39,'Paging 39','Paging 39',1,'2017-11-01 00:00:00',0),(40,'Paging 40','Paging 40',1,'2017-11-01 00:00:00',0),(41,'Paging 41','Paging 41',1,'2017-11-01 00:00:00',0),(42,'Paging 42','Paging 42',1,'2017-11-01 00:00:00',0),(43,'Paging 43','Paging 43',1,'2017-11-01 00:00:00',0),(44,'Paging 44','Paging 44',1,'2017-11-01 00:00:00',0),(45,'Paging 45','Paging 45',1,'2017-11-01 00:00:00',0),(46,'Paging 46','Paging 46',1,'2017-11-01 00:00:00',0),(47,'Paging 47','Paging 47',1,'2017-11-01 00:00:00',0),(48,'Paging 48','Paging 48',1,'2017-11-01 00:00:00',0),(49,'Paging 49','Paging 49',1,'2017-11-01 00:00:00',0),(50,'Paging 50','Paging 50',1,'2017-11-01 00:00:00',0),(51,'Paging 51','Paging 51',1,'2017-11-01 00:00:00',0),(52,'Paging 52','Paging 52',1,'2017-11-01 00:00:00',0),(53,'Paging 53','Paging 53',1,'2017-11-01 00:00:00',0),(54,'Paging 54','Paging 54',1,'2017-11-01 00:00:00',0),(55,'Paging 55','Paging 55',1,'2017-11-01 00:00:00',0),(56,'Paging 56','Paging 56',1,'2017-11-01 00:00:00',0),(57,'Paging 57','Paging 57',1,'2017-11-01 00:00:00',0),(58,'Paging 58','Paging 58',1,'2017-11-01 00:00:00',0),(59,'Paging 59','Paging 59',1,'2017-11-01 00:00:00',0),(60,'Paging 60','Paging 60',1,'2017-11-01 00:00:00',0),(61,'Paging 61','Paging 61',1,'2017-11-01 00:00:00',0),(62,'Paging 62','Paging 62',1,'2017-11-01 00:00:00',0),(63,'Paging 63','Paging 63',1,'2017-11-01 00:00:00',0),(64,'Paging 64','Paging 64',1,'2017-11-01 00:00:00',0),(65,'Paging 65','Paging 65',1,'2017-11-01 00:00:00',0),(66,'Paging 66','Paging 66',1,'2017-11-01 00:00:00',0),(67,'Paging 67','Paging 67',1,'2017-11-01 00:00:00',0),(68,'Paging 68','Paging 68',1,'2017-11-01 00:00:00',0),(69,'Paging 69','Paging 69',1,'2017-11-01 00:00:00',0),(70,'Paging 70','Paging 70',1,'2017-11-01 00:00:00',0),(71,'Paging 71','Paging 71',1,'2017-11-01 00:00:00',0),(72,'Paging 72','Paging 72',1,'2017-11-01 00:00:00',0),(73,'Paging 73','Paging 73',1,'2017-11-01 00:00:00',0),(74,'Paging 74','Paging 74',1,'2017-11-01 00:00:00',0),(75,'Paging 75','Paging 75',1,'2017-11-01 00:00:00',0),(76,'Paging 76','Paging 76',1,'2017-11-01 00:00:00',0),(77,'Paging 77','Paging 77',1,'2017-11-01 00:00:00',0),(78,'Paging 78','Paging 78',1,'2017-11-01 00:00:00',0),(79,'Paging 79','Paging 79',1,'2017-11-01 00:00:00',0),(80,'Paging 80','Paging 80',1,'2017-11-01 00:00:00',0),(81,'Paging 81','Paging 81',1,'2017-11-01 00:00:00',0),(82,'Paging 82','Paging 82',1,'2017-11-01 00:00:00',0),(83,'Paging 83','Paging 83',1,'2017-11-01 00:00:00',0),(84,'Paging 84','Paging 84',1,'2017-11-01 00:00:00',0),(85,'Paging 85','Paging 85',1,'2017-11-01 00:00:00',0),(86,'Paging 86','Paging 86',1,'2017-11-01 00:00:00',0),(87,'Paging 87','Paging 87',1,'2017-11-01 00:00:00',0),(88,'Paging 88','Paging 88',1,'2017-11-01 00:00:00',0),(89,'Paging 89','Paging 89',1,'2017-11-01 00:00:00',0),(90,'Paging 90','Paging 90',1,'2017-11-01 00:00:00',0),(91,'Paging 91','Paging 91',1,'2017-11-01 00:00:00',0),(92,'Paging 92','Paging 92',1,'2017-11-01 00:00:00',0),(93,'Paging 93','Paging 93',1,'2017-11-01 00:00:00',0),(94,'Paging 94','Paging 94',1,'2017-11-01 00:00:00',0),(95,'Paging 95','Paging 95',1,'2017-11-01 00:00:00',0),(96,'Paging 96','Paging 96',1,'2017-11-01 00:00:00',0),(97,'Paging 97','Paging 97',1,'2017-11-01 00:00:00',0),(98,'Paging 98','Paging 98',1,'2017-11-01 00:00:00',0),(99,'Paging 99','Paging 99',1,'2017-11-01 00:00:00',0),(100,'Paging 100','Paging 100',1,'2017-11-01 00:00:00',0),(101,'Paging 101','Paging 101',1,'2017-11-01 00:00:00',0),(102,'Paging 102','Paging 102',1,'2017-11-01 00:00:00',0),(103,'Paging 103','Paging 103',1,'2017-11-01 00:00:00',0),(104,'Paging 104','Paging 104',1,'2017-11-01 00:00:00',0),(105,'Paging 105','Paging 105',1,'2017-11-01 00:00:00',0),(106,'Paging 106','Paging 106',1,'2017-11-01 00:00:00',0),(107,'Paging 107','Paging 107',1,'2017-11-01 00:00:00',0),(108,'Paging 108','Paging 108',1,'2017-11-01 00:00:00',0),(109,'Paging 109','Paging 109',1,'2017-11-01 00:00:00',0),(110,'Paging 110','Paging 110',1,'2017-11-01 00:00:00',0),(111,'Paging 111','Paging 111',1,'2017-11-01 00:00:00',0),(112,'Paging 112','Paging 112',1,'2017-11-01 00:00:00',0),(113,'Paging 113','Paging 113',1,'2017-11-01 00:00:00',0),(114,'Paging 114','Paging 114',1,'2017-11-01 00:00:00',0),(115,'Paging 115','Paging 115',1,'2017-11-01 00:00:00',0);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice_comment`
--

DROP TABLE IF EXISTS `notice_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice_comment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `notice_id` int(10) unsigned NOT NULL,
  `parent_comment_id` int(10) unsigned NOT NULL DEFAULT '0',
  `contents` text NOT NULL,
  `writer` int(10) unsigned NOT NULL,
  `write_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `notice_id` (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice_comment`
--

LOCK TABLES `notice_comment` WRITE;
/*!40000 ALTER TABLE `notice_comment` DISABLE KEYS */;
INSERT INTO `notice_comment` VALUES (1,1,0,'첫 번째 댓글',1,'2017-01-01 00:00:00'),(2,1,0,'두 번째 댓글',2,'2017-01-01 00:00:00'),(3,1,0,'세 번째 댓글',3,'2017-01-01 00:00:00');
/*!40000 ALTER TABLE `notice_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suggestion`
--

DROP TABLE IF EXISTS `suggestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suggestion` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `contents` text NOT NULL,
  `writer` int(11) unsigned NOT NULL,
  `write_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `views` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suggestion`
--

LOCK TABLES `suggestion` WRITE;
/*!40000 ALTER TABLE `suggestion` DISABLE KEYS */;
INSERT INTO `suggestion` VALUES (1,'Paging 1','Paging 1',1,'2017-11-01 00:00:00',36),(2,'Paging 2','Paging 2',1,'2017-11-01 00:00:00',0),(3,'Paging 3','Paging 3',1,'2017-11-01 00:00:00',0),(4,'Paging 4','Paging 4',1,'2017-11-01 00:00:00',0),(5,'Paging 5','Paging 5',1,'2017-11-01 00:00:00',0),(6,'Paging 6','Paging 6',1,'2017-11-01 00:00:00',0),(7,'Paging 7','Paging 7',1,'2017-11-01 00:00:00',0),(8,'Paging 8','Paging 8',1,'2017-11-01 00:00:00',0),(9,'Paging 9','Paging 9',1,'2017-11-01 00:00:00',0),(10,'Paging 10','Paging 10',1,'2017-11-01 00:00:00',0),(11,'Paging 11','Paging 11',1,'2017-11-01 00:00:00',0),(12,'Paging 12','Paging 12',1,'2017-11-01 00:00:00',0),(13,'Paging 13','Paging 13',1,'2017-11-01 00:00:00',0),(14,'Paging 14','Paging 14',1,'2017-11-01 00:00:00',0),(15,'Paging 15','Paging 15',1,'2017-11-01 00:00:00',0),(16,'Paging 16','Paging 16',1,'2017-11-01 00:00:00',0),(17,'Paging 17','Paging 17',1,'2017-11-01 00:00:00',0),(18,'Paging 18','Paging 18',1,'2017-11-01 00:00:00',0),(19,'Paging 19','Paging 19',1,'2017-11-01 00:00:00',0),(20,'Paging 20','Paging 20',1,'2017-11-01 00:00:00',0),(21,'Paging 21','Paging 21',1,'2017-11-01 00:00:00',0),(22,'Paging 22','Paging 22',1,'2017-11-01 00:00:00',0),(23,'Paging 23','Paging 23',1,'2017-11-01 00:00:00',0),(24,'Paging 24','Paging 24',1,'2017-11-01 00:00:00',0),(25,'Paging 25','Paging 25',1,'2017-11-01 00:00:00',0),(26,'Paging 26','Paging 26',1,'2017-11-01 00:00:00',0),(27,'Paging 27','Paging 27',1,'2017-11-01 00:00:00',0),(28,'Paging 28','Paging 28',1,'2017-11-01 00:00:00',0),(29,'Paging 29','Paging 29',1,'2017-11-01 00:00:00',0),(30,'Paging 30','Paging 30',1,'2017-11-01 00:00:00',0),(31,'Paging 31','Paging 31',1,'2017-11-01 00:00:00',0),(32,'Paging 32','Paging 32',1,'2017-11-01 00:00:00',0),(33,'Paging 33','Paging 33',1,'2017-11-01 00:00:00',0),(34,'Paging 34','Paging 34',1,'2017-11-01 00:00:00',0),(35,'Paging 35','Paging 35',1,'2017-11-01 00:00:00',0),(36,'Paging 36','Paging 36',1,'2017-11-01 00:00:00',0),(37,'Paging 37','Paging 37',1,'2017-11-01 00:00:00',0),(38,'Paging 38','Paging 38',1,'2017-11-01 00:00:00',0),(39,'Paging 39','Paging 39',1,'2017-11-01 00:00:00',0),(40,'Paging 40','Paging 40',1,'2017-11-01 00:00:00',0),(41,'Paging 41','Paging 41',1,'2017-11-01 00:00:00',0),(42,'Paging 42','Paging 42',1,'2017-11-01 00:00:00',0),(43,'Paging 43','Paging 43',1,'2017-11-01 00:00:00',0),(44,'Paging 44','Paging 44',1,'2017-11-01 00:00:00',0),(45,'Paging 45','Paging 45',1,'2017-11-01 00:00:00',0),(46,'Paging 46','Paging 46',1,'2017-11-01 00:00:00',0),(47,'Paging 47','Paging 47',1,'2017-11-01 00:00:00',0),(48,'Paging 48','Paging 48',1,'2017-11-01 00:00:00',0),(49,'Paging 49','Paging 49',1,'2017-11-01 00:00:00',0),(50,'Paging 50','Paging 50',1,'2017-11-01 00:00:00',0),(51,'Paging 51','Paging 51',1,'2017-11-01 00:00:00',0),(52,'Paging 52','Paging 52',1,'2017-11-01 00:00:00',0),(53,'Paging 53','Paging 53',1,'2017-11-01 00:00:00',0),(54,'Paging 54','Paging 54',1,'2017-11-01 00:00:00',0),(55,'Paging 55','Paging 55',1,'2017-11-01 00:00:00',0),(56,'Paging 56','Paging 56',1,'2017-11-01 00:00:00',0),(57,'Paging 57','Paging 57',1,'2017-11-01 00:00:00',0),(58,'Paging 58','Paging 58',1,'2017-11-01 00:00:00',0),(59,'Paging 59','Paging 59',1,'2017-11-01 00:00:00',0),(60,'Paging 60','Paging 60',1,'2017-11-01 00:00:00',0),(61,'Paging 61','Paging 61',1,'2017-11-01 00:00:00',0),(62,'Paging 62','Paging 62',1,'2017-11-01 00:00:00',0),(63,'Paging 63','Paging 63',1,'2017-11-01 00:00:00',0),(64,'Paging 64','Paging 64',1,'2017-11-01 00:00:00',0),(65,'Paging 65','Paging 65',1,'2017-11-01 00:00:00',0),(66,'Paging 66','Paging 66',1,'2017-11-01 00:00:00',0),(67,'Paging 67','Paging 67',1,'2017-11-01 00:00:00',0),(68,'Paging 68','Paging 68',1,'2017-11-01 00:00:00',0),(69,'Paging 69','Paging 69',1,'2017-11-01 00:00:00',0),(70,'Paging 70','Paging 70',1,'2017-11-01 00:00:00',0),(71,'Paging 71','Paging 71',1,'2017-11-01 00:00:00',0),(72,'Paging 72','Paging 72',1,'2017-11-01 00:00:00',0),(73,'Paging 73','Paging 73',1,'2017-11-01 00:00:00',0),(74,'Paging 74','Paging 74',1,'2017-11-01 00:00:00',0),(75,'Paging 75','Paging 75',1,'2017-11-01 00:00:00',0),(76,'Paging 76','Paging 76',1,'2017-11-01 00:00:00',0),(77,'Paging 77','Paging 77',1,'2017-11-01 00:00:00',0),(78,'Paging 78','Paging 78',1,'2017-11-01 00:00:00',0),(79,'Paging 79','Paging 79',1,'2017-11-01 00:00:00',0),(80,'Paging 80','Paging 80',1,'2017-11-01 00:00:00',0),(81,'Paging 81','Paging 81',1,'2017-11-01 00:00:00',0),(82,'Paging 82','Paging 82',1,'2017-11-01 00:00:00',0),(83,'Paging 83','Paging 83',1,'2017-11-01 00:00:00',0),(84,'Paging 84','Paging 84',1,'2017-11-01 00:00:00',0),(85,'Paging 85','Paging 85',1,'2017-11-01 00:00:00',0),(86,'Paging 86','Paging 86',1,'2017-11-01 00:00:00',0),(87,'Paging 87','Paging 87',1,'2017-11-01 00:00:00',0),(88,'Paging 88','Paging 88',1,'2017-11-01 00:00:00',0),(89,'Paging 89','Paging 89',1,'2017-11-01 00:00:00',0),(90,'Paging 90','Paging 90',1,'2017-11-01 00:00:00',0),(91,'Paging 91','Paging 91',1,'2017-11-01 00:00:00',0),(92,'Paging 92','Paging 92',1,'2017-11-01 00:00:00',0),(93,'Paging 93','Paging 93',1,'2017-11-01 00:00:00',0),(94,'Paging 94','Paging 94',1,'2017-11-01 00:00:00',0),(95,'Paging 95','Paging 95',1,'2017-11-01 00:00:00',0),(96,'Paging 96','Paging 96',1,'2017-11-01 00:00:00',0),(97,'Paging 97','Paging 97',1,'2017-11-01 00:00:00',0),(98,'Paging 98','Paging 98',1,'2017-11-01 00:00:00',0),(99,'Paging 99','Paging 99',1,'2017-11-01 00:00:00',0),(100,'Paging 100','Paging 100',1,'2017-11-01 00:00:00',0),(101,'Paging 101','Paging 101',1,'2017-11-01 00:00:00',0),(102,'Paging 102','Paging 102',1,'2017-11-01 00:00:00',0),(103,'Paging 103','Paging 103',1,'2017-11-01 00:00:00',0),(104,'Paging 104','Paging 104',1,'2017-11-01 00:00:00',0),(105,'Paging 105','Paging 105',1,'2017-11-01 00:00:00',0),(106,'Paging 106','Paging 106',1,'2017-11-01 00:00:00',0),(107,'Paging 107','Paging 107',1,'2017-11-01 00:00:00',0),(108,'Paging 108','Paging 108',1,'2017-11-01 00:00:00',0),(109,'Paging 109','Paging 109',1,'2017-11-01 00:00:00',0),(110,'Paging 110','Paging 110',1,'2017-11-01 00:00:00',0),(111,'Paging 111','Paging 111',1,'2017-11-01 00:00:00',0),(112,'Paging 112','Paging 112',1,'2017-11-01 00:00:00',0),(113,'Paging 113','Paging 113',1,'2017-11-01 00:00:00',0),(114,'Paging 114','Paging 114',1,'2017-11-01 00:00:00',0),(115,'Paging 115','Paging 115',1,'2017-11-01 00:00:00',0);
/*!40000 ALTER TABLE `suggestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suggestion_comment`
--

DROP TABLE IF EXISTS `suggestion_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suggestion_comment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `suggestion_id` int(10) unsigned NOT NULL,
  `parent_comment_id` int(10) unsigned NOT NULL DEFAULT '0',
  `contents` text NOT NULL,
  `writer` int(10) unsigned NOT NULL,
  `write_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suggestion_comment`
--

LOCK TABLES `suggestion_comment` WRITE;
/*!40000 ALTER TABLE `suggestion_comment` DISABLE KEYS */;
INSERT INTO `suggestion_comment` VALUES (1,1,0,'첫 번째 댓글',1,'2017-01-01 00:00:00'),(2,1,0,'두 번째 댓글',2,'2017-01-01 00:00:00'),(3,1,0,'세 번째 댓글',3,'2017-01-01 00:00:00');
/*!40000 ALTER TABLE `suggestion_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_code` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(24) NOT NULL DEFAULT '',
  `passwd` varchar(255) NOT NULL DEFAULT '',
  `col_id` varchar(24) NOT NULL DEFAULT '',
  `dept_id` varchar(24) NOT NULL DEFAULT '',
  `student_code` varchar(16) NOT NULL,
  `name` varchar(24) NOT NULL DEFAULT '',
  `email` varchar(128) NOT NULL DEFAULT '',
  `phone` varchar(16) NOT NULL DEFAULT '',
  PRIMARY KEY (`user_code`),
  KEY `student_code` (`student_code`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','17','-','관리자','admin@korea.ac.kr','010-0000-0001'),(2,'prof','$2a$10$X6cqrhxfokWw8LH68AXNMOR.fYFa2aaCaEoXBKGNwSPiZ2uTQIXgq','2','17','-','교수','prof@korea.ac.kr','010-0000-0002'),(3,'assistant','$2a$10$DPUIzmJ6fXRoAo1Xk2Cw6uQTgALPbPxhSNpP9eBV/1CS6/SlK6pUO','2','17','-','조교','assistant@korea.ac.kr','010-0000-0003'),(4,'worker01','$2a$10$fHNP4i4ZkcbtQIiHWIMS2uQ8XxWseX6ObCfvVJX0.ga4//p2X7Jf.','2','17','2011270001','근무자01','worker01@korea.ac.kr','010-0000-0004'),(5,'worker02','$2a$10$0qpU2i17bEADkZNChAA8QeAJ4FFvRi2RLyvDsTEUlSopD3pnTkSBS','2','17','2011270002','근무자02','worker02@korea.ac.kr','010-0000-0005'),(6,'student01','$2a$10$GN1YkP2bnoDM4PXDVQPg/u1XIrV39yEG9VuTmYwvtIXLpLh5OrxKW','2','8','2011270003','학생01','student01@korea.ac.kr','010-0000-0006'),(7,'student02','$2a$10$u2Y9yYiQCnaezWdGxcB7huXIqi/s8BEew6UMJuDHBkXKhEHlQBaii','2','9','2011270004','학생02','student02@korea.ac.kr','010-0000-0007'),(8,'Paging1','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','1','Paging1','paging1@korea.ac.kr','1'),(9,'Paging2','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','2','Paging2','paging2@korea.ac.kr','2'),(10,'Paging3','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','3','Paging3','paging3@korea.ac.kr','3'),(11,'Paging4','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','4','Paging4','paging4@korea.ac.kr','4'),(12,'Paging5','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','5','Paging5','paging5@korea.ac.kr','5'),(13,'Paging6','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','6','Paging6','paging6@korea.ac.kr','6'),(14,'Paging7','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','7','Paging7','paging7@korea.ac.kr','7'),(15,'Paging8','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','8','Paging8','paging8@korea.ac.kr','8'),(16,'Paging9','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','9','Paging9','paging9@korea.ac.kr','9'),(17,'Paging10','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','10','Paging10','paging10@korea.ac.kr','10'),(18,'Paging11','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','11','Paging11','paging11@korea.ac.kr','11'),(19,'Paging12','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','12','Paging12','paging12@korea.ac.kr','12'),(20,'Paging13','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','13','Paging13','paging13@korea.ac.kr','13'),(21,'Paging14','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','14','Paging14','paging14@korea.ac.kr','14'),(22,'Paging15','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','15','Paging15','paging15@korea.ac.kr','15'),(23,'Paging16','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','16','Paging16','paging16@korea.ac.kr','16'),(24,'Paging17','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','17','Paging17','paging17@korea.ac.kr','17'),(25,'Paging18','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','18','Paging18','paging18@korea.ac.kr','18'),(26,'Paging19','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','19','Paging19','paging19@korea.ac.kr','19'),(27,'Paging20','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','20','Paging20','paging20@korea.ac.kr','20'),(28,'Paging21','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','21','Paging21','paging21@korea.ac.kr','21'),(29,'Paging22','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','22','Paging22','paging22@korea.ac.kr','22'),(30,'Paging23','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','23','Paging23','paging23@korea.ac.kr','23'),(31,'Paging24','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','24','Paging24','paging24@korea.ac.kr','24'),(32,'Paging25','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','25','Paging25','paging25@korea.ac.kr','25'),(33,'Paging26','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','26','Paging26','paging26@korea.ac.kr','26'),(34,'Paging27','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','27','Paging27','paging27@korea.ac.kr','27'),(35,'Paging28','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','28','Paging28','paging28@korea.ac.kr','28'),(36,'Paging29','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','29','Paging29','paging29@korea.ac.kr','29'),(37,'Paging30','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','30','Paging30','paging30@korea.ac.kr','30'),(38,'Paging31','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','31','Paging31','paging31@korea.ac.kr','31'),(39,'Paging32','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','32','Paging32','paging32@korea.ac.kr','32'),(40,'Paging33','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','33','Paging33','paging33@korea.ac.kr','33'),(41,'Paging34','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','34','Paging34','paging34@korea.ac.kr','34'),(42,'Paging35','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','35','Paging35','paging35@korea.ac.kr','35'),(43,'Paging36','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','36','Paging36','paging36@korea.ac.kr','36'),(44,'Paging37','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','37','Paging37','paging37@korea.ac.kr','37'),(45,'Paging38','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','38','Paging38','paging38@korea.ac.kr','38'),(46,'Paging39','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','39','Paging39','paging39@korea.ac.kr','39'),(47,'Paging40','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','40','Paging40','paging40@korea.ac.kr','40'),(48,'Paging41','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','41','Paging41','paging41@korea.ac.kr','41'),(49,'Paging42','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','42','Paging42','paging42@korea.ac.kr','42'),(50,'Paging43','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','43','Paging43','paging43@korea.ac.kr','43'),(51,'Paging44','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','44','Paging44','paging44@korea.ac.kr','44'),(52,'Paging45','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','45','Paging45','paging45@korea.ac.kr','45'),(53,'Paging46','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','46','Paging46','paging46@korea.ac.kr','46'),(54,'Paging47','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','47','Paging47','paging47@korea.ac.kr','47'),(55,'Paging48','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','48','Paging48','paging48@korea.ac.kr','48'),(56,'Paging49','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','49','Paging49','paging49@korea.ac.kr','49'),(57,'Paging50','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','50','Paging50','paging50@korea.ac.kr','50'),(58,'Paging51','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','51','Paging51','paging51@korea.ac.kr','51'),(59,'Paging52','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','52','Paging52','paging52@korea.ac.kr','52'),(60,'Paging53','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','53','Paging53','paging53@korea.ac.kr','53'),(61,'Paging54','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','54','Paging54','paging54@korea.ac.kr','54'),(62,'Paging55','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','55','Paging55','paging55@korea.ac.kr','55'),(63,'Paging56','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','56','Paging56','paging56@korea.ac.kr','56'),(64,'Paging57','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','57','Paging57','paging57@korea.ac.kr','57'),(65,'Paging58','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','58','Paging58','paging58@korea.ac.kr','58'),(66,'Paging59','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','59','Paging59','paging59@korea.ac.kr','59'),(67,'Paging60','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','60','Paging60','paging60@korea.ac.kr','60'),(68,'Paging61','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','61','Paging61','paging61@korea.ac.kr','61'),(69,'Paging62','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','62','Paging62','paging62@korea.ac.kr','62'),(70,'Paging63','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','63','Paging63','paging63@korea.ac.kr','63'),(71,'Paging64','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','64','Paging64','paging64@korea.ac.kr','64'),(72,'Paging65','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','65','Paging65','paging65@korea.ac.kr','65'),(73,'Paging66','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','66','Paging66','paging66@korea.ac.kr','66'),(74,'Paging67','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','67','Paging67','paging67@korea.ac.kr','67'),(75,'Paging68','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','68','Paging68','paging68@korea.ac.kr','68'),(76,'Paging69','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','69','Paging69','paging69@korea.ac.kr','69'),(77,'Paging70','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','70','Paging70','paging70@korea.ac.kr','70'),(78,'Paging71','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','71','Paging71','paging71@korea.ac.kr','71'),(79,'Paging72','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','72','Paging72','paging72@korea.ac.kr','72'),(80,'Paging73','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','73','Paging73','paging73@korea.ac.kr','73'),(81,'Paging74','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','74','Paging74','paging74@korea.ac.kr','74'),(82,'Paging75','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','75','Paging75','paging75@korea.ac.kr','75'),(83,'Paging76','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','76','Paging76','paging76@korea.ac.kr','76'),(84,'Paging77','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','77','Paging77','paging77@korea.ac.kr','77'),(85,'Paging78','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','78','Paging78','paging78@korea.ac.kr','78'),(86,'Paging79','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','79','Paging79','paging79@korea.ac.kr','79'),(87,'Paging80','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','80','Paging80','paging80@korea.ac.kr','80'),(88,'Paging81','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','81','Paging81','paging81@korea.ac.kr','81'),(89,'Paging82','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','82','Paging82','paging82@korea.ac.kr','82'),(90,'Paging83','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','83','Paging83','paging83@korea.ac.kr','83'),(91,'Paging84','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','84','Paging84','paging84@korea.ac.kr','84'),(92,'Paging85','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','85','Paging85','paging85@korea.ac.kr','85'),(93,'Paging86','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','86','Paging86','paging86@korea.ac.kr','86'),(94,'Paging87','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','87','Paging87','paging87@korea.ac.kr','87'),(95,'Paging88','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','88','Paging88','paging88@korea.ac.kr','88'),(96,'Paging89','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','89','Paging89','paging89@korea.ac.kr','89'),(97,'Paging90','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','90','Paging90','paging90@korea.ac.kr','90'),(98,'Paging91','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','91','Paging91','paging91@korea.ac.kr','91'),(99,'Paging92','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','92','Paging92','paging92@korea.ac.kr','92'),(100,'Paging93','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','93','Paging93','paging93@korea.ac.kr','93'),(101,'Paging94','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','94','Paging94','paging94@korea.ac.kr','94'),(102,'Paging95','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','95','Paging95','paging95@korea.ac.kr','95'),(103,'Paging96','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','96','Paging96','paging96@korea.ac.kr','96'),(104,'Paging97','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','97','Paging97','paging97@korea.ac.kr','97'),(105,'Paging98','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','98','Paging98','paging98@korea.ac.kr','98'),(106,'Paging99','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','99','Paging99','paging99@korea.ac.kr','99'),(107,'Paging100','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','100','Paging100','paging100@korea.ac.kr','100'),(108,'Paging101','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','101','Paging101','paging101@korea.ac.kr','101'),(109,'Paging102','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','102','Paging102','paging102@korea.ac.kr','102'),(110,'Paging103','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','103','Paging103','paging103@korea.ac.kr','103'),(111,'Paging104','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','104','Paging104','paging104@korea.ac.kr','104'),(112,'Paging105','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','105','Paging105','paging105@korea.ac.kr','105'),(113,'Paging106','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','106','Paging106','paging106@korea.ac.kr','106'),(114,'Paging107','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','107','Paging107','paging107@korea.ac.kr','107'),(115,'Paging108','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','108','Paging108','paging108@korea.ac.kr','108'),(116,'Paging109','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','109','Paging109','paging109@korea.ac.kr','109'),(117,'Paging110','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','110','Paging110','paging110@korea.ac.kr','110'),(118,'Paging111','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','111','Paging111','paging111@korea.ac.kr','111'),(119,'Paging112','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','112','Paging112','paging112@korea.ac.kr','112'),(120,'Paging113','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','113','Paging113','paging113@korea.ac.kr','113'),(121,'Paging114','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','114','Paging114','paging114@korea.ac.kr','114'),(122,'Paging115','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','10','115','Paging115','paging115@korea.ac.kr','115');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `working_diary`
--

DROP TABLE IF EXISTS `working_diary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `working_diary` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_code` int(10) unsigned NOT NULL,
  `working_start_datetime` datetime NOT NULL,
  `working_end_datetime` datetime NOT NULL,
  `working_contents` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_code` (`user_code`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `working_diary`
--

LOCK TABLES `working_diary` WRITE;
/*!40000 ALTER TABLE `working_diary` DISABLE KEYS */;
INSERT INTO `working_diary` VALUES (1,4,'2017-11-15 00:00:00','2017-11-15 01:00:00','PL Center Open'),(2,5,'2017-11-16 02:00:00','2017-11-16 03:00:00','상담'),(3,4,'2017-11-17 03:00:00','2017-11-17 04:00:00','PL Center Close'),(4,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 1'),(5,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 2'),(6,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 3'),(7,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 4'),(8,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 5'),(9,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 6'),(10,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 7'),(11,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 8'),(12,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 9'),(13,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 10'),(14,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 11'),(15,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 12'),(16,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 13'),(17,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 14'),(18,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 15'),(19,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 16'),(20,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 17'),(21,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 18'),(22,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 19'),(23,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 20'),(24,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 21'),(25,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 22'),(26,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 23'),(27,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 24'),(28,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 25'),(29,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 26'),(30,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 27'),(31,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 28'),(32,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 29'),(33,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 30'),(34,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 31'),(35,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 32'),(36,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 33'),(37,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 34'),(38,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 35'),(39,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 36'),(40,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 37'),(41,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 38'),(42,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 39'),(43,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 40'),(44,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 41'),(45,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 42'),(46,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 43'),(47,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 44'),(48,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 45'),(49,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 46'),(50,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 47'),(51,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 48'),(52,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 49'),(53,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 50'),(54,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 51'),(55,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 52'),(56,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 53'),(57,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 54'),(58,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 55'),(59,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 56'),(60,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 57'),(61,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 58'),(62,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 59'),(63,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 60'),(64,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 61'),(65,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 62'),(66,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 63'),(67,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 64'),(68,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 65'),(69,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 66'),(70,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 67'),(71,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 68'),(72,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 69'),(73,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 70'),(74,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 71'),(75,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 72'),(76,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 73'),(77,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 74'),(78,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 75'),(79,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 76'),(80,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 77'),(81,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 78'),(82,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 79'),(83,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 80'),(84,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 81'),(85,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 82'),(86,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 83'),(87,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 84'),(88,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 85'),(89,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 86'),(90,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 87'),(91,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 88'),(92,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 89'),(93,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 90'),(94,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 91'),(95,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 92'),(96,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 93'),(97,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 94'),(98,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 95'),(99,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 96'),(100,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 97'),(101,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 98'),(102,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 99'),(103,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 100'),(104,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 101'),(105,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 102'),(106,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 103'),(107,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 104'),(108,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 105'),(109,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 106'),(110,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 107'),(111,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 108'),(112,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 109'),(113,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 110'),(114,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 111'),(115,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 112'),(116,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 113'),(117,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 114'),(118,4,'2017-11-01 00:00:00','2017-11-01 00:00:00','Paging 115');
/*!40000 ALTER TABLE `working_diary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
