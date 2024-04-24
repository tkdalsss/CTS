-- 코드를 작성해주세요
select distinct(a.item_id), item_name, rarity
from item_info a left join item_tree b
on a.item_id = b.parent_item_id
where b.item_id is null
order by a.item_id desc;