package 알고리즘스터디5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//! 틀림
// public class BOJ14501_실3_퇴사 {
//     private static int n;
//     private static StringTokenizer st;
//     private static int[] times;
//     private static int[] prices;
//     private static boolean[] check;
//     private static int max = Integer.MIN_VALUE;


//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         n = Integer.parseInt(br.readLine());
//         times = new int[n];
//         prices = new int[n];
//         check = new boolean[n];
//         for (int i = 0; i < n; i++) {
//             st = new StringTokenizer(br.readLine());
//             times[i] = Integer.parseInt(st.nextToken());
//             prices[i] = Integer.parseInt(st.nextToken());
//         }

//         System.out.println("times = " + Arrays.toString(times));
//         System.out.println("prices = " + Arrays.toString(prices));

//         // 어디부터 시작해야 좋은지 모르니까 일단 다 확인해야할것같은데??
//         for (int i = 0; i < n; i++) {
//             dfs(0, 0);
//         }
//         System.out.println(max);
//     }

//     private static void dfs(int depth, int sum) {
//         if (depth == n) {
//             max = Math.max(max, sum);
//             return;
//         }

//         for (int i = 0; i < n; i++) {
//             // 백트래킹 조건은 방문했는지인데, 
//             // 방문체크할때 times를 체크해서 times만큼 i++하면서 다 true처리해줘야한다.
//             // 널 포인터 익셉션 방지하려면 i++할때 i > n 인지 확인해야한다.
//             // 현재날짜와 상담일수를 더한 숫자가 n보다 크면 안된다.
//             if (!check[i] && (depth + (times[i] - 1) < 7)) {
//                 check[i] = true;
//                 for (int j = 0; j < times[i]; j++) {
//                     check[i + j] = true;
//                 }
//                 dfs(depth + 1, sum + prices[i]);
//                 check[i] = false;
//                 for (int j = 0; j < times[i]; j++) {
//                     check[i + j] = false;
//                 }
//             }
//         }
//     }
// }
