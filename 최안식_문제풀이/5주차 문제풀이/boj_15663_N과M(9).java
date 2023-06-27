package BaekJoon;

import java.io.*;
import java.util.*;

// TODO: 2023/06/21 15663번 N과 M(9) (실버2)
// TODO: 2023/06/21 !!성공!!
public class boj_15663 {
    static int[] arr;
    static int[] sol;
    static int depth;
    static int n,m;
    public static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //N개의 자연수와 자연수 M
        //N개의 자연수 중에서 M 개를 고른 수열
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        sol = new int[n];
        visited = new boolean[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        //주어진 N개의 자연수들을 담은 배열을 정렬한다.
        Arrays.sort(arr);
        dfs(0);
        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int i : sol) {

                System.out.print(i+" ");
            }
            System.out.println("");
        }
    }
}
