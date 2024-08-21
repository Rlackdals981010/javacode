-- 코드를 입력하세요
SELECT fp.PRODUCT_ID, fp.PRODUCT_NAME, sum(fp.PRICE*fo.AMOUNT)TOTAL_SALES
from FOOD_PRODUCT fp inner join FOOD_ORDER fo on fp.PRODUCT_ID = fo.PRODUCT_ID
where Year(fo.PRODUCE_DATE)=2022 and Month(fo.PRODUCE_DATE)=05
group by fo.PRODUCT_ID
order by TOTAL_SALES desc,  fp.PRODUCT_ID