class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        int[] stack = new int[n + 1];
        int top = -1;
        for (int i = 0; i <= n; i++) {
            int height = i == n ? 0 : heights[i];
            while (top != -1 && height < heights[stack[top]]) {
                int h = heights[stack[top--]];
                int w = top == -1 ? i : i - stack[top] - 1;
                max = Math.max(max, h * w);
            }
            stack[++top] = i;
        }
        return max;
    }
}
