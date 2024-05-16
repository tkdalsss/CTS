-- 코드를 입력하세요
select ugu.user_id, ugu.nickname, sum(ugb.price) as total_sales
from used_goods_board ugb join used_goods_user ugu on ugb.writer_id = ugu.user_id
where ugb.status = 'DONE'
group by ugu.user_id
having sum(ugb.price) >= 700000
order by total_sales;