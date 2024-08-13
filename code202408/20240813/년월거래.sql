SELECT Year(o.SALES_DATE), Month(o.SALES_DATE), u.Gender,count(distinct o.USER_ID)
from USER_INFO u inner join ONLINE_SALE o on u.USER_ID = o.USER_ID
where u.gender is not null
group by Year(o.SALES_DATE), Month(o.SALES_DATE), u.Gender
order by Year(o.SALES_DATE), Month(o.SALES_DATE), u.Gender