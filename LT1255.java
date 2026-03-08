class Solution{
    public int maxScoreWords(String[] words,char[] letters,int[] score){
        int n=words.length;
        int[] cnt=new int[26];
        for(char c:letters)cnt[c-'a']++;
        int ans=0;
        for(int mask=0;mask<(1<<n);mask++){
            int[] used=new int[26];
            int cur=0;
            boolean ok=true;
            for(int i=0;i<n;i++){
                if((mask&(1<<i))!=0){
                    for(char c:words[i].toCharArray()){
                        int idx=c-'a';
                        used[idx]++;
                        if(used[idx]>cnt[idx])ok=false;
                        cur+=score[idx];
                    }
                }
            }
            if(ok) ans=Math.max(ans,cur);
        }
        return ans;
    }
}
