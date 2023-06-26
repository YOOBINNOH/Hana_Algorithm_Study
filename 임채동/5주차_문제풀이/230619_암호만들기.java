package 알고리즘스터디5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759_골5_암호만들기 {
    private static int l;
    private static int c;
    private static char[] inputs;
    private static boolean[] check;
    private static char[] temp;
    // private static Set<String> answerSet = new LinkedHashSet<>();
    // ! set으로 중복제거를 했더니 메모리 초과가 났다.
    // ! 아래 나오는 dfs(int depth, int start)와 for문의 i+1을 start로 넣어주어
    // ! 순서를 보장해주는 코드를 심었더니 해결됐다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        check = new boolean[c];
        inputs = new char[c];
        temp = new char[l];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            inputs[i] = (st.nextToken().charAt(0));
        }
        Arrays.sort(inputs);
        br.close();
        /*
            1. 한개이상의 모음, 2개이상의 자음
            1.1. 한개이상 'a''e''i''o''u' 있는지 count해야함
            1.2. 2개이상 'a''e''i''o''u' 아닌거 있는지 count해야함
            2. 사전식으로 정렬되어 있어야 함  + 중복되는 것은 없다.
            2.1. 정답배열을 LinkedHashSet에 넣으면 사전식으로 정렬해준다.
         */
        dfs(0, 0);
    }

    private static void dfs(int depth, int start) {
        if (depth == l) {
            if (!validate(temp)) {
                return;
            }
            System.out.println(temp);
            return;
        }

        // depth와 start를 만들어서 앞input은 신경쓰지 않도록 해준다.... ㅠ
        // 이부분이 가장 어려웠다.
        for (int i = start; i < c; i++) {
            temp[depth] = inputs[i];
            dfs(depth + 1, i + 1);
        }
    }

    private static boolean validate(char[] chars) {
        int vowelCount = 0;
        int consonantCount = 0;
        for (int i = 0; i < l; i++) {
            char ch = chars[i];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }
        return (vowelCount > 0 && consonantCount > 1);
    }
}
