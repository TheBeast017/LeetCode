class Solution {
    public int numberOfSubstrings(String s) {
        // boolean a = false, b = false, c = false;
        // int ans = 0, n = s.length();
        // for(int i = 0; i < n; i++){
        //     int j = i;
        //     while(j < n){
        //         char ch = s.charAt(j);
        //         if(ch == 'a') a = true;
        //         else if(ch == 'b') b = true;
        //         else if(ch == 'c') c = true;
        //         if(a == true && b == true && c == true){
        //             ans += ((n - i) - (j - i));//  4, 
        //             break;
        //         }
        //         j++;
        //     }
        //     a = false;
        //     b = false;
        //     c = false;
            
        // }
        // return ans;
        int n = s.length();
        int[] isChar = {-1, -1, -1};
        int ans = 0;
        for(int i = 0; i < n; i++){
            isChar[s.charAt(i) - 'a'] = i;
            ans += Math.min(isChar[0], Math.min(isChar[1], isChar[2])) + 1;
        }

        return ans;
    }
}