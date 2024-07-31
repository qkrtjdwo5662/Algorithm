select u.USER_ID, u.NICKNAME, CONCAT(u.CITY, " ", u.STREET_ADDRESS1, " ", u.STREET_ADDRESS2) as 전체주소, 
    CONCAT(SUBSTR(TLNO, 1, 3), '-', SUBSTR(TLNO, 4, 4), '-', SUBSTR(TLNO, 8)) as 전화번호
from USED_GOODS_BOARD b
join USED_GOODS_USER u
on b.WRITER_ID = u.USER_ID
group by b.WRITER_ID
having count(b.WRITER_ID) >= 3
order by u.USER_ID desc;
# 테이블에서 중고 거래 게시물을 3건 이상 등록한 
# 사용자의 사용자 ID, 닉네임, 전체주소, 전화번호를 조회하는 SQL문