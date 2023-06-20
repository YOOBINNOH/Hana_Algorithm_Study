package 알고리즘스터디4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10819_실2_차이를최대로 {
    private static int n;
    private static int[] inputs;
    private static int[] permutation;
    private static boolean[] check;
    private static List<List<Integer>> list = new ArrayList<>();
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        inputs = new int[n + 1];
        check = new boolean[n + 1];
        permutation = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        /*
            1. inputs로 나올수있는 모든 순열을 만듬
            2. 그담 그 순열들을 전부 absSum을 구함
            3. 그 중 가장 큰 숫자를 출력
         */
        getPermutation(1);
        getMaxSum();
        System.out.println(answer);
    }


    private static void getPermutation(int depth) {
        if (depth == n + 1) {
            setPermutationList();
        }

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                check[i] = true;
                permutation[depth] = inputs[i];
                getPermutation(depth + 1);
                check[i] = false;
            }
        }
    }

    private static void setPermutationList() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(permutation[i]);
        }
        list.add(nums);
    }

    private static int getAbsSum(List<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += (Math.abs(nums.get(i) - nums.get(i + 1)));
        }
        return sum;
    }

    private static void getMaxSum() {
        for (List<Integer> nums : list) {
            int sum = getAbsSum(nums);
            if (sum > answer) {
                answer = sum;
            }
        }
    }
}
