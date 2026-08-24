class Solution {
    static class Node {
        int left, right;
        int prefix, suffix, best;
        char lc, rc;

        Node(int left, int right, char c) {
            this.left = left;
            this.right = right;
            this.prefix = this.suffix = this.best = right - left + 1;
            this.lc = this.rc = c;
        }
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        this.s = s.toCharArray();

        int n = s.length();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            int pos = queryIndices[i];
            char c = queryCharacters.charAt(i);

            update(1, 0, n - 1, pos, c);
            ans[i] = tree[1].best;
        }

        return ans;
    }

    void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = new Node(l, r, s[l]);
            return;
        }

        int mid = (l + r) >>> 1;

        build(node << 1, l, mid);
        build(node << 1 | 1, mid + 1, r);

        tree[node] = merge(tree[node << 1], tree[node << 1 | 1]);
    }

    void update(int node, int l, int r, int pos, char c) {
        if (l == r) {
            s[pos] = c;
            tree[node] = new Node(l, r, c);
            return;
        }

        int mid = (l + r) >>> 1;

        if (pos <= mid) {
            update(node << 1, l, mid, pos, c);
        } else {
            update(node << 1 | 1, mid + 1, r, pos, c);
        }

        tree[node] = merge(tree[node << 1], tree[node << 1 | 1]);
    }

    Node merge(Node a, Node b) {
        Node res = new Node(a.left, b.right, a.lc);

        res.lc = a.lc;
        res.rc = b.rc;

        res.prefix = a.prefix;
        if (a.prefix == a.right - a.left + 1 && a.rc == b.lc) {
            res.prefix += b.prefix;
        }

        res.suffix = b.suffix;
        if (b.suffix == b.right - b.left + 1 && a.rc == b.lc) {
            res.suffix += a.suffix;
        }

        res.best = Math.max(a.best, b.best);

        if (a.rc == b.lc) {
            res.best = Math.max(res.best, a.suffix + b.prefix);
        }

        return res;
    }
}
