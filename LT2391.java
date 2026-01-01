class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] last = new int[3];
        int n = garbage.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (char c : garbage[i].toCharArray()) {
                total++;
                if (c == 'M') last[0] = i;
                else if (c == 'P') last[1] = i;
                else if (c == 'G') last[2] = i;
            }
        }
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + travel[i - 1];
        }
        for (int i = 0; i < 3; i++) {
            total += prefix[last[i]];
        }
        return total;
    }
}