-- 코드를 작성해주세요
# select count(*) as fish_count, 
# max(case when length <= 10 then 10 else length end) as max_length, 
# fish_type
# from fish_info
# group by fish_type
# having avg(case when length <= 10 then 10 else length end) >= 33
# order by fish_type;
select count(*) as fish_count,
max(fi.length) as max_length,
fish_type
from (select id, fish_type, 
     case when length <= 10 then 10 else length end as length,
     `time` from fish_info) fi
group by fi.fish_type
having avg(fi.length) >= 33
order by fi.fish_type;