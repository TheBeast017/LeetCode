SELECT IF(id % 2 = 1 AND id < (SELECT MAX(id) FROM Seat), id + 1, IF(id % 2 = 0, id - 1, id)) AS id, student FROM Seat ORDER BY id;
