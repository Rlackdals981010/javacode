SELECT 
    b.USER_ID, 
    b.NICKNAME,
    CONCAT(B.CITY,' ',b.STREET_ADDRESS1, ' ', b.STREET_ADDRESS2) AS FULL_ADDRESS, 
    CONCAT(SUBSTRING(b.TLNO, 1, 3), '-', SUBSTRING(b.TLNO, 4, 4), '-', SUBSTRING(b.TLNO, 8, 4)) AS 전화번호
FROM 
    USED_GOODS_BOARD a 
INNER JOIN 
    USED_GOODS_USER b 
ON  
    a.WRITER_ID = b.USER_ID
GROUP BY 
    b.USER_ID    
HAVING 
    COUNT(*) >= 3
order by b.USER_ID desc