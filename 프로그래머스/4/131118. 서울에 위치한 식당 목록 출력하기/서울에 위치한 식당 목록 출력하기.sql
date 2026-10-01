-- 코드를 입력하세요
-- 코드를 입력하세요
select b.rest_id, a.rest_name, a.food_type, a.favorites, a.address, b.score
from 
rest_info a
right join 
(
    select REST_ID, round(avg(REVIEW_SCORE), 2) SCORE
    from rest_review
    group by REST_ID
) b
on a.rest_id = b.rest_id
where 1=1
and a.address like '서울%'
order by b.score desc, a.favorites desc
;
