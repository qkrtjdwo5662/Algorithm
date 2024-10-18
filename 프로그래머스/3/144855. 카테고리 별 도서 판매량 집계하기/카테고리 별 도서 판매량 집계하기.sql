-- 코드를 입력하세요
SELECT a.CATEGORY, sum(b.SALES) as TOTAL_SALES
from BOOK as a
left join BOOK_SALES b
on a.BOOK_ID = b.BOOK_ID
where YEAR(b.SALES_DATE) = 2022 and MONTH(b.SALES_DATE) = 1
group by a.CATEGORY
order by a.CATEGORY