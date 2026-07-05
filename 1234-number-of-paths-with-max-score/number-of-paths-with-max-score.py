class Solution(object):
    def pathsWithMaxScore(self, board):
        MOD = 10**9 + 7
        n = len(board)
        dp = [[(-1, 0) for _ in range(n)] for _ in range(n)]
        dp[n - 1][n - 1] = (0, 1)

        for i in range(n - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if board[i][j] == 'X' or (i == n - 1 and j == n - 1):
                    continue
                best = -1
                ways = 0
                for x, y in ((i + 1, j), (i, j + 1), (i + 1, j + 1)):
                    if x < n and y < n:
                        s, c = dp[x][y]
                        if s > best:
                            best = s
                            ways = c
                        elif s == best and s != -1:
                            ways = (ways + c) % MOD
                if best == -1:
                    continue
                val = 0 if board[i][j] == 'E' else int(board[i][j])
                dp[i][j] = (best + val, ways)

        score, ways = dp[0][0]
        return [0, 0] if score == -1 else [score, ways]

        