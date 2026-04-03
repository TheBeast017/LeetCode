class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length, m = walls.length;

        int[][] rd = new int[n][2];
        for (int i = 0; i < n; i++) {
            rd[i][0] = robots[i];
            rd[i][1] = distance[i];
        }
        Arrays.sort(rd, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(walls);

        int[] r = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = rd[i][0];
            d[i] = rd[i][1];
        }

        int base = 0;
        for (int x : r) {
            if (contains(walls, x)) base++;
        }

        long dpL = countRange(walls, (long) r[0] - d[0], (long) r[0] - 1);
        long dpR = 0;

        for (int i = 0; i < n - 1; i++) {
            long lpos = r[i], rpos = r[i + 1];
            long ld = d[i], rdist = d[i + 1];

            long L1 = lpos + 1;
            long R1 = Math.min(lpos + ld, rpos - 1);
            long a = countRange(walls, L1, R1);

            long L2 = Math.max(lpos + 1, rpos - rdist);
            long R2 = rpos - 1;
            long b = countRange(walls, L2, R2);

            long overlap = countRange(walls, Math.max(L1, L2), Math.min(R1, R2));
            long c = a + b - overlap;

            long ndpL = Math.max(dpL + b, dpR + c);
            long ndpR = Math.max(dpL, dpR + a);

            dpL = ndpL;
            dpR = ndpR;
        }

        long rightEdge = countRange(walls, (long) r[n - 1] + 1, (long) r[n - 1] + d[n - 1]);
        return (int) (base + Math.max(dpL, dpR + rightEdge));
    }

    private long countRange(int[] walls, long left, long right) {
        if (left > right) return 0;
        int l = lowerBound(walls, left);
        int r = upperBound(walls, right);
        return r - l;
    }

    private boolean contains(int[] arr, int target) {
        int idx = Arrays.binarySearch(arr, target);
        return idx >= 0;
    }

    private int lowerBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if ((long) arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private int upperBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if ((long) arr[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
