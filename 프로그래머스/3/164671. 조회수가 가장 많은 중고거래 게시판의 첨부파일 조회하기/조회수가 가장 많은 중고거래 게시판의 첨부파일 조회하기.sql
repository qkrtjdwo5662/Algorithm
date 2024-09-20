select concat('/home/grep/src/', a.BOARD_ID, '/', b.FILE_ID, b.FILE_NAME, b.FILE_EXT) as FILE_PATH
from USED_GOODS_BOARD a
join USED_GOODS_FILE b
on a.BOARD_ID = b.BOARD_ID
where 
    a.BOARD_ID = (
        select BOARD_ID 
        from USED_GOODS_BOARD 
        ORDER BY VIEWS DESC 
        LIMIT 1
    )
    
order by b.FILE_ID desc;