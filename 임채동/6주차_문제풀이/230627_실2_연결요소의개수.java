package 알고리즘스터디6주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724_실2_연결요소의개수_내풀이 {
    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[] check;
    private static int count = 0;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        check = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                queue.add(i);
                bfs(i);
                check[i] = true;
                count++;
            }
        }
        System.out.println(count);
    }

    private static void bfs(int start) {
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (!check[i] && map[current][i] == 1) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }

    }
}

/**
 * BFS 를 풀어본적은 있지만, 능숙하게 코드를 짜진 못하는 상황이다.
 * 스스로 풀어봤지만 계속 틀려 구글링해서 코드를 따라쳐보았따.
 * 그리고 직접 짜보아서 성공했다.
 * 
 * 일단 어떤 느낌인진 배울수있었다.
 * 좀 많이 풀어봐야 능숙하게 짤수있을것 같다.
 */