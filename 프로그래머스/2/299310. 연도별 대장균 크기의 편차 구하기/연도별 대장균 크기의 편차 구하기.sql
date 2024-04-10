-- 코드를 작성해주세요
with year_max as(select max(size_of_colony) as ym, year(differentiation_date) as `year`
from ecoli_data
group by year(differentiation_date))

select year(differentiation_date) as `year`, 
(ym.ym - size_of_colony) as year_dev, ed.id
from ecoli_data ed join year_max ym on year(ed.differentiation_date) = ym.year
order by `year`, year_dev;
