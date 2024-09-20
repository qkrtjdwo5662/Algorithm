select ID, 
    (
        case
        when rank() over (order by SIZE_OF_COLONY desc) <= (select count(*) from ECOLI_DATA) * 1/4 then 'CRITICAL'
        when rank() over (order by SIZE_OF_COLONY desc) <= (select count(*) from ECOLI_DATA) * 2/4 then 'HIGH'
        when rank() over (order by SIZE_OF_COLONY desc) <= (select count(*) from ECOLI_DATA) * 3/4 then 'MEDIUM'
        else 'LOW'
        end
    )as COLONY_NAME
from ECOLI_DATA
order by ID;
