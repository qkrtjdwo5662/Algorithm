import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split())
computers = [ [] for _ in range(N+1) ]

for _ in range(M):
    A, B = map(int, input().split())
    computers[B].append(A)

def bfs(start):
    cnt = 1
    visited = [False] * (N+1)
    queue = deque([start])
    visited[start] = True

    while queue:
        a = queue.popleft()

        for c in computers[a]:
            if not visited[c]:
                queue.append(c)
                visited[c] = True
                cnt += 1
    return cnt

# Simulation
res = []
max_ = 0
for idx in range(1,N+1):
    t = bfs(idx)

    if t == max_:
        res.append(str(idx))
    elif t > max_:
        max_ = t
        res = [str(idx)]
print(' '.join(res))