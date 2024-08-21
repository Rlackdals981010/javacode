-- 코드를 입력하세요
SELECT b.BOOK_ID, a.AUTHOR_NAME, date_format(b.PUBLISHED_DATE,'%Y-%m-%d')PUBLISHED_DATE
from BOOK b inner join AUTHOR a on b.AUTHOR_ID=a.AUTHOR_ID
where b.CATEGORY like '%경제%'
order by b.PUBLISHED_DATE