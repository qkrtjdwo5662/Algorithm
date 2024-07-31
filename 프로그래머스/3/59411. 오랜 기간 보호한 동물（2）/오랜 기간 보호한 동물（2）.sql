# 입양을 간 동물 중, 
# 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름을 조회하는 SQL문을 작성

select o.ANIMAL_ID, o.NAME
from ANIMAL_OUTS o
join ANIMAL_INS i
on o.ANIMAL_ID = i.ANIMAL_ID
order by (o.DATETIME - i.DATETIME) desc
limit 2;