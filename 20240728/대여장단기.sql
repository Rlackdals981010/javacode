SELECT HISTORY_ID, CAR_ID,
       DATE_FORMAT(START_DATE,'%Y-%m-%d')START_DATE,
       DATE_FORMAT(END_DATE,'%Y-%m-%d')END_DATE ,
       case
           when END_DATE- START_DATE >= 28 then '장기 대여'
           ELSE '단기 대여'
           END AS  RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE >='2022-09-01' and START_DATE<'2022-10-01'
order by HISTORY_ID desc

--DATEDIFF를 사용할땐 +1을 해야함 . 잊지마셈