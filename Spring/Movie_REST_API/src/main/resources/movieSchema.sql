use ssafydb;

DROP TABLE `movies`;

CREATE TABLE IF NOT EXISTS `movies`(
	id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(20) NOT NULL,
    director VARCHAR(50) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    duration INT,
    viewCnt INT
);

SELECT * FROM movies;