# 1.	back_db_ws_07_2 라는 이름으로 새로운 schema를 생성하고, 해당 스키마를 사용하시오.
CREATE SCHEMA IF NOT EXISTS back_db_ws_07_2;
USE back_db_ws_07_2;

# 2.	만약 user 라는 테이블이 존재한다면 삭제하시오.
DROP TABLE IF EXISTS `movie`;


# 3. back_db_ws_07_2에 다음 조건을 만족하는 movie table 생성
CREATE TABLE movie(
	# column명 // type // null 여부 // default 값
    `ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Title` VARCHAR(40) NOT NULL,
    `ReleaseDate` DATE,
    `RunningTime` int NOT NULL
)ENGINE=InnoDB AUTO_INCREMENT = 1000;

DESC movie;

# 4. movie table에 아래와 같이 director라는 column 삽입
ALTER TABLE `movie` ADD COLUMN `Director` VARCHAR(32);

# 5. movie table의 director 컬럼을 아래와 같이 변경하시오.
ALTER TABLE `movie` modify COLUMN `Director` VARCHAR(40) NOT NULL;

DESC movie;

# 6. Director column 삭제
ALTER TABLE `movie` DROP COLUMN `Director`;

DESC movie;

# 7. movie table에 아래와 같은 data를 삽입하시오.
INSERT INTO `movie` (Title, ReleaseDate, RunningTime)
VALUES
("이터널스", "2021-11-05", "156"),
("트랜스포머", "2002-10-02", "92"),
("해리포터와 마법사의 돌", "2001-12-14", "152"),
("해리포터와 비밀의 방", "2002-12-14", "162"),
("기생충", "2019-05-30", "153");

# 8. ID가 1003인 영화의 Title을 "해리포터와 불의 잔"으로 변경
UPDATE movie
SET Title = "해리포터와 불의 잔"
WHERE ID = "1003";

# 9.RunningTime이 100 이하인 영화 삭제
DELETE 
FROM movie
WHERE RunningTime <= 100;

# 10. movie table에 있는 모든 data를 삭제하시오.
DELETE FROM movie;

SELECT * FROM movie;
