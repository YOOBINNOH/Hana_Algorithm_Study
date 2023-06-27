from collections import deque
import sys # 이거 안하면 시간 초과
input=sys.stdin.readline

n, m=map(int, input().split())

maps=[[0]*(n) for i in range(n)]

for i in range(m):
    a, b = map(int, input().split())
    maps[a-1][b-1]=1
    maps[b-1][a-1]=1

visited=[0]*n


# maps[x][y]=1 : x노드랑 y노드가 연결되어있음을 뜻함. x노드(행)에서 y번째 열과 연결!

def bfs(i):
    q=deque()
    q.append(i)
    visited[i]=1
    while q:
        a=q.popleft()
        for i in range(n):
            if not visited[i] and maps[a][i]: #방문하지 않았으면서, 인접해있으면
                q.append(i)
                visited[i]=1

k=0
for i in range(n):
    if not visited[i]:
        bfs(i)
        k+=1

print(k)
