package 알고리즘스터디3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10824_브3_네수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long num1 = Long.parseLong(st.nextToken() + st.nextToken());
        long num2 = Long.parseLong(st.nextToken() + st.nextToken());

        System.out.println(num1 + num2);
    }
}
