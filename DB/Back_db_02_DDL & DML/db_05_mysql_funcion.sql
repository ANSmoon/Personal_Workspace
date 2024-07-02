# Q1. 숫자관련 함수 사용
-- 2의 3제곱
SELECT POW(2,3) AS "2의 3제곱";

-- 8 나누기 3의 나머지
SELECT MOD(2,POW(2,3)) AS "8 나누기 3의 나머지";

-- 최대값, 최솟값
SELECT greatest(1,2,3,4,5,6,7,8,9,11,22,44,66,889,9000) AS 최댓값, least(7,8,9,11,22,44,66,889,9000) AS 최솟값;

-- 반올림
SELECT ROUND(3.1421235125), ROUND(3.1421235125, 1), ROUND(3.1421235125, 2), ROUND(3.1421235125, 3), ROUND(3.1421235125, 4);

# Q2. 문자 관련 함수
-- 아스키 코드값 얻기
SELECT ascii('0'), ascii('A'), ascii('a');

-- concat 메서드를 써보자.
SELECT concat("president의 이름은 ", ename, ' 입니다.') AS "소개"
FROM emp
WHERE job = "PRESIDENT";

-- 이름의 길이가 5인 직원의 이름을 조회
SELECT ename
FROM emp
WHERE length(ename) = 5;

SELECT length("한글"), char_length("한글"); -- 6 vs 2
SELECT length("ssafy"), char_length("ssafy"); -- 5 vs 5

-- 문자열 변경
SELECT replace('hello world world','world','hi') as '문자열 변경';

-- 문자열 인덱스


-- 모든 직원의 이름 3자리조회


-- LPAD RPAD


-- REVERSE


# Q3. 날짜 관련함수
-- 2초 더하기
SELECT addtime("2024-03-20 10:49:30","2") as "2초 더하기";


-- 날짜차이
SELECT DATEDIFF("2020-01-01", "2010-10-23");


-- 오늘은?
SELECT NOW(), day(now()), month(now()), year(now()), yearweek(now());


# Q4. Transaction 사용해보기
SET autocommit = 0; -- autocommit 취소
-- SET autocommit = 1; autocommit 설정

USE ssafy;
CREATE TABLE test_table(val VARCHAR(20));

-- ROLLBACK
START TRANSACTION;
INSERT INTO test_table VALUE("A");
INSERT INTO test_table VALUE("B");
INSERT INTO test_table VALUE("C");
INSERT INTO test_table VALUE("D");

ROLLBACK;

-- commit
START TRANSACTION;
INSERT INTO test_table VALUE("S");
INSERT INTO test_table VALUE("S");
INSERT INTO test_table VALUE("A");
INSERT INTO test_table VALUE("F");
INSERT INTO test_table VALUE("Y");

COMMIT;

SELECT 
    *
FROM
    test_table;

