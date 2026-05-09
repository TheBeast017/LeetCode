SELECT query_name, 
    ROUND(SUM(quality) / COUNT(*), 2) AS quality, 
    ROUND(SUM(is_poor) * 100 / COUNT(*), 2) AS poor_query_percentage
FROM (
    SELECT query_name, 
        rating / position AS quality, 
        CASE WHEN rating < 3 THEN 1 ELSE 0 END AS is_poor
    FROM Queries
) AS new
GROUP BY query_name;