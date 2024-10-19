-- 코드를 입력하세요
# SELECT HOUR(DATETIME) as HOUR, COUNT(HOUR(DATETIME)) as COUNT
# from ANIMAL_OUTS
# group by HOUR
# order by HOUR

# set @hour := -1;

# select (@hour := @hour + 1) as HOUR, (
#     select count(*)
#     from ANIMAL_OUTS
#     where HOUR(DATETIME) = @hour) as COUNT

# from ANIMAL_OUTS
# WHERE @hour < 23;

set @hour := -1;

select (@hour := @hour + 1) as HOUR, (
    select count(*)
    from ANIMAL_OUTS
    where HOUR(DATETIME) = @hour
) as count
from ANIMAL_OUTS
where @hour < 23;