class Fenwick:
    def __init__(self, n):
        self.n = n
        self.bit = [0] * (n + 1)

    def update(self, i, val):
        while i <= self.n:
            self.bit[i] += val
            i += i & -i

    def query(self, i):
        res = 0
        while i:
            res += self.bit[i]
            i -= i & -i
        return res


class Solution:
    def minOperations(self, nums, x, k):
        n = len(nums)

        vals = sorted(set(nums))
        mp = {v: i + 1 for i, v in enumerate(vals)}

        bit = Fenwick(len(vals))
        sl = SortedList()

        cost = [0] * (n - x + 1)
        total = 0
        left = 0

        for right in range(n):
            v = nums[right]
            idx = mp[v]

            sl.add(v)
            bit.update(idx, v)
            total += v

            if right - left + 1 > x:
                v = nums[left]
                sl.remove(v)
                bit.update(mp[v], -v)
                total -= v
                left += 1

            if right - left + 1 == x:
                mid = sl[x // 2]
                idx = mp[mid]

                cnt = bit_count = x // 2

                left_sum = bit.query(idx - 1)
                right_sum = total - left_sum - mid

                left_count = idx_count = sl.bisect_left(mid)
                right_count = x - left_count - 1

                cost[left] = (
                    mid * left_count - left_sum
                    + (total - left_sum - mid)
                    - mid * right_count
                )

        dp = [[inf] * (k + 1) for _ in range(n + 1)]

        for i in range(n + 1):
            dp[i][0] = 0

        for j in range(1, k + 1):
            for i in range(j * x, n + 1):
                dp[i][j] = min(
                    dp[i - 1][j],
                    dp[i - x][j - 1] + cost[i - x]
                )

        return dp[n][k]
