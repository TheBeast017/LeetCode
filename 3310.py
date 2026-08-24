class Solution:
    def remainingMethods(self, n: int, k: int, invocations: list[list[int]]) -> list[int]:
        graph = [[] for _ in range(n)]
        indegree = [0] * n

        for a, b in invocations:
            graph[a].append(b)
            indegree[b] += 1

        suspicious = [False] * n
        stack = [k]
        suspicious[k] = True

        while stack:
            u = stack.pop()
            for v in graph[u]:
                if not suspicious[v]:
                    suspicious[v] = True
                    stack.append(v)

        for a, b in invocations:
            if not suspicious[a] and suspicious[b]:
                return list(range(n))

        return [i for i in range(n) if not suspicious[i]]
