package 알고리즘스터디4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10974_실3_모든순열 {
    private static int n;
    private static int[] permutation;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        permutation = new int[n + 1];
        check = new boolean[n + 1];

        getPermutation(1);
    }

    private static void getPermutation(int depth) {
        if (depth == n + 1) {
            printAnswer();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                check[i] = true;
                permutation[depth] = i;
                getPermutation(depth + 1);
                check[i] = false;
            }
        }
    }

    private static void printAnswer() {
        for (int i = 1; i <= n; i++) {
            System.out.print(permutation[i] + " ");
        }
        System.out.println();
    }
}
