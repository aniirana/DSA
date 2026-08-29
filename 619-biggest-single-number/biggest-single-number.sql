# Write your MySQL query statement below
select MAX(num) as num
from(
    select num
    from mynumbers
    group by num
    having COUNT(*)=1
) t 
