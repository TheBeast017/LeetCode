import java.util.*;

class Solution {
    private int[] computeZ(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) z[i] = Math.min(z[i - l], r - i + 1);
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                l = i;
                r = i + z[i];
                z[i]++;
            }
        }
        z[0] = n;
        return z;
    }

    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        char[] word = new char[n + m - 1];
        Arrays.fill(word, '*');

        int[] z = computeZ(str2);
        int prev = -m;

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') continue;
            int overlap = Math.max(0, prev + m - i);
            if (overlap > 0 && z[m - overlap] < overlap) return "";
            for (int j = overlap; j < m; j++) {
                word[i + j] = str2.charAt(j);
            }
            prev = i;
        }

        int[] lastWild = new int[word.length];
        int last = -1;

        for (int i = 0; i < word.length; i++) {
            if (word[i] == '*') {
                word[i] = 'a';
                last = i;
            }
            lastWild[i] = last;
        }

        String combined = str2 + new String(word);
        z = computeZ(combined);

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T' || z[m + i] < m) continue;
            int pos = lastWild[i + m - 1];
            if (pos < i) return "";
            word[pos] = 'b';
            i = pos;
        }

        return new String(word);
    }
}
