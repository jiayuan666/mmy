use ggmmy;
drop table if exists `user`;
CREATE TABLE `user` (
	`open_id` varchar(255) NOT NULL PRIMARY KEY,
    `nickname` varchar(255) NOT NULL DEFAULT '',
    `phone` varchar(11) NOT NULL unique
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `user` VALUES
('123456789','渣渣源','13145798088');

DROP TABLE IF EXISTS `category`;
create table `category`(
	`category_id` int(5) not null primary key,
	`category_name` varchar(10) not null unique
);

DROP TABLE IF EXISTS `good`;
create table `good`(
	`good_id` int(10) zerofill not null primary key auto_increment,
	`good_name` varchar(255) not null default '',
	`open_id` varchar(255) not null default '',
	`price` float not null default 0,
	`stock` int not null default 0,
	`detail` varchar(255) default '',
	`trade` char(1) not null default '0',
	`category_id` int(5) not null,
	`date` datetime DEFAULT NULL default '2019-1-1 00:00:00',
    constraint `fk_good_user` foreign key (`open_id`) references `user`(`open_id`),
    constraint `fk_good_category` foreign key (`category_id`) references `category`(`category_id`)
)ENGINE=InnoDB auto_increment=1	DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `image`;
create table `image`(
	`image_id` int(10) zerofill not null primary key auto_increment,
	`image_url` varchar(255) not null,
	`good_id` int(10) zerofill not null,
	constraint `fk_image_good` foreign key (`good_id`) references `good`(`good_id`)
)ENGINE=InnoDB auto_increment=1	DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `order`;
create table `order`(
	`order_id` int(10) zerofill not null primary key auto_increment,
	`open_id` varchar(255) not null,
	`good_id` int(10) zerofill not null,
	`order_state` varchar(1) not null default '0',
	`date` datetime DEFAULT NULL,
	`post_add` varchar(255) DEFAULT NULL,
	constraint `fk_order_user` foreign key (`open_id`) references `user`(`open_id`),
	constraint `fk_order_good` foreign key (`good_id`) references `good`(`good_id`)
)ENGINE=InnoDB auto_increment=1	DEFAULT CHARSET=utf8mb4;




