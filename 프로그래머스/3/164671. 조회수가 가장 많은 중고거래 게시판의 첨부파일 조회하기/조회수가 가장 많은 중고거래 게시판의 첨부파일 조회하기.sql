SELECT 
    CONCAT('/home/grep/src/', uf.BOARD_ID, '/', uf.FILE_ID, uf.FILE_NAME, uf.FILE_EXT) AS FILE_PATH
FROM 
    USED_GOODS_BOARD ub 
    INNER JOIN USED_GOODS_FILE uf ON ub.BOARD_ID = uf.BOARD_ID
WHERE 
    ub.BOARD_ID = (SELECT BOARD_ID 
                   FROM USED_GOODS_BOARD 
                   ORDER BY VIEWS DESC 
                   LIMIT 1)
ORDER BY 
    FILE_PATH desc;