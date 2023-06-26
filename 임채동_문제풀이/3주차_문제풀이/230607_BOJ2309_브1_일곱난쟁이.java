package 알고리즘스터디3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2309_브1_일곱난쟁이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = new int[9];
        for (int i = 0; i < 9; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }
        int sum = Arrays.stream(inputs).reduce((acc, cur) -> acc + cur).getAsInt();
        Arrays.sort(inputs);
        // 왼 오 로 나눠서 왼쪽 오른쪽 두개를 뺴봄
        // 100보다 작으면 오른쪽을 내리고
        // 100보다 크면 왼쪽을 올림
        int lt = 0;
        int rt = 8;
        sum -= inputs[lt] + inputs[rt];
        while (lt < rt) {
            if (sum == 100) {
                printAnswers(inputs, lt, rt);
                return;
            } else if (sum < 100) {
                sum += inputs[rt--];
                sum -= inputs[rt];
            } else if (sum > 100) {
                sum += inputs[lt++];
                sum -= inputs[lt];
            }
        }
    }

    static void printAnswers(int[] inputs, int lt, int rt) {
        for (int i = 0; i < 9; i++) {
            if (i == lt || i == rt) {
                continue;
            }
            System.out.println(inputs[i]);
        }
    }
}

/*


package 알고리즘스터디3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2309_브1_일곱난쟁이 {
    static List<Integer> list = new ArrayList<>();
    static int[] visit = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 일곱 난쟁이의 키의 합은 100이다.
        // 7명씩 부분수열 만든다음에
        // 합이 100이면 return 하면 될듯
        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));

        }
        DFS(1, 0);
        // System.out.println("list = " + list);
    }

    static void DFS(int i, int sum) {
        if (i == 7) {
            if (sum == 100) {
                for (int j = 0; j < 9; j++) {
                    if (visit[j] == 1) {
                        System.out.println(list.get(j));
                    }
                }
            }
        } else {
            for (int j = 0; j < 9; j++) {
                if (visit[j] == 0 && i < 7) {
                    visit[j] = 1;
                    DFS(i + 1, sum + list.get(j));
                    visit[j] = 0;
                }
            }
        }

    }
}

 */