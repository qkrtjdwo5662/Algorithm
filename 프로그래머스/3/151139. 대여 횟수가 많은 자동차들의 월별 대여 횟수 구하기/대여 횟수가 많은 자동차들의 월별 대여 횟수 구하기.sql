-- 코드를 입력하세요
SELECT MONTH(START_DATE) as MONTH, CAR_ID, COUNT(CAR_ID) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where MONTH(START_DATE) in (8, 9, 10) and
CAR_ID in (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where MONTH(START_DATE) in (8, 9, 10)
    group by CAR_ID
    having count(CAR_ID) >= 5
)
group by MONTH(START_DATE), CAR_ID
order by MONTH, CAR_ID desc;