SELECT name, balance
FROM (
    SELECT u.name, SUM(t.amount) AS balance
    FROM Users u
    JOIN Transactions t
    ON u.account = t.account
    GROUP BY u.account, u.name
) temp
WHERE balance > 10000;
