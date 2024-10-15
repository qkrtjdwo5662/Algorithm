-- 코드를 작성해주세요
select a.ITEM_ID,
c.ITEM_NAME, c.RARITY
from ITEM_TREE a
left join (
select PARENT_ITEM_ID, count(PARENT_ITEM_ID) as COUNT
from ITEM_TREE
where PARENT_ITEM_ID is not null
group by PARENT_ITEM_ID
) as b
on a.ITEM_ID = b.PARENT_ITEM_ID
left join ITEM_INFO c
on c.ITEM_ID = a.ITEM_ID
where b.COUNT is null
order by ITEM_ID desc;

