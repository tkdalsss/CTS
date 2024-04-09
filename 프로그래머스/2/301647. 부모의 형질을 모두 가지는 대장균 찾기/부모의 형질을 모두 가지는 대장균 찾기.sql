-- 코드를 작성해주세요
# 부모의 형질 -> 자신의 형질 비교
select ed1.id, ed1.genotype as genotype, ed2.genotype as parent_genotype
from ecoli_data ed1
join ecoli_data ed2
on ed1.parent_id = ed2.id
where ed1.genotype - ed2.genotype = ed1.genotype ^ ed2.genotype
order by id;