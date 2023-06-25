package 알고리즘스터디4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1748_실4_수이어쓰기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int plus = 1;
        int num = 10;

        // 자릿수가 바뀔때마다 더해야하는 갯수가 한개씩 늘어남
        for (int i = 1; i <= n; i++) {
            if (i % num == 0) {
                plus++;
                num *= 10;
            }
            count += plus;
        }
        System.out.println(count);
        br.close();
    }
}
