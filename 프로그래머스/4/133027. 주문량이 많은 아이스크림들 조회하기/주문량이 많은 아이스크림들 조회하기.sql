-- 코드를 입력하세요
# 7월 아이스크림 총 주문량 + 상반기의 아이스크림 총 주문량
SELECT a.FLAVOR
from FIRST_HALF as a
join JULY as b
on a.FLAVOR = b.FLAVOR
GROUP BY FLAVOR
order by SUM(a.TOTAL_ORDER) + SUM(b.TOTAL_ORDER) desc
limit 3;
