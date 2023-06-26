package 알고리즘스터디5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_실2_부분수열의합 {
    private static int n;
    private static int s;
    private static int[] inputs;
    private static int count = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        inputs = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        dfs(0, inputs[0]);

        //! 공집합은 빼야한다.... 설명에  없었는데 어쩌라는건지
        System.out.println(count == 0 ? 0 : count - 1);
    }

    private static void dfs(int depth, int sum) {
        // 종료조건은 depth가 n이 되는것과
        // sum이 s가 되는것
        if (depth == n) {
            if (sum == s) {
                count++;
            }
            return;
        }

        dfs(depth + 1, sum);
        dfs(depth + 1, sum + inputs[depth]);
    }
}

/*
 * 이전에 DFS 배울때 해본 접근이라 나쁘지 않게 풀었는데, 
 * 공집합은 빼야한다는걸 몰라서 시간이 꽤 걸림
 * 문제에 설명도 없던대 좀 어이없긴하다.
 */