-- 코드를 입력하세요
select *
from
(
select DATE_FORMAT(SALES_DATE, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from ONLINE_SALE a

union

select DATE_FORMAT(SALES_DATE, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, null as USER_ID, SALES_AMOUNT
from OFFLINE_SALE
) as NEWTABLE
where SALES_DATE like '2022-03%'
order by SALES_DATE,PRODUCT_ID, USER_ID



