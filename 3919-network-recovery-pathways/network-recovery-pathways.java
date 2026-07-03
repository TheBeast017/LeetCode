class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        ArrayList<int[]>[] g = new ArrayList[n];
        int[] indeg = new int[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        int maxCost = 0;
        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], e[2]});
            indeg[e[1]]++;
            maxCost = Math.max(maxCost, e[2]);
        }

        int[] topo = new int[n];
        int idx = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;
            for (int[] e : g[u]) {
                if (--indeg[e[0]] == 0) q.offer(e[0]);
            }
        }

        int lo = 0, hi = maxCost, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long[] dist = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[0] = 0;
            for (int u : topo) {
                if (dist[u] == Long.MAX_VALUE) continue;
                if (u != 0 && u != n - 1 && !online[u]) continue;
                for (int[] e : g[u]) {
                    int v = e[0], w = e[1];
                    if (w < mid) continue;
                    if (v != n - 1 && !online[v]) continue;
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
            if (dist[n - 1] <= k) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}