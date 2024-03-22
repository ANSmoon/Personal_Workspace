use ssafy_user;

select * from user;
select * from board;

#1.	user 테이블에 전채 몇개의 행이 있는지 조회하시오.
select COUNT(*) as '사용자 수' from user;

#2.	전체 user의 age 평균을 조회하시오.
select AVG(age) as '평균' from user;

#3.	전체 사용자의 age 합을 조회하시오.
select SUM(age) as '총 합' from user;

#4.	age가 35 이상인 사용자의 age 평균을 둘째짜리 까지 반올림 하여 조회하시오.
select round(avg(age), 2) as '평균' from user where age >= 35;

#5.	writername로 그룹핑 했을때 각 사용자가 몇 개의 board를 가지고 있는지 조회하시오.
select writername, count(*) as '개수' from board group by writername;

#6.	board 를 writername로 그룹핑 했을때 각 이름이 ‘토르’ 인 사용자의 의 제일 최근 create time을 조회하시오.
-- where -> group by 순서
-- 여기서 group by 없어도 됨...
select writername, MIN(createtime) as '날짜' from board WHERE writername = '토르' Group by writername;

#7.	board 를 writername로 그룹핑 했을 때 2017년 이후 각 사용자가 몇 개의 board를 가지고 있는지 조회하시오.
-- 그룹화한 대상이 하나인데 불러오려는 대상은 2개의 column이다. 이때 날짜 createtime은 여러개가 있기 때문에 문제가 발생하므로 조건을 걸어 오류를 방지한다.
select writername, MIN(createtime), count(*) as '개수' from board where createtime > '2017-01-01 00:00:00' Group by writername;


