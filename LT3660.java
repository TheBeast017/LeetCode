class Solution {
    private int[] parent, rnk, maxVal;

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return;
        if (rnk[px] < rnk[py]) { int t = px; px = py; py = t; }
        parent[py] = px;
        if (rnk[px] == rnk[py]) rnk[px]++;
        maxVal[px] = Math.max(maxVal[px], maxVal[py]);
    }

    public int[] maxValue(int[] nums) {
        int n = nums.length;
        parent = new int[n];
        rnk   = new int[n];
        maxVal = new int[n];
        for (int i = 0; i < n; i++) { parent[i] = i; maxVal[i] = nums[i]; }

        int[] stackRep = new int[n];
        int[] stackMin = new int[n];
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {
            int newMin = nums[i];
            while (top >= 0 && stackMin[top] < nums[i]) {
                union(i, stackRep[top]);
                newMin = Math.min(newMin, stackMin[top]);
                top--;
            }
            stackRep[++top] = find(i);
            stackMin[top]   = newMin;
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = maxVal[find(i)];
        return ans;
    }
}
