-- 코드를 작성해주세요
select a.ID,
case
    when b.per <= 0.25 then 'CRITICAL'
    when b.per <= 0.5 then 'HIGH'
    when b.per <= 0.75 then 'MEDIUM'
    else 'LOW'
end as COLONY_NAME
from ECOLI_DATA a
left join
(
SELECT ID, PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY desc) AS per
FROM ECOLI_DATA
) as b
on a.ID = b.ID