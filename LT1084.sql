# Write your MySQL query statement below
SELECT p.product_id, p.product_name
FROM Product p
RIGHT JOIN Sales s 
ON p.product_id = s.Product_id
GROUP BY p.product_id, p.product_name
HAVING 
    MIN(s.sale_date) >= '2019-01-01'
    AND MAX(s.sale_date) <= '2019-03-31';
