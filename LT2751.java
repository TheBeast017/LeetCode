class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] order = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        
        Arrays.sort(order, (a, b) -> Integer.compare(positions[a], positions[b]));
        
        int[] h = healths.clone();
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int idx : order) {
            if (directions.charAt(idx) == 'R') {
                stack.push(idx);
            } else {
                while (!stack.isEmpty() && h[idx] > 0) {
                    int j = stack.peek();
                    
                    if (h[j] < h[idx]) {
                        stack.pop();
                        h[idx]--;
                        h[j] = 0;
                    } else if (h[j] == h[idx]) {
                        stack.pop();
                        h[j] = 0;
                        h[idx] = 0;
                    } else {
                        h[j]--;
                        h[idx] = 0;
                    }
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (h[i] > 0) {
                ans.add(h[i]);
            }
        }
        
        return ans;
    }
}
