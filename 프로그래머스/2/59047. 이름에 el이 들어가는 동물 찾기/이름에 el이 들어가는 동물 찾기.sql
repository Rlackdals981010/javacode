-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
from ANIMAL_INS
where NAME LIKE '%el%' AND ANIMAL_TYPE = 'Dog'
order by NAME