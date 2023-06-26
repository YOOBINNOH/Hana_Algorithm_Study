package 알고리즘스터디4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15665_실2_N과M11 {
    private static int n;
    private static int m;
    private static int[] permutations;
    private static int[] inputs;
    private static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        permutations = new int[m + 1];
        inputs = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputs);

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
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= m; i++) {
                sb.append(permutations[i] + " ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 1; i <= n; i++) {
            permutations[depth] = inputs[i];
            dfs(depth + 1);
        }
    }
}
