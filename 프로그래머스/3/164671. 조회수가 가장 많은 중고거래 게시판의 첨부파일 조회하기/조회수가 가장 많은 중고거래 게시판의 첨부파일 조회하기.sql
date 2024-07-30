select CONCAT("/home/grep/src/", f.BOARD_ID, "/", f.FILE_ID ,f.FILE_NAME, f.FILE_EXT) as FILE_PATH
from 
(
    select BOARD_ID
    from USED_GOODS_BOARD bb
    order by bb.VIEWS desc
    limit 1
) b
join USED_GOODS_FILE f
on b.BOARD_ID = f.BOARD_ID
order by f.FILE_ID desc;

