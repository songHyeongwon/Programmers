-- 코드를 입력하세요
-- https://school.programmers.co.kr/learn/courses/30/lessons/59410?language=oracle
SELECT ANIMAL_TYPE 
,NVL(NAME ,'No name')
,SEX_UPON_INTAKE from ANIMAL_INS order by ANIMAL_ID;