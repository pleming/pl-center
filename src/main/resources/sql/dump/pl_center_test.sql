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
INSERT INTO `auth` VALUES (1,3),(2,2),(3,2),(4,1),(5,1),(6,0),(7,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counsel`
--

LOCK TABLES `counsel` WRITE;
/*!40000 ALTER TABLE `counsel` DISABLE KEYS */;
INSERT INTO `counsel` VALUES (1,4,1,6,'2017-11-01 00:00:00','printf'),(2,5,2,7,'2017-11-02 00:00:00','scanf'),(3,4,3,6,'2017-11-03 00:00:00','include');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suggestion`
--

LOCK TABLES `suggestion` WRITE;
/*!40000 ALTER TABLE `suggestion` DISABLE KEYS */;
/*!40000 ALTER TABLE `suggestion` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','$2a$10$GryXOoEWPtaCz5go98XdseZYvhi66vLrv2yBB64vQqQSMiER.0Z.G','2','17','-','관리자','admin@korea.ac.kr','010-0000-0001'),(2,'prof','$2a$10$X6cqrhxfokWw8LH68AXNMOR.fYFa2aaCaEoXBKGNwSPiZ2uTQIXgq','2','17','-','교수','prof@korea.ac.kr','010-0000-0002'),(3,'assistant','$2a$10$DPUIzmJ6fXRoAo1Xk2Cw6uQTgALPbPxhSNpP9eBV/1CS6/SlK6pUO','2','17','-','조교','assistant@korea.ac.kr','010-0000-0003'),(4,'worker01','$2a$10$fHNP4i4ZkcbtQIiHWIMS2uQ8XxWseX6ObCfvVJX0.ga4//p2X7Jf.','2','17','2011270001','근무자01','worker01@korea.ac.kr','010-0000-0004'),(5,'worker02','$2a$10$0qpU2i17bEADkZNChAA8QeAJ4FFvRi2RLyvDsTEUlSopD3pnTkSBS','2','17','2011270002','근무자02','worker02@korea.ac.kr','010-0000-0005'),(6,'student01','$2a$10$GN1YkP2bnoDM4PXDVQPg/u1XIrV39yEG9VuTmYwvtIXLpLh5OrxKW','2','8','2011270003','학생01','student01@korea.ac.kr','010-0000-0006'),(7,'student02','$2a$10$u2Y9yYiQCnaezWdGxcB7huXIqi/s8BEew6UMJuDHBkXKhEHlQBaii','2','9','2011270004','학생02','student02@korea.ac.kr','010-0000-0007');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `working_diary`
--

LOCK TABLES `working_diary` WRITE;
/*!40000 ALTER TABLE `working_diary` DISABLE KEYS */;
INSERT INTO `working_diary` VALUES (1,4,'2017-11-15 00:00:00','2017-11-15 01:00:00','PL Center Open'),(2,5,'2017-11-16 02:00:00','2017-11-16 03:00:00','상담'),(3,4,'2017-11-17 03:00:00','2017-11-17 04:00:00','PL Center Close');
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
