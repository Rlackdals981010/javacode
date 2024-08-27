select name, bonus
from Employee e left join Bonus b on e.empId = b.empId
where bonus is NULL or bonus < 1000