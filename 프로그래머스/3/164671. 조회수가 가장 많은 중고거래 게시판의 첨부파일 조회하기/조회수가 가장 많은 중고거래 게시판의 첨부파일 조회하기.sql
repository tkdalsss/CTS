-- 코드를 입력하세요
SELECT concat('/home/grep/src/', file.board_id, '/', file_id, file_name, file_ext) as file_path
from used_goods_file file left join used_goods_board as board
on file.board_id = board.board_id
where views = (select max(views) from used_goods_board)
order by file_id desc;