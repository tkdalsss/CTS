-- 코드를 작성해주세요
select ed.id, 
case when tmp.cc is null then 0
else tmp.cc
end as child_count
from ecoli_data ed left join (select parent_id, count(*) as cc from ecoli_data  group by parent_id) tmp
on ed.id = tmp.parent_id
order by ed.id;