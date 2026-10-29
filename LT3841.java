class Solution:
    def palindromePath(self, n, edges, s, queries):
        from collections import deque

        graph = [[] for _ in range(n)]
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        LOG = n.bit_length()
        parent = [[0] * LOG for _ in range(n)]
        depth = [0] * n
        tin = [0] * n
        tout = [0] * n
        timer = 0

        stack = [(0, -1, 0)]

        while stack:
            u, p, state = stack.pop()

            if state == 0:
                parent[u][0] = max(p, 0)
                tin[u] = timer + 1
                timer += 1

                stack.append((u, p, 1))

                for v in reversed(graph[u]):
                    if v != p:
                        depth[v] = depth[u] + 1
                        stack.append((v, u, 0))
            else:
                tout[u] = timer

        for j in range(1, LOG):
            for u in range(n):
                parent[u][j] = parent[parent[u][j - 1]][j - 1]

        def lca(u, v):
            if depth[u] < depth[v]:
                u, v = v, u

            diff = depth[u] - depth[v]
            j = 0

            while diff:
                if diff & 1:
                    u = parent[u][j]
                diff >>= 1
                j += 1

            if u == v:
                return u

            for j in range(LOG - 1, -1, -1):
                if parent[u][j] != parent[v][j]:
                    u = parent[u][j]
                    v = parent[v][j]

            return parent[u][0]

        bit = [0] * (n + 1)
        chars = list(s)

        def update(i, val):
            while i <= n:
                bit[i] ^= val
                i += i & -i

        def prefix(i):
            res = 0
            while i > 0:
                res ^= bit[i]
                i -= i & -i
            return res

        for u in range(n):
            val = 1 << (ord(chars[u]) - ord('a'))
            update(tin[u], val)
            if tout[u] < n:
                update(tout[u] + 1, val)

        ans = []

        for q in queries:
            parts = q.split()
            u = int(parts[1])

            if parts[0] == "update":
                c = parts[2]

                if chars[u] != c:
                    delta = (1 << (ord(chars[u]) - ord('a'))) ^ (
                        1 << (ord(c) - ord('a'))
                    )

                    update(tin[u], delta)
                    if tout[u] < n:
                        update(tout[u] + 1, delta)

                    chars[u] = c
            else:
                v = int(parts[2])
                w = lca(u, v)

                mask = prefix(tin[u]) ^ prefix(tin[v])
                mask ^= 1 << (ord(chars[w]) - ord('a'))

                ans.append((mask & (mask - 1)) == 0)

        return ans
