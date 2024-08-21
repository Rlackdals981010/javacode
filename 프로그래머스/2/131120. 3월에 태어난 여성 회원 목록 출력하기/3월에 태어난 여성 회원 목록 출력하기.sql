-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME,GENDER, Date_format(DATE_OF_BIRTH,'%Y-%m-%d')asDATE_OF_BIRTH
from MEMBER_PROFILE
where GENDER like 'W' and Month(DATE_OF_BIRTH)=3 and TLNO is not NUll
order by MEMBER_ID