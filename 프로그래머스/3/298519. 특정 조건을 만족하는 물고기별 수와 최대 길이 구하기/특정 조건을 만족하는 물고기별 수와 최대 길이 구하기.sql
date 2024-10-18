# -- 코드를 작성해주세요
select count(aa.ID) as FISH_COUNT, MAX(aa.LENGTH) as MAX_LENGTH, FISH_TYPE
from 
    (
        select ID, FISH_TYPE, 
        case
            when LENGTH is null then 10 
            else LENGTH
        end as LENGTH
        from FISH_INFO
    ) as aa
group by FISH_TYPE
having avg(LENGTH) >= 33
order by FISH_TYPE
    

