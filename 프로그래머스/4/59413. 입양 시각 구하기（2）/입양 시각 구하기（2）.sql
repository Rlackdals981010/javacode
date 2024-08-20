WITH RECURSIVE Hours AS (
    SELECT 0 AS HOUR UNION ALL
    SELECT HOUR+1 FROM Hours
    WHERE HOUR<23
)
SELECT
    H.HOUR,
    COALESCE(COUNT(A.DATETIME), 0) AS COUNT
FROM
    Hours H
LEFT JOIN
    ANIMAL_OUTS A ON HOUR(A.DATETIME) = H.HOUR
GROUP BY
    H.HOUR
ORDER BY
    H.HOUR;