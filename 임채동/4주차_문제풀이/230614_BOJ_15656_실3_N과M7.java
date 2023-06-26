package 알고리즘스터디4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15656_실3_N과M7 {
    private static int n;
    private static int m;
    private static int[] inputs;
    private static int[] permutation;
    private static boolean[] check;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        inputs = new int[n + 1];
        permutation = new int[m + 1];
        check = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputs);

        getPermutation(1);
        System.out.println(sb.toString());
    }

    private static void getPermutation(int depth) {
        if (depth == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(permutation[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            permutation[depth] = inputs[i];
            getPermutation(depth + 1);
        }
    }
}
