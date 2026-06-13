class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            int j = 0, sum = 0;
            while(j < words[i].length()){
                sum += weights[words[i].charAt(j++) - 97];
            }
            sb.append((char)(26+96-(sum%26)));
        }
        return sb.toString();
    }
}