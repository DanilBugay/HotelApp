DROP TABLE IF EXISTS roomuser ;
DROP TABLE IF EXISTS roomtype ;
DROP TABLE IF EXISTS roomstatus ;
DROP TABLE IF EXISTS roomhistory ;
DROP TABLE IF EXISTS room ;

CREATE TABLE `roomuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(35) NOT NULL DEFAULT '',
  `u_login` varchar(35) NOT NULL DEFAULT '',
  `u_pass` varchar(15) NOT NULL DEFAULT '',
  `u_mail` varchar(20) NOT NULL DEFAULT '',
  `u_phone` varchar(15) NOT NULL DEFAULT '',
  `status` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniqueLogin` (`u_login`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

CREATE TABLE `roomtype` (
  `id` int(11) NOT NULL,
  `room_type` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `roomstatus` (
  `id` int(11) NOT NULL,
  `status` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `roomhistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_num` int(11) NOT NULL DEFAULT '0',
  `date_start` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `date_end` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `id_roomuser` int(11) DEFAULT '0',
  `u_name` varchar(35) DEFAULT '',
  `u_mail` varchar(30) DEFAULT '',
  `u_phone` varchar(15) DEFAULT '',
  `id_roomstatus` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

CREATE TABLE `room` (
  `room_num` int(11) NOT NULL,
  `id_roomtype` int(11) NOT NULL DEFAULT '0',
  `rate` float NOT NULL DEFAULT '0',
  `descript` varchar(1000) NOT NULL DEFAULT '',
  `src_photo` varchar(200) NOT NULL DEFAULT '',
  PRIMARY KEY (`room_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
