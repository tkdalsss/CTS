-- 코드를 작성해주세요
select concat(quarter, 'Q') as quarter, count(*) as ecoli_count
from ecoli_data ed join 
(select id, 
 case 
 when month(differentiation_date) between 1 and 3 then 1
 when month(differentiation_date) between 4 and 6 then 2
 when month(differentiation_date) between 7 and 9 then 3
 else 4
 end as quarter
    from ecoli_data) eq on ed.id = eq.id
group by quarter
order by quarter;