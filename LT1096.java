class Solution {
    private int i;

    public List<String> braceExpansionII(String expression) {
        i = 0;
        Set<String> result = parse(expression);
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> parse(String s) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (i < s.length() && s.charAt(i) != '}') {
            char c = s.charAt(i);

            if (c == ',') {
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                i++;
            } else {
                Set<String> next;

                if (c == '{') {
                    i++;
                    next = parse(s);
                    i++;
                } else {
                    next = new HashSet<>();
                    next.add(String.valueOf(c));
                    i++;
                }

                Set<String> combined = new HashSet<>();
                for (String a : current) {
                    for (String b : next) {
                        combined.add(a + b);
                    }
                }
                current = combined;
            }
        }

        result.addAll(current);
        return result;
    }
}
