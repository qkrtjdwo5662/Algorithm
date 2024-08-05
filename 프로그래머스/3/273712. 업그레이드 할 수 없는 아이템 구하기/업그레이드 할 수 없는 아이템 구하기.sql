# 우선 더이상 업그레이드 할 수 없는 ITEM_ID -> PARENT_ITEM_ID에 없는 ITEM_ID
SELECT t.ITEM_ID, i.ITEM_NAME ,i.RARITY
FROM ITEM_TREE t
join ITEM_INFO i
on t.ITEM_ID = i.ITEM_ID
WHERE t.ITEM_ID NOT IN (
    SELECT PARENT_ITEM_ID
    FROM ITEM_TREE
    WHERE PARENT_ITEM_ID IS NOT NULL
)
order by t.ITEM_ID desc;

