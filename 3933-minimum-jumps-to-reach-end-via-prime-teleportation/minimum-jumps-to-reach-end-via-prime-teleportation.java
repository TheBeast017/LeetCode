class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int f : getPrimes(nums[i])) {
                mp.computeIfAbsent(f, k -> new ArrayList<>()).add(i);
            }
        }

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        boolean[] usedPrime = new boolean[1000001];

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int i = q.poll();

                if (i == n - 1) return steps;

                if (i - 1 >= 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.add(i - 1);
                }

                if (i + 1 < n && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.add(i + 1);
                }

                int val = nums[i];

                if (isPrime(val) && !usedPrime[val]) {

                    usedPrime[val] = true;

                    List<Integer> list = mp.get(val);

                    if (list != null) {
                        for (int idx : list) {
                            if (!vis[idx]) {
                                vis[idx] = true;
                                q.add(idx);
                            }
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    boolean isPrime(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0) return false;
        return true;
    }

    List<Integer> getPrimes(int x) {
        List<Integer> res = new ArrayList<>();

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0 && isPrime(i)) res.add(i);
            if (x % (x / i) == 0 && isPrime(x / i)) res.add(x / i);
        }

        if (isPrime(x)) res.add(x);

        return res;
    }
}