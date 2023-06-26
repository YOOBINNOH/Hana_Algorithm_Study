package 알고리즘스터디5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11723_실5_집합 {
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(Integer.toString(i));
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            String num = null;
            if (st.hasMoreTokens()) {
                num = st.nextToken();
            }
            switch (command) {
                case "add":
                    set.add(num);
                    break;
                case "remove":
                    set.remove(num);
                    break;
                case "check":
                    sb.append(set.contains(num) ? 1 : 0);
                    sb.append("\n");
                    break;
                case "toggle":
                    if (set.contains(num)) {
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                    break;
                case "all":
                    set = new HashSet<>(list);
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.println(sb);
    }
}
