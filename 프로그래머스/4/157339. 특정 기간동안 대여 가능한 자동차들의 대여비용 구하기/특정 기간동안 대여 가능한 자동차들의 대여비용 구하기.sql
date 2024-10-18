-- 코드를 입력하세요
SELECT a.CAR_ID, a.CAR_TYPE, round(a.DAILY_FEE * 30 * (100 - c.DISCOUNT_RATE)/ 100) as FEE
from CAR_RENTAL_COMPANY_CAR a
left join CAR_RENTAL_COMPANY_RENTAL_HISTORY b
on a.CAR_ID = b.CAR_ID
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
on a.CAR_TYPE = c.CAR_TYPE
where a.car_type in ('세단', 'SUV') and c.DURATION_TYPE = '30일 이상'
and a.CAR_ID not in 
(
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where END_DATE >= '2022-11-01' and START_DATE <= '2022-11-30'
)
group by a.CAR_ID
having FEE >= 500000 and FEE < 2000000
order by FEE desc, a.CAR_TYPE, a.CAR_ID desc;