-- 코드를 입력하세요

SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from ONLINE_SALE 
where YEAR(SALES_DATE) = 2022 and MONTH(SALES_DATE) = 3


union all

SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, null as USER_ID, SALES_AMOUNT
from OFFLINE_SALE 
where YEAR(SALES_DATE) = 2022 and MONTH(SALES_DATE) = 3
order by SALES_DATE, PRODUCT_ID, USER_ID
