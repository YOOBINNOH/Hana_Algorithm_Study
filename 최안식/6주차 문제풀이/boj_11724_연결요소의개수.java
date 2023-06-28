package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// TODO: 2023/06/26 1260번 DFS와 BFS (실버2) https://www.acmicpc.net/problem/1260
// TODO: 2023/06/26 !!성공!!
public class boj_1260_DFS와BFS {
    static int n, m, v;
    static int[][] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        v = Integer.parseInt(stk.nextToken());
        graph = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        dfs(v);
        Arrays.fill(visit, false);
        System.out.println();
        bfs(v);
    }

    /**
     *  1 2 3 4
     *
     *  0 1 1 1
     *  1 0 0 1
     *  1 0 0 1
     *  1 0 0 1
     *
     *
     */
    static void dfs(int start) {
        visit[start] = true;
        System.out.print(start+" ");
        for (int i = 1; i < n + 1; i++) {
            if (graph[start][i]==1&&!visit[i]) {
                dfs(i);
            }
        }
    }

    static Queue<Integer> q = new LinkedList();
    static void bfs(int start) {
        //bfs 큐에 먼저 start 값을 넣어준다.
        //시작하는 start 값에 대하여 방문처리를 해준다.
        q.add(start);
        visit[start] = true;
        while (!q.isEmpty()) { //큐에 들어간걸 꺼내서 쓸껀데 큐가 비지 않았으면 반복
            start = q.poll(); // 큐에 들어간걸 꺼내서 방문을 시작한다.
            System.out.print(start + " ");
            for (int i = 1; i < n+1; i++) {//큐에서 꺼낸걸 제외하고, 꺼낸값을 기준으로 bfs 시작
                if (graph[start][i] == 1 && !visit[i]) {
                    visit[i] = true;//큐에서 꺼낸것들로 방문 시작
                    q.add(i); // 방문된것 다시 큐에 넣어서 bfs 돌게 한다.
                }
            }
        }
    }
}
