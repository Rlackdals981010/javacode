-- 코드를 입력하세요
SELECT ao.ANIMAL_ID, ao.NAME
from ANIMAL_INS ai right join ANIMAL_OUTS ao on ai.ANIMAL_ID =ao.ANIMAL_ID
order by ao.DATETIME - ai.DATETIME desc limit 2