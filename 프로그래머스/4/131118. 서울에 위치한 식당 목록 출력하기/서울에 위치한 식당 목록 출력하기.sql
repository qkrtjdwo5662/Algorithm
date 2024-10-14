select i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS, round(avg(r.REVIEW_SCORE), 2) as SCORE
from REST_REVIEW r
join REST_INFO i
on r.REST_ID = i.REST_ID
where i.ADDRESS like '서울%'
group by r.REST_ID
order by SCORE desc, i.FAVORITES desc;