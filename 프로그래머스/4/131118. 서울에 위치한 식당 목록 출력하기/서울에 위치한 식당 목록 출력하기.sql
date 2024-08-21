-- 코드를 입력하세요
SELECT ri.REST_ID, ri.REST_NAME, ri.FOOD_TYPE, ri.FAVORITES, ri.ADDRESS, ROUND(AVG(rr.REVIEW_SCORE),2) sco
from REST_INFO ri inner join REST_REVIEW rr on ri.REST_ID=rr.REST_ID
where ri.ADDRESS like '서울%'
group by ri.REST_ID 
order by sco DESC, ri.FAVORITES DESC