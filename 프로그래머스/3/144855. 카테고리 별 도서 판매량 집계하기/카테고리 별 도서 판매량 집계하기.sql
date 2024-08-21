-- 코드를 입력하세요
SELECT b.CATEGORY, sum(SALES) TOTAL_SALES
from BOOK b inner join BOOK_SALES bs on b.BOOK_ID = bs.BOOK_ID
where DATE_FORMAT(bs.SALES_DATE,'%Y-%m')='2022-01'
group by b.CATEGORY
order by b.CATEGORY