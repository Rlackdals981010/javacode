# Write your MySQL query statement below
select today.id
from Weather yesterday inner join Weather today on DATE_ADD(yesterday.recordDate, INTERVAL 1 DAY) = today.recordDate
where yesterday.temperature<today.temperature