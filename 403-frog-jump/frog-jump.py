class Solution(object):
    def canCross(self, stones):
        """
        :type stones: List[int]
        :rtype: bool
        """
        stone_set = set(stones)
        last = stones[-1]
        dp = {stone: set() for stone in stones}
        dp[0].add(0)
        for stone in stones:
            for k in dp[stone]:
                for jump in [k - 1, k, k + 1]:
                    if jump > 0 and stone + jump in stone_set:
                        dp[stone + jump].add(jump)

        return len(dp[last]) > 0