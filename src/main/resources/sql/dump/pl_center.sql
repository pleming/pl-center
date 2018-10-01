/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table auth
# ------------------------------------------------------------

DROP TABLE IF EXISTS `auth`;

CREATE TABLE `auth` (
  `user_code` int(11) unsigned NOT NULL,
  `auth` int(11) unsigned NOT NULL,
  UNIQUE KEY `user_code` (`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `auth` WRITE;
/*!40000 ALTER TABLE `auth` DISABLE KEYS */;

INSERT INTO `auth` (`user_code`, `auth`)
VALUES
	(1,3),
	(2,2),
	(3,2),
	(4,2),
	(5,1),
	(6,1),
	(7,1),
	(8,0),
	(9,0),
	(10,0);

/*!40000 ALTER TABLE `auth` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table class
# ------------------------------------------------------------

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `year` int(11) NOT NULL,
  `semester` int(11) NOT NULL,
  `class_no` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `year` (`year`),
  KEY `semester` (`semester`),
  KEY `class_no` (`class_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;

INSERT INTO `class` (`id`, `year`, `semester`, `class_no`)
VALUES
	(1,2011,1,1),
	(2,2012,2,2),
	(3,2013,1,3);

/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table class_std
# ------------------------------------------------------------

DROP TABLE IF EXISTS `class_std`;

CREATE TABLE `class_std` (
  `class_id` int(11) unsigned NOT NULL,
  `user_code` int(11) unsigned NOT NULL,
  UNIQUE KEY `class_id` (`class_id`,`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `class_std` WRITE;
/*!40000 ALTER TABLE `class_std` DISABLE KEYS */;

INSERT INTO `class_std` (`class_id`, `user_code`)
VALUES
	(1,8),
	(1,9),
	(1,10);

/*!40000 ALTER TABLE `class_std` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table col_dept
# ------------------------------------------------------------

DROP TABLE IF EXISTS `col_dept`;

CREATE TABLE `col_dept` (
  `col_id` int(11) unsigned NOT NULL,
  `dept_id` int(11) unsigned NOT NULL,
  UNIQUE KEY `col_id` (`col_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `col_dept` WRITE;
/*!40000 ALTER TABLE `col_dept` DISABLE KEYS */;

INSERT INTO `col_dept` (`col_id`, `dept_id`)
VALUES
	(1,1),
	(1,2),
	(1,3),
	(1,4),
	(1,5),
	(1,6),
	(1,7),
	(2,8),
	(2,9),
	(2,10),
	(2,11),
	(2,12),
	(2,13),
	(2,14),
	(2,15),
	(2,16),
	(2,17),
	(2,18),
	(3,19),
	(3,20),
	(3,21),
	(3,22),
	(3,23),
	(3,24),
	(4,25),
	(4,26),
	(4,27),
	(4,28),
	(4,29),
	(4,30),
	(4,31),
	(4,32),
	(5,33);

/*!40000 ALTER TABLE `col_dept` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table college
# ------------------------------------------------------------

DROP TABLE IF EXISTS `college`;

CREATE TABLE `college` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `college` varchar(11) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `college` WRITE;
/*!40000 ALTER TABLE `college` DISABLE KEYS */;

INSERT INTO `college` (`id`, `college`)
VALUES
	(1,'공공정책대학'),
	(2,'과학기술대학'),
	(3,'글로벌비즈니스대학'),
	(4,'문화스포츠대학'),
	(5,'약학대학');

/*!40000 ALTER TABLE `college` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table counsel
# ------------------------------------------------------------

DROP TABLE IF EXISTS `counsel`;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `counsel` WRITE;
/*!40000 ALTER TABLE `counsel` DISABLE KEYS */;

INSERT INTO `counsel` (`id`, `counselor_user_code`, `class_id`, `user_code`, `counsel_datetime`, `counsel_contents`)
VALUES
	(1,5,1,8,'2017-11-01 00:00:00','printf'),
	(2,6,2,9,'2017-11-02 00:00:00','scanf'),
	(3,7,3,10,'2017-11-03 00:00:00','include');

/*!40000 ALTER TABLE `counsel` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table dept
# ------------------------------------------------------------

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `dept` varchar(24) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;

INSERT INTO `dept` (`id`, `dept`)
VALUES
	(1,'경제정책학전공'),
	(2,'공공사회학전공'),
	(3,'국가통계전공'),
	(4,'빅데이터전공'),
	(5,'사회복지융합전공'),
	(6,'정부행정학부'),
	(7,'통일외교안보전공'),
	(8,'데이터계산과학전공'),
	(9,'디스플레이융합전공'),
	(10,'반도체물리전공'),
	(11,'사이버보안전공'),
	(12,'생명정보공학과'),
	(13,'식품생명공학과'),
	(14,'신소재화학과'),
	(15,'전자/기계융합공학과'),
	(16,'전자및정보공학과'),
	(17,'컴퓨터융합소프트웨어학과'),
	(18,'환경시스템공학과'),
	(19,'글로벌경영전공'),
	(20,'독일학전공'),
	(21,'디지털경영전공'),
	(22,'영미학전공'),
	(23,'중국학전공'),
	(24,'한국학전공'),
	(25,'국제스포츠학부'),
	(26,'고고미술사학전공'),
	(27,'디지털매체문화융합전공'),
	(28,'문화ICT융합전공'),
	(29,'문화콘텐츠전공'),
	(30,'미디어문예창작학전공'),
	(31,'스포츠과학전공'),
	(32,'스포츠비즈니스전공'),
	(33,'약학대학');

/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`user_code`, `user_id`, `passwd`, `col_id`, `dept_id`, `student_code`, `name`, `email`, `phone`)
VALUES
	(1,'admin','password','2','17','-','관리자','admin@korea.ac.kr','010-0000-0001'),
	(2,'lecturer01','password','2','17','-','교수01','lecturer01@korea.ac.kr','010-0000-0002'),
	(3,'lecturer02','password','2','17','-','조교01','lecturer02@korea.ac.kr','010-0000-0003'),
	(4,'lecturer03','password','2','17','-','조교02','lecturer03@korea.ac.kr','010-0000-0004'),
	(5,'worker01','password','2','17','2011270001','근무자01','worker01@korea.ac.kr','010-0000-0005'),
	(6,'worker02','password','2','17','2011270002','근무자02','worker02@korea.ac.kr','010-0000-0006'),
	(7,'worker03','password','2','17','2011270003','근무자03','worker03@korea.ac.kr','010-0000-0007'),
	(8,'student01','password','2','8','2011270004','학생01','student01@korea.ac.kr','010-0000-0008'),
	(9,'student02','password','2','9','2011270005','학생02','student02@korea.ac.kr','010-0000-0009'),
	(10,'student03','password','2','10','2011270006','학생03','student03@korea.ac.kr','010-0000-00010');

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table working_diary
# ------------------------------------------------------------

DROP TABLE IF EXISTS `working_diary`;

CREATE TABLE `working_diary` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_code` int(10) unsigned NOT NULL,
  `working_start_datetime` datetime NOT NULL,
  `working_end_datetime` datetime NOT NULL,
  `working_contents` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_code` (`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `working_diary` WRITE;
/*!40000 ALTER TABLE `working_diary` DISABLE KEYS */;

INSERT INTO `working_diary` (`id`, `user_code`, `working_start_datetime`, `working_end_datetime`, `working_contents`)
VALUES
	(1,5,'2017-11-15 00:00:00','2017-11-15 01:00:00','PL Center Open'),
	(2,6,'2017-11-16 02:00:00','2017-11-16 03:00:00','상담'),
	(3,7,'2017-11-17 03:00:00','2017-11-17 04:00:00','PL Center Close');

/*!40000 ALTER TABLE `working_diary` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
