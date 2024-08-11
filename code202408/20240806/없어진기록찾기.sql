SELECT ao.ANIMAL_ID, ao.NAME
from ANIMAL_INS ai right join ANIMAL_OUTS ao on ai.ANIMAL_ID = ao.ANIMAL_ID
where ai.ANIMAL_ID is NULL
order by ao.ANIMAL_ID