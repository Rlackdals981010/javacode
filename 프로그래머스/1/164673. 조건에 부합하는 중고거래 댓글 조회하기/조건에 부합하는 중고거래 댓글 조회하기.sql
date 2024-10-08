-- 코드를 입력하세요
SELECT gb.TITLE, gr.BOARD_ID, gr.REPLY_ID, gr.WRITER_ID, gr.CONTENTS, Date_FORMAT(gr.CREATED_DATE,'%Y-%m-%d')CREATED_DATE
from USED_GOODS_BOARD gb inner join USED_GOODS_REPLY gr on gb.BOARD_ID = gr.BOARD_ID
where Year(gb.CREATED_DATE) = 2022 and Month(gb.CREATED_DATE) = 10
order by gr.CREATED_DATE, gb.TITLE