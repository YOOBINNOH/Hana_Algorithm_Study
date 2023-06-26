package 알고리즘스터디5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15661_실1_링크와스타트 {
    private static int n;
    private static int[][] map;
    private static int min = Integer.MAX_VALUE;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    private static void dfs(int depth, int start) {
        // 팀원이 절반이라는 보장이 없음
        // 1명이상이면 됨 
        // 그럼 어떻게 끝내는거지...
        // 매번 setMinDiff()를 하고,
        // depth == n이 되면 return하는 조건으로 가야하나..
        if (depth == n) {
            return;
        }
        setMinDiff();

        // 중복여부로 백트래킹
        // for문은 이전 요소들은 제거하기 위해 start 부터 시작하고, 
        // dfs 파라미터에 i + 1으로 다음애들부터 시작시킨다.
        for (int i = start; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(depth + 1, i + 1);
                check[i] = false;
            }
        }
    }

    private static void setMinDiff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check[i] && check[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if (!check[i] && !check[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }
        int value = Math.abs(start - link);
        if (value == 0) {
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(min, value);
    }
}
