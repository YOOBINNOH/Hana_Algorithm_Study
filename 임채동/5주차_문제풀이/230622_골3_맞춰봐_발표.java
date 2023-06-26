package 알고리즘스터디5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1248_골3_맞춰봐Guess {
    private static int n;
    private static char[][] map;
    private static boolean[] check;
    private static int[] answers;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        char[] chars = br.readLine().toCharArray();
        answers = new int[n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                map[i][j] = chars[idx++];
            }
        }

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(answers[i] + " ");
            }
            System.out.println(sb);
            System.exit(0);
            return;
        }

        for (int i = -10; i <= 10; i++) {
            // 백트래킹 조건은 sum이 +인지 -인지 0인지 여부다. 
            answers[depth] = i;
            if (validate(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean validate(int idx) {
        for (int i = 0; i <= idx; i++) {
            int sum = 0;
            for (int j = i; j <= idx; j++) {
                sum += answers[j];
                char sign = sum == 0 ? '0' : (sum > 0 ? '+' : '-');
                if (map[i][j] != sign) {
                    return false;
                }
            }
        }
        return true;
    }
}

/**
 * 문제 자체가 어려웠다.
 * -10~10이 들어갈수있고
 * 해당 기간을 검색하면서
 * validate를 해서 조건에 맞는지 틀린지를 통해
 * 더 검사를 할건지 안할건지를 정해주며 answers배열이 정해진다는걸 생각할수 있따면
 * 풀수있었을것같다.
 * <p>
 * 하지만 answers를 정해주면서 dfs가 끝날때까지 다 돌게되면
 * 해당 answers로 확정하고 끝낼수있다는걸 생각지 못했음
 * <p>
 * 일단.. 조건을 밸리데이션하는 백트래킹을 잘 설정해야한다는점.
 * 문제에서 주어진 조건 (-10~10) 이런점을 잘 읽어야하고
 * 정답을 어떻게 확정짓고 출력할것인지를 잘 생각해야한다...
 */
