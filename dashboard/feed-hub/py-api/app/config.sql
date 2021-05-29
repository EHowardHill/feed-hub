CREATE TABLE if not exists db.`login`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE if not exists db.`feed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE if not exists db. `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_unit` int(11) DEFAULT NULL,
  `id_feed` int(11) DEFAULT NULL,
  `id_customer` int(11) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE if not exists db.`stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_unit` int(11) DEFAULT NULL,
  `id_feed` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE if not exists db.`unit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);