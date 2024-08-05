# 부서별 평균 연봉을 조회
select e.dept_id, d.DEPT_NAME_EN , round(avg(e.SAL), 0) as AVG_SAL
from HR_EMPLOYEES e
join HR_DEPARTMENT d
on e.dept_id = d.dept_id
group by e.dept_id
order by AVG_SAL desc;