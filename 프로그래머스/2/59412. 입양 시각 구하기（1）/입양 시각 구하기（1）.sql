select hour(DATETIME), count(*)
from ANIMAL_OUTS
where hour(DATETIME) between '9' and '19'
group by 1
order by 1