CREATE SCHEMA `demo`;
USE `demo`;

CREATE TABLE `user` (
    `login` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    PRIMARY KEY (`login`))
    ENGINE=InnoDB
    DEFAULT CHARSET=utf8mb4
    COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `user` (`login`, `password`) VALUES ('admin', SHA2('password',256)), ('user', SHA2('password',256));