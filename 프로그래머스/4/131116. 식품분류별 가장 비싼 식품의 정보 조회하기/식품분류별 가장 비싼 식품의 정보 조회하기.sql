-- 코드를 입력하세요
SELECT CATEGORY, PRICE as MAX_PRICE, PRODUCT_NAME
from food_product
where (CATEGORY, PRICE) in (
    select CATEGORY, max(PRICE)
    from food_product
    where CATEGORY in ('과자', '국', '김치', '식용유')
    group by CATEGORY
)
group by CATEGORY
order by MAX_PRICE desc;
