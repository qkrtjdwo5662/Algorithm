-- 코드를 작성해주세요
select a.ID, 
case 
    when b.count is not null then b.count
    else 0
end as CHILD_COUNT
from ECOLI_DATA a
left join (
select PARENT_ID, count(PARENT_ID) as count
from ECOLI_DATA
where PARENT_ID is not null
group by PARENT_ID) as b
on a.ID = b.PARENT_ID
order by a.ID