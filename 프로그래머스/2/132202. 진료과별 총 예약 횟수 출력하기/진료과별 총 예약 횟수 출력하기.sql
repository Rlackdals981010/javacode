-- 코드를 입력하세요
SELECT MCDP_CD "진료과 코드", count(*) "5월예약건수"
from APPOINTMENT
where YEAR(APNT_YMD)='2022' and MONTH(APNT_YMD)='5'
group by MCDP_CD
order by 2,1