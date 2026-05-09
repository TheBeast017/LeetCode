SELECT 
    request_at AS Day
    ,ROUND(SUM(CASE WHEN status='cancelled_by_driver' OR status='cancelled_by_client' THEN 1 ELSE 0 END) / COUNT(request_at),2) 
    AS "Cancellation Rate"
FROM  Trips t
JOIN Users c
    ON t.client_id=c.users_id
    AND c.banned='No'
JOIN Users u
    ON t.driver_id=u.users_id
    AND u.banned='No'
WHERE request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY request_at
