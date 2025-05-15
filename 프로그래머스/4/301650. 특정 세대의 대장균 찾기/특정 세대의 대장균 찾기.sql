-- 코드를 작성해주세요
# 1세대, 2세대, 3세대

select a.ID
from ECOLI_DATA a
join ECOLI_DATA b
on a.PARENT_ID = b.ID
join ECOLI_DATA c
on b.PARENT_ID = c.ID
where c.PARENT_ID is null