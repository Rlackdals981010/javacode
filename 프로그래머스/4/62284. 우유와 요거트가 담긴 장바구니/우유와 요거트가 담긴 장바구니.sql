select CART_ID
from CART_PRODUCTS
where name in ('Milk','Yogurt')
group by CART_ID HAVING COUNT(DISTINCT NAME)>1
order by CART_ID