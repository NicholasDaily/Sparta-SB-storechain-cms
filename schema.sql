DROP SCHEMA foodmart;
CREATE SCHEMA foodmart;
USE foodmart;

DROP TABLE IF EXISTS `employees`;
DROP TABLE IF EXISTS `roles`;

CREATE TABLE `employees` (
	`email` VARCHAR(80) NOT NULL,
	`password` VARCHAR(68) NOT NULL,
	`enabled` TINYINT NOT NULL,
	PRIMARY KEY (`email`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `roles` (
	`email` varchar(80) NOT NULL,
	`role` varchar(50) NOT NULL,
	UNIQUE KEY `authorities_idx_1` (`email`,`role`),
	CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`email`) REFERENCES `employees` (`email`),
	PRIMARY KEY(`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO employees(email, `password`, enabled) VALUES("admin@gmail.com", "{bcrypt}$2a$10$J8lWHpVngdAYk0/fxXqblOcwh3669D5oYN8xbVHpz8PGRMKTJYd3W", 1);
INSERT INTO `roles`(`email`, `role`) VALUES("admin@gmail.com", "ROLE_ADMIN");

DROP TABLE IF EXISTS `building_type`;

CREATE TABLE `building_type`(
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`description` VARCHAR(300) NOT NULL,
	PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `buildings`;

CREATE TABLE `buildings`(
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`address` VARCHAR(125) NOT NULL,
	`phone_number` VARCHAR(15) NOT NULL,
	`type_id` INTEGER NOT NULL,
    PRIMARY KEY (`id`),
	FOREIGN KEY (`type_id`) REFERENCES `building_type`(`id`)
);

DROP TABLE IF EXISTS `positions`;

CREATE TABLE `positions`(
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL,
	`description` VARCHAR(300) NOT NULL,
	PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `employee_details`;

CREATE TABLE `employee_details` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`employee_email` VARCHAR(80) NOT NULL,
	`building_id` INTEGER NOT NULL,
	`position_id` INTEGER NOT NULL,
	`salary` INTEGER NOT NULL,
	`first_name` VARCHAR(30) NOT NULL,
	`last_name` VARCHAR(30) NOT NULL,
	FOREIGN KEY (`position_id`) REFERENCES `positions` (`id`),
	FOREIGN KEY (`employee_email`) REFERENCES `employees`(`email`),
	FOREIGN KEY (`building_id`) REFERENCES `buildings`(`id`),
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `employee_reviews`;

CREATE TABLE `employee_reviews` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`employee_details_id` INTEGER NOT NULL,
	`reviewer_details_id` INTEGER NOT NULL,
	`score` INTEGER NOT NULL,
	`notes` TEXT,
	FOREIGN KEY (`employee_details_id`) REFERENCES `employee_details` (`id`),
	FOREIGN KEY (`reviewer_details_id`) REFERENCES `employee_details` (`id`), 
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `building_stats`;

CREATE TABLE `building_stats` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`building_id` INTEGER NOT NULL,
	`expenses` INTEGER NOT NULL,
	`income` INTEGER NOT NULL,
	`employee_quantity` INTEGER NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`building_id`) REFERENCES `buildings`(`id`)
);

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	PRIMARY KEY(`id`)
);

DROP TABLE IF EXISTS`api_keys`;

CREATE TABLE `api_keys`(
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`employee_email` VARCHAR(80) NOT NULL,
	`key` VARCHAR(20) NOT NULL,
	FOREIGN KEY (`employee_email`) REFERENCES `employees`(`email`),
	PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `building_to_product`;

CREATE TABLE `building_to_product`(
	building_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
	`quantity` INTEGER NOT NULL,
	`cost` FLOAT NOT NULL,
	`value` FLOAT NOT NULL,
	`sales` INTEGER NOT NULL,
    FOREIGN KEY (building_id) REFERENCES buildings(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);
