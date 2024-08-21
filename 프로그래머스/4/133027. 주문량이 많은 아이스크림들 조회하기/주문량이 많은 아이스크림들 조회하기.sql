select FLAVOR
from(
    select * 
    from FIRST_HALF
    union ALL
    select *
    from JULY
)a
group by FLAVOR
order by sum(TOTAL_ORDER) desc limit 3;