-- 코드를 작성해주세요
select count(*) fish_count
from (select id, fish_type,
     case when length <= 10 then null else length end as length,
     `time` from fish_info) fi join fish_name_info fni
     on fi.fish_type = fni.fish_type
where fni.fish_name in ('bass', 'snapper');