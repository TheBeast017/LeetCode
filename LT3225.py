class Solution(object):
    def maximumScore(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        n = len(grid)
        prefix = [[0] * (n + 1) for _ in range(n)]
        for j in range(n):
            for i in range(n):
                prefix[j][i+1] = prefix[j][i] + grid[i][j]
        
        NEG_INF = float('-inf')
        dp = [[NEG_INF] * (n + 1) for _ in range(n + 1)]
        for h in range(n + 1):
            dp[0][h] = 0
        
        for j in range(n - 1):
            new_dp = [[NEG_INF] * (n + 1) for _ in range(n + 1)]
            for h_cur in range(n + 1):
                vals = [dp[h_prev][h_cur] for h_prev in range(n + 1)]
                total_max = max(vals)
                if total_max == NEG_INF:
                    continue
                max_le = NEG_INF
                for k in range(h_cur + 1):
                    if vals[k] > max_le:
                        max_le = vals[k]
                suffix_max = [NEG_INF] * (n + 2)
                for k in range(n, -1, -1):
                    suffix_max[k] = max(suffix_max[k + 1], vals[k])
                for h_next in range(h_cur + 1):
                    lc = prefix[j+1][h_cur] - prefix[j+1][h_next]
                    val = total_max + lc
                    if val > new_dp[h_cur][h_next]:
                        new_dp[h_cur][h_next] = val
                running_max_2 = NEG_INF
                for h_next in range(h_cur + 1, n + 1):
                    hp = h_next - 1
                    if hp > h_cur and vals[hp] != NEG_INF:
                        v = vals[hp] - prefix[j][hp]
                        if v > running_max_2:
                            running_max_2 = v
                    best = NEG_INF
                    if max_le != NEG_INF:
                        c1 = max_le + prefix[j][h_next] - prefix[j][h_cur]
                        if c1 > best:
                            best = c1
                    if running_max_2 != NEG_INF:
                        c2 = prefix[j][h_next] + running_max_2
                        if c2 > best:
                            best = c2
                    if suffix_max[h_next] > best:
                        best = suffix_max[h_next]
                    if best > new_dp[h_cur][h_next]:
                        new_dp[h_cur][h_next] = best
            dp = new_dp
        
        result = 0
        for h_prev in range(n + 1):
            for h_cur in range(n + 1):
                if dp[h_prev][h_cur] > result:
                    result = dp[h_prev][h_cur]
        return result
