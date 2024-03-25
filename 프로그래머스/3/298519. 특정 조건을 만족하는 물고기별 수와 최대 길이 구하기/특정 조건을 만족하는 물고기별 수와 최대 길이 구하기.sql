-- 코드를 작성해주세요
select count(*) as fish_count, 
max(case when length <= 10 then 10 else length end) as max_length, 
fish_type
from fish_info
group by fish_type
having avg(case when length <= 10 then 10 else length end) >= 33
order by fish_type;
