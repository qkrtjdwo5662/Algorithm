-- 코드를 작성해주세요
select a.ID, b.FISH_NAME, a.LENGTH
from 
(
    select b.ID, a.FISH_TYPE, a.LENGTH
    from(
        select FISH_TYPE, MAX(LENGTH) LENGTH
        from FISH_INFO 
        group by FISH_TYPE
    )  a
    left join 
    (
        select ID, FISH_TYPE, LENGTH
        from FISH_INFO
    ) as b
    on a.FISH_TYPE = b.FISH_TYPE and a.LENGTH = b.LENGTH
) as a
left join FISH_NAME_INFO b
on a.FISH_TYPE = b.FISH_TYPE
order by a.ID;



# left join FISH_NAME_INFO n
# on f.FISH_TYPE = n.FISH_TYPE