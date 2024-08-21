-- 코드를 입력하세요
SELECT distinct ANIMAL_ID, ANIMAL_TYPE, NAME
from (
    select ao.ANIMAL_ID, ao.ANIMAL_TYPE, ao.NAME, ai.SEX_UPON_INTAKE, ao.SEX_UPON_OUTCOME
    from  ANIMAL_INS ai inner join ANIMAL_OUTS ao on ai.ANIMAL_ID=ao.ANIMAL_ID
    Where ai.SEX_UPON_INTAKE like '%Intact%'
)a
where SEX_UPON_OUTCOME like '%Spayed%' or SEX_UPON_OUTCOME like '%Neutered%'
order by ANIMAL_ID