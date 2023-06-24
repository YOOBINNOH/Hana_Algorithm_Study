 package 알고리즘스터디5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_실2_스타트와링크 {
    private static int n;
    private static int halfN;
    private static int min = Integer.MAX_VALUE;
    private static int[][] map;
    private static int[] startArr;
    private static int[] linkArr;
    private static boolean[] check;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        halfN = (int) Math.floor(n / 2);
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        startArr = new int[halfN];
        linkArr = new int[halfN];
        check = new boolean[n];
        /*
            능력치의 차이를 최소로 하려고 한다.
            팀을 반으로 나눠야한다. 
            반으로 모든 경우의 수를 뽑아서 점수를 구하는게 좋을듯
            그럼 모든 케이스를 dfs로 조합을 만들어야한다.
            12 34
            13 24
            14 23
         */
        // get 조합
        dfs(0, 0);
        System.out.println(min);
    }

    private static void dfs(int depth, int idx) {
        if (depth == n / 2) {
            min = Math.min(getScoreDifference(), min);
            return;
        }
        // 백트래킹 조건은 방문여부와 중복여부다.
        for (int i = idx; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(depth + 1, i + 1);
                check[i] = false;
            }
        }
    }

    private static int getScoreDifference() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check[i] == true && check[j] == true) {
                    start += map[i][j];
                    start += map[j][i];
                } else if (check[i] == false && check[j] == false) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        // ! 다른사람 코드를 보다가
        // ! System.exit(0); 으로 main함수 자체를 종료할수 있다는걸 배웠따.
        int value = Math.abs(start - link);
        if (value == 0) {
            System.out.println(0);
            System.exit(0);
        }

        return value;
    }
}
