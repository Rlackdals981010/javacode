-- 코드를 입력하세요
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS,if(FREEZER_YN IS NULL,'N',FREEZER_YN) "FREEZER_YN"
from FOOD_WAREHOUSE
WHERE ADDRESS like '%경기도%'
order by WAREHOUSE_ID