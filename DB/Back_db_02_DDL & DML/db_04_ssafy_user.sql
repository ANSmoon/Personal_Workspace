# Q1. ssafydb 데이터 베이스 생성 및 사용
CREATE DATABASE IF NOT EXISTS ssafydb;
USE ssafydb;

# Q2. ssafy_user 테이블 생성
CREATE TABLE ssafy_user(
	-- 학번
    user_num INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    -- ID
    user_id VARCHAR(20) NOT NULL,
    -- 이름
    user_name VARCHAR(20) NOT NULL,
    -- PW
    user_password VARCHAR(20) NOT NULL,
    -- email
    user_email VARCHAR(30),
    -- 가입날짜
    signup_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- TABLE 정보 확인(DESCRIBE)
DESCRIBE ssafy_user;
DESC ssafy_user;

# Q3. INSERT 쿼리를 사용해보자.
-- 모든 컬럼 입력
INSERT INTO ssafy_user
VALUES(1, "ansmoon","문문","1234","moon@gmail.com", now());

-- 원하는 컬럼만 입력
INSERT INTO ssafy_user (user_id, user_name, user_password)
VALUES("ssafy", "samsung", "1234");

SELECT 
    *
FROM
    ssafy_user;

-- 여러개의 data를 한번에 삽입
INSERT INTO ssafy_user (user_id, user_name, user_password)
VALUES("ssafy1", "samsung1", "1234"),
		("ssafy2", "samsung2", "1234"),
		("ssafy3", "samsung3", "1234");

# Q4. 데이터를 수정해보자
-- pk를 이용해 특정 레코드 수정 가능

UPDATE ssafy_user 
SET 
    user_name = 'WONYOUNG'
WHERE
    user_num = 2;

UPDATE sssfy_user 
SET 
    user_name = 'annonymous';

# Q5. 데이터를 삭제해보자
DELETE FROM ssafy_user 
WHERE
    user_num = 4;

