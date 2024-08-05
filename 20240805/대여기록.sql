SELECT distinct(cc.CAR_ID)
from CAR_RENTAL_COMPANY_CAR cc inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY ch on cc.CAR_ID = ch.CAR_ID
where CAR_TYPE like '세단' and  Month(START_DATE)=10
order by CAR_ID desc