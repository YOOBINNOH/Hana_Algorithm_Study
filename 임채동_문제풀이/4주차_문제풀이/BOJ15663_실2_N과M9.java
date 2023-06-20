package 알고리즘스터디4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15663_실2_N과M9 {
    private static int n;
    private static int m;
    private static int[] inputs;
    private static int[] permutation;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputs);
        

    }
}
