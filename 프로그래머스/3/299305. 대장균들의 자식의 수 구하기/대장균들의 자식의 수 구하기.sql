-- 코드를 작성해주세요
select d.ID, 
(
    case     
    when A.count is null then 0
    else A.count
    end  
)as 'CHILD_COUNT'
from ECOLI_DATA d
left join 
(
    select PARENT_ID, COUNT(PARENT_ID) as 'count'
    from ECOLI_DATA
    where PARENT_ID is not null
    group by PARENT_ID
) as A
on d.ID = A.PARENT_ID
order by d.ID;