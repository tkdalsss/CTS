-- 코드를 작성해주세요
select hd.dept_id as dept_id, hd.dept_name_en as dept_name_en, round(avg(he.sal),0) as avg_sal
from hr_department hd join hr_employees he
on hd.dept_id = he.dept_id
group by he.dept_id
order by avg_sal desc;