package 알고리즘스터디4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654_실3_N과M5 {
    private static int n;
    private static int m;
    private static int[] inputs;
    private static int[] permutation;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inputs = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputs);

        permutation = new int[m + 1];
        check = new boolean[n + 1];

        dfs(1);
    }

    private static void dfs(int depth) {
        if (depth == m + 1) {
            printAnswer();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                check[i] = true;
                permutation[depth] = inputs[i];
                dfs(depth + 1);
                check[i] = false;
            }
        }
    }

    private static void printAnswer() {
        for (int i = 1; i <= m; i++) {
            System.out.print(permutation[i] + " ");
        }
        System.out.println();
    }
}
