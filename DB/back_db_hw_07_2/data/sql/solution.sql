#1.	test_user 라는 이름으로 새로운 schema를 생성하고, 해당 스키마를 사용하시오.
CREATE SCHEMA IF NOT EXISTS test_user;
USE test_user;


#2.	만약 user 라는 테이블이 존재한다면 삭제하시오.
DROP TABLE IF EXISTS `user`;


#3.	test_user 에 다음 조건을 만족하는 user 테이블을 생성하시오.
CREATE TABLE `user` (
	`id` VARCHAR(40) NOT NULL PRIMARY KEY,
    `password` VARCHAR(40) NOT NULL,
    `name` VARCHAR(40) NOT NULL,
    `email` VARCHAR(40) NOT NULL,
    `age` int NOT NULL
)ENGINE=InnoDB;

DESCRIBE user;

#4.	user 테이블에 아래와 같이 phone_number 라는 컬럼을 삽입하시오.
ALTER TABLE `user` ADD COLUMN `phone_number` int;
-- ALTER TABLE `user` modify COLUMN `phone_number` VARCHAR(40); 만약 이미 넣어준 column을 조정하고 싶다면 modify를 사용

DESCRIBE user;

#5.	user 테이블의 phone_number 컬럼을 아래와 같이 변경하시오.
ALTER TABLE `user` modify COLUMN `phone_number` VARCHAR(40) NOT NULL;

DESCRIBE user;

#6.	phone_number 컬럼을 삭제하시오.
ALTER TABLE `user` DROP COLUMN `phone_number`;

DESCRIBE user;

#7.	user 테이블에 아래와 같은 데이터를 삽입하시오.
INSERT INTO `user` (id, password, name, email, age) 
VALUES
('BlackWidow', '1278','나타샤 로마노프', 'blackwidow@ssafy.com', 38),
('CaptainAmerica', '5678','스티브 로저스', 'Captain@ssafy.com', 30),
('Hulk', '2486','브루스 배너', 'hulk@ssafy.com', 54),
('Ironman', '1234','토니 스타크', 'ironman@ssafy.com', 53),
('Thor', '1111','토르', 'GodOfThunder@ssafy.com', 1500),
('Ultron', '2355','울트론', 'ultron@ssafy.com', 0);

#8.	name이 토르 인 사용자의 eamil을 ‘Thor@ssafy.com’ 으로 변경하시오.
UPDATE `user` SET email = 'Thor@ssafy.com' WHERE id = 'Thor';

#9.	age가 1000 이상인 사용자를 삭제하시오.
DELETE FROM `user` WHERE age >= 1000;

DELETE FROM `user` WHERE id IN (SELECT id FROM `user` WHERE age >= 1000);

-- safe 풀지않고 푸는 방법 
DELETE user
FROM `user`
INNER JOIN (
    SELECT id FROM `user` WHERE age >= 1000
) AS subquery ON user.id = subquery.id;

#10.	user 테이블에 있는 모든 data를 삭제하시오.
TRUNCATE TABLE `user`;
/*
안전한 업데이트 모드에서는 WHERE 절에서 KEY 컬럼을 사용하지 않고 테이블을 업데이트하거나 삭제할 수 없습니다.
이 모드를 해제하지 않고도 모든 데이터를 삭제하는 방법 중 하나는 TRUNCATE 문을 사용하는 것입니다. 
TRUNCATE 문은 테이블 내의 모든 데이터를 빠르게 삭제할 수 있는 효율적인 방법입니다. 다음과 같이 사용할 수 있습니다.
*/
select * from user;
