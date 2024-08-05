# 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차들
# 해당 기간 동안의 월별 자동차 ID 별 총 대여 횟수(컬럼명: RECORDS) 리스트를 출력
select MONTH(START_DATE) as MONTH, CAR_ID, count(history_id) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date>="2022-08-01" and start_date<"2022-11-01" and car_id in 
(
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE >= '2022-08-01' and START_DATE < '2022-11-01'
    group by CAR_ID
    having count(HISTORY_ID) >= 5
)
group by MONTH, CAR_ID
having RECORDS > 0
order by MONTH, CAR_ID desc;