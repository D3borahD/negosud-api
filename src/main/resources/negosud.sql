DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
    `id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(50) DEFAULT NULL,
    `last_name` varchar(50) DEFAULT NULL,
    `mail` varchar(150) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `customer` (`id`, `first_name`, `last_name`, `mail`) VALUES (NULL, 'Laurent', 'Michel', 'laurent.michel@gmail.com');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `mail`) VALUES (NULL, 'Gérard', 'Dupond', 'gerard.dupond@gmail.com');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `mail`) VALUES (NULL, 'Lucie', 'Paire', 'lucie.paire@gmail.com');



DROP TABLE IF EXISTS `familly`;

CREATE TABLE `familly` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(50) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `familly` (`id`, `name`) VALUES (NULL, 'Blanc');
INSERT INTO `familly` (`id`, `name`) VALUES (NULL, 'Rouge');

DROP TABLE IF EXISTS `house`;

CREATE TABLE `house` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `name` varchar(50) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `house` (`id`, `name`) VALUES (NULL, 'Maison Poitout');
INSERT INTO `house` (`id`, `name`) VALUES (NULL, 'Le Clarence De Haut Brion');


/*
 Provider
 */
DROP TABLE IF EXISTS `provider`;

CREATE TABLE `provider` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(50) DEFAULT NULL,
                            `mail` varchar(150) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `provider` (`id`, `name`, `mail`) VALUES (NULL, 'Michel', 'laurent.michel@gmail.com');
INSERT INTO `provider` (`id`, `name`,  `mail`) VALUES (NULL, 'Dupond', 'gerard.dupond@gmail.com');
INSERT INTO `provider` (`id`, `name`, `mail`) VALUES (NULL,  'Paire', 'lucie.paire@gmail.com');

/*
 Product
 */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(50) DEFAULT NULL,
                            `unite_price` float DEFAULT NULL,
                            `package_price` float DEFAULT NULL,
                            `year` varchar(4) DEFAULT NULL,
                            `quantity` int DEFAULT NULL,
                            `needRefill` BOOLEAN,
                            `comment` varchar(300) DEFAULT NULL,
                            `cepage` varchar(50) DEFAULT NULL,
                            `automatic_replenishment_threshold` int DEFAULT NULL,

                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `product` (`id`, `name`, `unite_price`, `package_price`, `year`, `quantity`, `need_refill`, `comment`, `cepage`, `automatic_replenishment_threshold`)
VALUES (NULL, 'Michel', 23.30, 50.87, '2000', 3, FALSE, 'blablabla', 'mon cépage', 1);
INSERT INTO `product` (`id`, `name`, `unite_price`, `package_price`, `year`, `quantity`, `need_refill`, `comment`, `cepage`, `automatic_replenishment_threshold`)
VALUES (NULL, 'Sebastien', 23.30, 50.87, '2000', 3, TRUE, 'blablabla', 'mon cépage', 0);

/*
Address
 */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `type` varchar(50) DEFAULT NULL,
                           `number` varchar(50) DEFAULT NULL,
                           `street_name` varchar(180) DEFAULT NULL,
                           `zip` int DEFAULT NULL,
                           `city` varchar(100) DEFAULT NULL,
                           `additional` varchar(150) DEFAULT NULL,

                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `address` (`id`, `type`, `number`, `street_name`, `zip`, `city`, `additional`)
VALUES (NULL, 'facture', '2B', 'rue Paul Bert', '69003', 'Lyon', '');
INSERT INTO `address` (`id`, `type`, `number`, `street_name`, `zip`, `city`, `additional`)
VALUES (NULL, 'livraison', '2A', 'rue Paul Bert', '69003', 'Lyon', '2eme étage');