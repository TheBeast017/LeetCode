class BIT:
    def __init__(self, n):
        self.bit = [0] * (n + 1)

    def add(self, i):
        while i < len(self.bit):
            self.bit[i] += 1
            i += i & -i

    def query(self, i):
        s = 0
        while i:
            s += self.bit[i]
            i -= i & -i
        return s

class Solution(object):
    def countMajoritySubarrays(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        pref = [0]
        for x in nums:
            pref.append(pref[-1] + (1 if x == target else -1))

        vals = sorted(set(pref))
        bit = BIT(len(vals))
        ans = 0

        for x in pref:
            i = bisect_left(vals, x) + 1
            ans += bit.query(i - 1)
            bit.add(i)

        return ans