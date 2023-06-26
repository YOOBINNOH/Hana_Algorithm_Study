package 알고리즘스터디5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2529_실1_부등호 {
    private static int k;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static char[] inputs;
    private static boolean[] check;
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        inputs = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            inputs[i] = st.nextToken().charAt(0);
        }
        check = new boolean[10];
        for (int i = 0; i <= 9; i++) {
            dfs(0, 0, "");
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    private static void dfs(int depth, int prev, String str) {
        // k+1개가 필요하기 떄문에 k가 아닌 k+1인지 확인 한다.
        if (depth == k + 1) {
            list.add(str);
            return;
        }

        // 0 ~ 9 의 숫자로 반복문
        for (int i = 0; i <= 9; i++) {
            // 백트래킹 조건은 방문여부와
            // 괄호 조건을 만족하는지이다.
            // 괄호 조건은 depth가 1이상 일때
            if (!check[i]) {
                if (depth == 0 || validate(str.charAt(str.length() - 1), (char) (i + '0'), inputs[depth - 1])) {
                    check[i] = true;
                    dfs(depth + 1, i, str + i);
                    check[i] = false;
                }
            }
        }
    }

    private static boolean validate(char a, char b, char c) {
        if (c == '<') {
            return a < b;
        } else if (c == '>') {
            return a > b;
        }
        return false;
    }
}
