CREATE DATABASE `ggmmy` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `phone` varchar(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `open_id` (`open_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `category` (
  `category_id` int(5) NOT NULL,
  `category_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `category_name` (`category_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `good` (
  `good_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `good_name` varchar(255) NOT NULL,
  `user_id` int(10) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `category_id` int(5) NOT NULL,
  `date` timestamp NOT NULL,
  `trades` set('自提','上门','面交') NOT NULL,
  PRIMARY KEY (`good_id`),
  KEY `fk_good_user` (`user_id`),
  KEY `fk_good_category` (`category_id`),
  CONSTRAINT `fk_good_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `fk_good_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `order` (
  `order_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `good_id` int(10) unsigned zerofill NOT NULL,
  `order_state` enum('UNACCEPTED','ACCEPTED','CANCELED_BY_C','CANCELED_BY_O','COMPLETED','FAILED') NOT NULL DEFAULT 'UNACCEPTED' COMMENT '\\n',
  `created_date` timestamp NULL DEFAULT NULL,
  `trade` set('自提','上门','面交') NOT NULL DEFAULT '自提',
  `addr` varchar(255) NOT NULL,
  `finished_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_order_user` (`user_id`),
  KEY `fk_order_good` (`good_id`),
  CONSTRAINT `fk_order_good` FOREIGN KEY (`good_id`) REFERENCES `good` (`good_id`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


