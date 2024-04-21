-- 코드를 작성해주세요
# select PARENT_ID, ifnull(count(PARENT_ID), 0) as "CHILD_COUNT"
# from ECOLI_DATA
# group by PARENT_ID

select a.ID, ifnull(b.CHILD_COUNT, 0) as "CHILD_COUNT"
from ECOLI_DATA a
left join 
(
    select PARENT_ID as ID, count(PARENT_ID) as "CHILD_COUNT"
    from ECOLI_DATA
    group by PARENT_ID
    having PARENT_ID is not null
) as b
on a.ID = b.ID
order by a.ID;