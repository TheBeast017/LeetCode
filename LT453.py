class Solution:
    def minMoves(self, nums: list[int]) -> int:
        mn = min(nums)
        total = 0
        for x in nums:
            total += x - mn
        return total
