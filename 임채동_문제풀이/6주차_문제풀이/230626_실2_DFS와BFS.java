package 알고리즘스터디5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260_실2_DFS와BFS {
    private static int n;
    private static int m;
    private static int v;
    private static List<List<Integer>> list = new ArrayList<>();
    private static boolean[] check;
    private static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        check = new boolean[n + 1];

        // 이차원배열이 아닌 
        // 양방향 인접 리스트에 담아주는게 맞는것 같다.
        // 이차원배열에 담아서 1인지 아닌지 보는게 훨씬 빠를것 같은데 ? 
        // for (int i = 0; i < m; i++) {
        //     st = new StringTokenizer(br.readLine());
        //     List<Integer> tempList = new ArrayList<>();
        //     tempList.add(Integer.parseInt(st.nextToken()));
        //     tempList.add(Integer.parseInt(st.nextToken()));
        //     list.add(tempList);
        // }

        // 언제 인접리스트로 하는건지
        // 언제 이차원배열로 하는건지 좀 잘 알아봐야할듯...
        map = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;
        }

        // v부터 시작한다.
        check[v] = true;
        System.out.println(v);
        dfs(v);

        check = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node);
            for (int i = 1; i <= n; i++) {
                if (!check[i] && map[node][i] == 1) {
                    queue.add(i);
                    check[i] = true;
                    map[node][i] = 0;
                    map[i][node] = 0;
                }
            }
        }
    }

    private static void dfs(int node) {
        for (int i = 1; i <= n; i++) {
            // 백트래킹 조건은
            // 방문여부, 해당 노드에 연결되어 있는지 이다.
            if (!check[i] && map[node][i] == 1) {
                check[i] = true;
                System.out.println(i);
                dfs(i);
            }
        }
    }
}
