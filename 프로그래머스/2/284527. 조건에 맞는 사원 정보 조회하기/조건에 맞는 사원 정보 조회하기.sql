-- 코드를 작성해주세요
select sum(hg.score) as score, hg.emp_no as emp_no, he.emp_name as emp_name, he.position as position, he.email as email
from hr_employees he join hr_grade hg on he.emp_no = hg.emp_no
where hg.year = '2022'
group by he.emp_no
order by score desc
limit 1;