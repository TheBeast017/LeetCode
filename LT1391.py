from collections import deque

class Solution(object):
    def hasValidPath(self, grid):
        m, n = len(grid), len(grid[0])

        opens = {
            1: {0, 1},
            2: {2, 3},
            3: {1, 2},
            4: {0, 2},
            5: {1, 3},
            6: {0, 3},
        }

        directions = {
            0: (0,  1, 1),
            1: (0, -1, 0),
            2: (1,  0, 3),
            3: (-1, 0, 2),
        }

        visited = [[False] * n for _ in range(m)]
        queue = deque([(0, 0)])
        visited[0][0] = True

        while queue:
            r, c = queue.popleft()

            if r == m - 1 and c == n - 1:
                return True

            for d, (dr, dc, opp) in directions.items():
                if d not in opens[grid[r][c]]:
                    continue

                nr, nc = r + dr, c + dc

                if not (0 <= nr < m and 0 <= nc < n):
                    continue

                if opp not in opens[grid[nr][nc]]:
                    continue

                if not visited[nr][nc]:
                    visited[nr][nc] = True
                    queue.append((nr, nc))

        return False
