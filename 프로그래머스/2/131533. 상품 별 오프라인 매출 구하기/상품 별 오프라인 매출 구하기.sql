-- 코드를 입력하세요
SELECT PRODUCT_CODE, sum(o.SALES_AMOUNT)*p.price op
from PRODUCT p inner join OFFLINE_SALE o on p.PRODUCT_ID = o.PRODUCT_ID
group by p.PRODUCT_CODE
order by op desc, 1