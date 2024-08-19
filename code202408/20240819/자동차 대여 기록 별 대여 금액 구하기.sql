-- 코드를 입력하세요
-- 대여 금액, 대여 기록 ID, 대여 금액 리스트
SELECT A.HISTORY_ID, IF(B.DURATION_TYPE IS NULL, A.DAILY_FEE * A.RENTAL_DAYS, ROUND((A.DAILY_FEE * (100-B.DISCOUNT_RATE)*0.01) * A.RENTAL_DAYS,0)) AS 'FEE'

from (
         select bb.HISTORY_ID, aa.DAILY_FEE,
                DATEDIFF(bb.END_DATE, bb.START_DATE)+1 RENTAL_DAYS,
                CASE WHEN DATEDIFF(bb.END_DATE, bb.START_DATE)+1 >= 90 THEN '90일 이상'
                     WHEN DATEDIFF(bb.END_DATE, bb.START_DATE)+1 >= 30 THEN '30일 이상'
                     WHEN DATEDIFF(bb.END_DATE, bb.START_DATE)+1 >= 7 THEN '7일 이상'
                     ELSE '7일 미만' END DURATION_TYPE
         from CAR_RENTAL_COMPANY_CAR aa inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY bb on aa.CAR_ID = bb.CAR_ID
         where aa.CAR_TYPE like '트럭'
     )A LEFT JOIN (SELECT * FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN B WHERE CAR_TYPE='트럭')B on A.DURATION_TYPE = B.DURATION_TYPE
ORDER BY FEE DESC, HISTORY_ID DESC