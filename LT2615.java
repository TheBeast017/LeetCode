int n = nums.length;
        long[] res = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        for (List<Integer> list : map.values()) {
            int m = list.size();
            long[] prefix = new long[m + 1];
            
            for (int i = 0; i < m; i++) {
                prefix[i + 1] = prefix[i] + list.get(i);
            }
            
            for (int i = 0; i < m; i++) {
                int idx = list.get(i);
                long left = (long) idx * i - prefix[i];
                long right = (prefix[m] - prefix[i + 1]) - (long) idx * (m - i - 1);
                res[idx] = left + right;
            }
        }
        
        return res;
