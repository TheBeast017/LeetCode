class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] a = {s1.charAt(0), s1.charAt(2)};
        char[] b = {s2.charAt(0), s2.charAt(2)};
        Arrays.sort(a);
        Arrays.sort(b);

        char[] c = {s1.charAt(1), s1.charAt(3)};
        char[] d = {s2.charAt(1), s2.charAt(3)};
        Arrays.sort(c);
        Arrays.sort(d);

        return Arrays.equals(a, b) && Arrays.equals(c, d);
    }
}
