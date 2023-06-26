package 알고리즘스터디4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15663_실2_N과M9 {
    private static int n;
    private static int m;
    private static int[] inputs;
    private static int[] permutation;
    private static boolean[] check;
    private static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        inputs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputs);

        permutation = new int[m + 1];
        check = new boolean[n + 1];

        dfs(1);
        printAnswer();
    }

    private static void printAnswer() {
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    private static void dfs(int depth) {
        if (depth == m + 1) {
            StringBuilder temp = new StringBuilder();
            for (int i = 1; i <= m; i++) {
                temp.append(permutation[i] + " ");
            }

            set.add(temp.toString());
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
}
