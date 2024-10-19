-- 코드를 작성해주세요
with recursive tmp as (
    select ID, PARENT_ID, 1 as GENERATION
    from ECOLI_DATA
    where PARENT_ID is null
    union
    select a.ID, a.PARENT_ID, b.GENERATION + 1 as GENERATION
    from ECOLI_DATA a
    join tmp b
    on a.PARENT_ID = b.ID
)

select count(GENERATION) as COUNT, GENERATION
from tmp 
where ID not in(
    select PARENT_ID
    from tmp
    group by PARENT_ID
    having PARENT_ID is not null
)
group by GENERATION
order by GENERATION