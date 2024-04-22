-- 코드를 

select ID, 
    (case when SIZE_OF_COLONY <= 1000 and SIZE_OF_COLONY > 100 then 'MEDIUM'
         when SIZE_OF_COLONY > 1000 then 'HIGH'
         else 'LOW'
    end) as SIZE
from ECOLI_DATA
order by ID