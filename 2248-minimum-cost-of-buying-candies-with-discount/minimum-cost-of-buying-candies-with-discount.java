class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int j = cost.length - 1;
        int money = 0;
        int times = 1;
        while(j >= 0){
            if (times == 3){
                times = 1;
                j--;
                continue;
            }
            money += cost[j--];
            times++;
        }
        return money;
    }
}