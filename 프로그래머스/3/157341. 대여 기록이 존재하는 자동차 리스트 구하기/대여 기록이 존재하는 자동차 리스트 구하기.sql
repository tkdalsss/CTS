-- 코드를 입력하세요
SELECT distinct c.car_id
from car_rental_company_car c 
join car_rental_company_rental_history h
on c.CAR_ID = h.CAR_ID
where c.car_type = '세단' and 
h.start_date between '2022-10-01' and '2022-10-31'
order by c.car_id desc;