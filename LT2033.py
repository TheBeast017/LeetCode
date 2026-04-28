class Solution(object):
    def minOperations(self, grid, x):
        arr = [num for row in grid for num in row]
        r = arr[0] % x
        for num in arr:
            if num % x != r:
                return -1
        arr.sort()
        median = arr[len(arr) // 2]
        return sum(abs(num - median) // x for num in arr)
