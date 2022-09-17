-- 코드를 입력하세요
-- https://school.programmers.co.kr/learn/courses/30/lessons/59409
SELECT ANIMAL_ID	,NAME,
case when INSTR(SEX_UPON_INTAKE , 'Neutered')  > 0 or INSTR(SEX_UPON_INTAKE , 'Spayed') then 'O' else 'X' end
from ANIMAL_INS 
order by ANIMAL_ID