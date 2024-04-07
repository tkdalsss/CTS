-- 코드를 입력하세요
select food_type, rest_id, rest_name, favorites
from rest_info
where (food_type, favorites)
in (
    select food_type, max(favorites) as favorites
    from rest_info
    group by food_type
)
order by food_type desc;
# 첫 번째 쿼리는 각 음식 유형에 대해 최대 FAVORITES 값을 가진 하나의 레스토랑만 반환하는 반면, 
# 두 번째 쿼리는 각 음식 유형에 대해 여러 레스토랑의 레코드를 반환할 수 있습니다.
# SELECT food_type, rest_id, rest_name, max(favorites) as favorites
# from rest_info
# group by food_type
# order by food_type desc;
