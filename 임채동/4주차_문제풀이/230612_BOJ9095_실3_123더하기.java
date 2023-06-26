package 알고리즘스터디4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ9095_실3_123더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> dp = new ArrayList<>();
        dp.add(0, 0);
        dp.add(1, 1);
        dp.add(2, 2);
        dp.add(3, 4);
        for (int i = 4; i < 11; i++) {
            int num = dp.get(i - 1) + dp.get(i - 2) + dp.get(i - 3);
            dp.add(i, num);
        }

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp.get(num));
        }
    }
}
