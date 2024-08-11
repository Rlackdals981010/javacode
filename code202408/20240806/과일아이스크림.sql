SELECT FLAVOR
from (
         select ii.FLAVOR, fh.TOTAL_ORDER, ii.INGREDIENT_TYPE
         from FIRST_HALF fh inner join ICECREAM_INFO ii on fh.FLAVOR = ii.FLAVOR
         where fh.TOTAL_ORDER > 3000
     )a
where INGREDIENT_TYPE like 'fruit%'
order by TOTAL_ORDER desc