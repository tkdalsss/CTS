-- 코드를 작성해주세요
# with percentage as (
#     select id, 
#     ntile(4) over(order by size_of_colony desc) as size_group 
#     from ecoli_data
# )

# select ed.id, tmp.colony_name
# from ecoli_data ed
# join (select id, 
#  case 
#  when size_group = 1 then 'critical'
#  when size_group = 2 then 'HIGH'
#  when size_group = 3 then 'MEDIUM'
#  when size_group = 4 then 'LOW' 
#  end as colony_name
# from  percentage) tmp
# on ed.id = tmp.id
# order by ed.id;

with percentage as (
    select id, percent_rank() over(order by size_of_colony desc) as pr
      from ecoli_data
)

select ed.id, 
case 
when p.pr<=0.25 then 'CRITICAL'
when p.pr<=0.5 then 'HIGH'
when p.pr<=0.75then 'MEDIUM'
else 'LOW'
end as colony_name
from ecoli_data ed 
join percentage p 
on ed.id = p.id
order by p.id;