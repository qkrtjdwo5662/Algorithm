-- 코드를 입력하세요
SELECT a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, SUM(c.SALES * b.PRICE) as TOTAL_SAELS
from AUTHOR as a
left join BOOK b
on a.AUTHOR_ID = b.AUTHOR_ID
left join BOOK_SALES c
on b.BOOK_ID = c.BOOK_ID
where YEAR(c.SALES_DATE) = 2022 and MONTH(c.SALES_DATE) = 1
group by a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY
order by a.AUTHOR_ID , b.CATEGORY desc;