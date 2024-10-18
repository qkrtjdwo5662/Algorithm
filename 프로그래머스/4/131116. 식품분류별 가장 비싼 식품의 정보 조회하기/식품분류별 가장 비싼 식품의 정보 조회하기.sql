-- 코드를 입력하세요
SELECT CATEGORY, PRICE, PRODUCT_NAME
from FOOD_PRODUCT
where (category, PRICE) in
(
    select category, MAX(PRICE) as PRICE
    from FOOD_PRODUCT
    group by category
) and CATEGORY in ('과자', '국', '김치', '식용유')
order by PRICE desc;

