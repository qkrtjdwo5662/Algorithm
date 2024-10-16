-- 코드를 입력하세요
SELECT a.APNT_NO, b.PT_NAME, b.PT_NO, a.MCDP_CD, c.DR_NAME, a.APNT_YMD
from APPOINTMENT a
left join PATIENT b
on a.PT_NO = b.PT_NO
left join DOCTOR c
on a.MDDR_ID = c.DR_ID
where YEAR(a.APNT_YMD) = 2022 and MONTH(a.APNT_YMD) = 4 and DAY(a.APNT_YMD) = 13 and a.APNT_CNCL_YN = 'N'
order by a.APNT_YMD;

