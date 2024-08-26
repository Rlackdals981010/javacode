SELECT
    a.machine_id,
    round(AVG(b.timestamp - a.timestamp), 3) AS     processing_time
FROM
    Activity a inner JOIN  Activity b
                           ON  a.machine_id = b.machine_id
                               and a.process_id = b.process_id
                               and a.timestamp < b.timestamp
GROUP BY a.machine_id
ORDER BY a.machine_id