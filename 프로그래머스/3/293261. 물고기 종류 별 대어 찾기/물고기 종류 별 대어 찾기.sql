# SELECT fi.ID, ninfo.FISH_NAME ,fi.LENGTH
# FROM FISH_INFO fi
# join FISH_NAME_INFO ninfo
# on fi.FISH_TYPE = ninfo.FISH_TYPE
# WHERE fi.LENGTH =(
#     SELECT MAX(LENGTH)
#     FROM FISH_INFO
#     WHERE FISH_TYPE = fi.FISH_TYPE
# )


select i.ID, ni.FISH_NAME, i.LENGTH
from FISH_INFO i
join FISH_NAME_INFO ni
on i.FISH_TYPE = ni.FISH_TYPE
where i.LENGTH in 
(
    select MAX(LENGTH)
    from FISH_INFO
    where FISH_TYPE = i.FISH_TYPE
)
