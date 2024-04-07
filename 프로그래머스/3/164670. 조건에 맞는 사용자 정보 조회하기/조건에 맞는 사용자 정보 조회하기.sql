-- 코드를 입력하세요
SELECT ugu.user_id, ugu.nickname,
concat(ugu.city, ' ', ugu.street_address1, ' ', ugu.street_address2) as 전체주소,
concat(substring(ugu.tlno from 1 for 3), '-', substring(ugu.tlno from 4 for 4),
      '-', substring(ugu.tlno from 8 for 4)) as 전화번호
from used_goods_board ugb
join used_goods_user ugu
on ugb.writer_id = ugu.user_id
group by ugb.writer_id
having count(*) >= 3
order by ugu.user_id desc;