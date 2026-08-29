# Write your MySQL query statement below
select customer_number 
from (
    select customer_number, RANK() OVER(
        order by COUNT(*) desc 
    ) as rnk
    from orders
    group by customer_number
) t
where rnk=1