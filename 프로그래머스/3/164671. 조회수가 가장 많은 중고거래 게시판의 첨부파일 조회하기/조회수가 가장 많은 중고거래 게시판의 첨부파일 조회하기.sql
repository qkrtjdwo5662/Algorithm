# 테이블에서 조회수가 가장 높은 중고거래 게시물
select concat('/home/grep/src/',b.BOARD_ID, '/', f.FILE_ID, f.FILE_NAME, f.FILE_EXT) as FILE_PATH
from USED_GOODS_BOARD b
join USED_GOODS_FILE f
on b.BOARD_ID = f.BOARD_ID
WHERE 
    b.BOARD_ID = (
        SELECT b2.BOARD_ID
        FROM USED_GOODS_BOARD b2
        ORDER BY b2.VIEWS DESC
        LIMIT 1
    )
order by f.FILE_ID desc