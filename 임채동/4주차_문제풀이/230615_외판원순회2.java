package 알고리즘스터디4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10971_실2_외판원순회2 {
    private static int n;
    private static int[][] map;
    private static boolean[] check;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /*
            여행가서 모든 도시를 거치고 원래의 도시로 돌아오는 여행
            모든 여행 중 가장 비용이 적게드는 여행은??
         */
        // 출발지점이 정해지지 않았으므로 모든 도시가 한번씩 출발지점이 되어야 한다.
        for (int i = 0; i < n; i++) {
            check = new boolean[n];
            check[i] = true;
            dfs(i, i, 0, 0);
            check[i] = false;
        }

        System.out.println(min);
    }

    private static void dfs(int start, int now, int sum, int depth) {
        if (depth == n - 1) {
            if (map[now][start] != 0) {
                sum += map[now][start];
                min = Math.min(sum, min);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            // 백트래킹 조건은, 방문여부 && 0 이상인지
            if (!check[i] && map[now][i] > 0) {
                check[i] = true;
                dfs(start, i, sum + map[now][i], depth + 1);
                check[i] = false;
            }
        }
    }
}
