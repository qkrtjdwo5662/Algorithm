-- 코드를 입력하세요
WITH tmp as (
    select *, TIMESTAMPDIFF(day, START_DATE, END_DATE) + 1 as DURATION
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
)


select b.HISTORY_ID,
case 
    when c.DISCOUNT_RATE is null then round(a.DAILY_FEE * b.DURATION)
    else round(a.DAILY_FEE *  b.DURATION * (100 - c.DISCOUNT_RATE)/ 100)
end as FEE
from CAR_RENTAL_COMPANY_CAR a 
left join tmp b
on a.CAR_ID = b.CAR_ID
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
on a.CAR_TYPE = c.CAR_TYPE and c.DURATION_TYPE = (
    case 
    when b.DURATION >= 90 then '90일 이상'
    when b.DURATION >= 30 then '30일 이상'
    when b.DURATION >= 7 then '7일 이상'
    else null
    end
)
where a.CAR_TYPE = '트럭'
order by FEE desc, b.HISTORY_ID desc;
