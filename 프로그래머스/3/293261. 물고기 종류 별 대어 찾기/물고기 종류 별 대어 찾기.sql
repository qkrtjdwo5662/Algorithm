

select a.ID, c.FISH_NAME, a.LENGTH
from FISH_INFO a
join (
select MAX(LENGTH) as LENGTH, FISH_TYPE
from FISH_INFO 
group by FISH_TYPE) as b
on a.LENGTH = b.LENGTH and a.FISH_TYPE = b.FISH_TYPE
join FISH_NAME_INFO c
on a.FISH_TYPE = c.FISH_TYPE
order by a.ID;


