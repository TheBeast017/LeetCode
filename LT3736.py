class Solution:
    def minMoves(self, nums: List[int]) -> int:
        mx = max(nums)
        moves = 0
        for x in nums:
            moves += mx - x
        return moves
