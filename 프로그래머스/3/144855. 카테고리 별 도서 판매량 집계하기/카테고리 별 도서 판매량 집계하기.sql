#2022년 1월의 카테고리 별 도서 판매량을 합산
#카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력하는 SQL문

select b.CATEGORY, sum(s.SALES) as TOTAL_SALES
from BOOK b
join BOOK_SALES s
on b.BOOK_ID = s.BOOK_ID
where s.SALES_DATE like '2022-01%'
group by b.CATEGORY
order by b.CATEGORY