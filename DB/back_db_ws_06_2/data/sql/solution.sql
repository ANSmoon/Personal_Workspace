SELECT 
    *
FROM
    movie;

-- 1. movie 테이블에 전체 몇개의 행이 있는지 조회하시오.
SELECT
	count(*) AS "영화 수"
FROM movie;

-- 2. 전체 영화의 상영시간 평균을 조회하시오.
SELECT 
    AVG(RunningTime) AS '평균'
FROM
    movie;

-- 3. 전체 영화의 상영시간 합을 조회하시오.
SELECT 
    SUM(RunningTime) AS '총 합'
FROM
    movie;

-- 4. 제목에 '포터' 단어가 포함된 영화들의 상영시간 평균을 둘째자리까지 반옹림 하여 조회
SELECT ROUND(AVG(RunningTime),2) AS "포터 평균" FROM movie WHERE Title LIKE "%포터%";

-- 5. cinemacode로 그룹핑 했을때 각 그룹에 몇개의 영화가 포함되어 있는지 조회
SELECT cinemacode, count(*) AS "수" FROM movie group by cinemacode;

-- 6. cinemacode로 그룹핑 했을때 각 그룹의 제일 먼저 개봉한 영화의 날짜를 조회하시오.
SELECT cinemacode, MAX(ReleaseDate) AS "날짜" FROM movie GROUP BY CinemaCode;

-- 7. cinemacode로 그룹핑 했을 때 각 그룹의 제일 긴 상영시간이 몇분인지 조회
SELECT cinemacode, MAX(RunningTime) AS "최대" FROM movie GROUP BY CinemaCode;


-- 8. cinemacode로 그룹핑 했을 때 상영시간의 평균이 150분 이상인 그룹의 cindemacode 조회
-- having은 그룹화한 대상을 필터링
-- where은 from절에서 선택된 table에 조건을 만족하는 행 필터링
SELECT cinemacode, AVG(RunningTime) AS "평균" FROM movie group by cinemacode HAVING AVG(RunningTime) >= 150;

-- 9. cinemacode로 그룹핑 했을 때 상영시간의 평균이 300분 이상인 그룹의 cindemacode 조회
SELECT cinemacode, sum(RunningTime) AS "합" FROM movie group by cinemacode HAVING sum(RunningTime) >= 300;

-- 10.cinemacode로 그룹핑 했을때 상영시간의 평균이 150분 이상인 그룹들 중 상영시간의 총 합이 300 이산인 그룹의 cinemacode 조회
SELECT cinemacode AS "코드", AVG(RunningTime) AS "평균", SUM(RunningTime) AS "합" FROM movie group by cinemacode HAVING AVG(RunningTime) >= 150 and SUM(RunningTime)>=300;
