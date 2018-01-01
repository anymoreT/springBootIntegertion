CREATE DATABASE `springboot`  /*!40100 DEFAULT CHARACTER SET u

CREATE TABLE `message` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `NICK_NAME` varchar(50) DEFAULT NULL COMMENT '鏄电О',
  `IP` varchar(50) DEFAULT NULL COMMENT 'IP',
  `INSERT_TIME` datetime DEFAULT NULL COMMENT '鎻愪氦鏃堕棿',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8


CREATE TABLE `project_info` (
  `project_id` int(10) NOT NULL,
  `project_name` varchar(30) NOT NULL,
  PRIMARY KEY (`project_id`,`project_name`),
  UNIQUE KEY `index_project_id` (`project_id`) USING BTREE,
  UNIQUE KEY `index_project_name` (`project_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8



CREATE TABLE `uploadinfo` (
  `package` varchar(30) NOT NULL,
  `class` varchar(30) NOT NULL,
  `method` varchar(30) NOT NULL,
  `project_id` int(10) NOT NULL,
  `project_name` varchar(10) NOT NULL,
  `index` bigint(20) NOT NULL AUTO_INCREMENT,
  `uploadDate` datetime DEFAULT NULL,
  PRIMARY KEY (`index`),
  KEY `project_id` (`project_id`),
  KEY `project_name` (`project_name`),
  CONSTRAINT `project_id` FOREIGN KEY (`project_id`) REFERENCES `project_info` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8