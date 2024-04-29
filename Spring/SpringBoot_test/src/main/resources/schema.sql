CREATE DATABASE spring_quest; -- spring_quest 라는 DB Schema를 등록합니다.

-- article이라는 table을 생성합니다.
CREATE TABLE article (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- id는 기본키이며, 자동으로 증가합니다. 
    title VARCHAR(255) NOT NULL, -- 제목은 문자형태로 들어가며, null값을 허용하지 않습니다.
    writer VARCHAR(255), -- 작성자는 문자형태로 들어갑니다. 
    agency VARCHAR(255), -- agency도 문자형태로 들어갑니다.
    content TEXT, -- 내용을 TEXT 형식으로 입력받습니다. 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 작성된 시간은 현재 시간을 입력받습니다. 
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 업데이트 시간은 작성된 시간을 기본값으로 하며 업데이트 순간의 시간으로 치환합니다. 
);

-- 테스트를 위해 임시로 작성한 삽입 구문
INSERT INTO `article`
(
`title`,
`writer`,
`agency`,
`content`) 
VALUES("test","ANSMOON","Test","test");

-- 현재 저장된 내용 확인
SELECT 
    *
FROM
    article;