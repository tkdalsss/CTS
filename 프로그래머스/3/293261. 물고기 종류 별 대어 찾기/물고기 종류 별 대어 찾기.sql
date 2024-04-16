-- 코드를 입력해 주세요
with max_length as (
    select a.fish_type as fish_type, length, fish_name
    from (select fi.fish_type, max(length) as length
        from fish_info fi
        group by fi.fish_type) a 
    join fish_name_info fni
    on a.fish_type = fni.fish_type
)

select fi.id, ml.fish_name, ml.length
from fish_info fi join max_length ml 
on fi.fish_type = ml.fish_type
where fi.length = ml.length;