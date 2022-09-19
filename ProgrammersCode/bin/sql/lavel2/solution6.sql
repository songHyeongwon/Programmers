-- 코드를 입력하세요
-- https://school.programmers.co.kr/learn/courses/30/lessons/59412
SELECT DATE_FORMAT(DATETIME, '%H') , count(DATETIME) from ANIMAL_OUTS 

where TIME(DATETIME) between TIME('09:00') AND TIME('19:59')
group by DATE_FORMAT(DATETIME, '%H')
order by DATE_FORMAT(DATETIME, '%H')
;