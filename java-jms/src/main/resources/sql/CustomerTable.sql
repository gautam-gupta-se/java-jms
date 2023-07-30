CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO `customer` (`email`, `password`, `role`)
 VALUES ('gg300906@example.com', 'pass001', 'admin');