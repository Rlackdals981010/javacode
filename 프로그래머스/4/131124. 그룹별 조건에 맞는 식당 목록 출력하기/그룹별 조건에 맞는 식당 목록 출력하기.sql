-- 코드를 입력하세요
SELECT  mp.MEMBER_NAME, rr.REVIEW_TEXT, DATE_FORMAT(rr.REVIEW_DATE,'%Y-%m-%d')
from MEMBER_PROFILE mp inner join REST_REVIEW rr on mp.MEMBER_ID = rr.MEMBER_ID
where mp.MEMBER_ID = (
    select MEMBER_ID
    from REST_REVIEW
    group by MEMBER_ID
    order by count(*) desc limit 1
)
order by rr.REVIEW_DATE, rr.REVIEW_TEXT