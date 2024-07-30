# 10월에 대여를 시작한 기록이 있는 
# 세단 종류의 차량 리스트
# 중복은 없고 ID 기준 내림차순

select distinct(c.CAR_ID)
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
on c.CAR_ID = h.CAR_ID
where 
c.CAR_TYPE = '세단' 
and 
h.START_DATE between '2022-10-01' and '2022-10-31'
order by c.CAR_ID desc;