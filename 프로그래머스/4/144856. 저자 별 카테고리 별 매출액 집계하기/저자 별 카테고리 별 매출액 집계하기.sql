-- 코드를 입력하세요
SELECT b.AUTHOR_ID, b.AUTHOR_NAME, a.CATEGORY, sum(c.SALES * a.PRICE)  as TOTAL_SALES
from BOOK a
left join AUTHOR b
on a.AUTHOR_ID = b.AUTHOR_ID
left join BOOK_SALES c
on c.BOOK_ID = a.BOOK_ID
where DATE_FORMAT(c.SALES_DATE, '%Y-%m') = '2022-01'
group by b.AUTHOR_ID, a.CATEGORY
order by b.AUTHOR_ID, a.CATEGORY desc;

# select *
# from BOOK a
# left join BOOK_SALES c
# on c.BOOK_ID = a.BOOK_ID
# where DATE_FORMAT(c.SALES_DATE, '%Y-%m') = '2022-01'