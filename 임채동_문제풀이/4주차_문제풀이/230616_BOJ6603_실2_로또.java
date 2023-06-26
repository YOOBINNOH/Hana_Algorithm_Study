import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ6603_실2_로또 {
    /*
        1. 인풋 자체부터 TreeSet으로 중복제거를 해줘야 불필요한 연산이 줄어든다.
        1.1. TreeSet으로 하는 이유는 순서대로 정렬해줘야 하기 때문이다.
        2. dfs로 부분수열 만드는데 check를 사용하여 중복이 안되도록 한다.   
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] check;
    private static int[] permutations;
    private static Set<Integer> inputs;
    private static List<Integer> list;
    private static Set<String> answers = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        while (true) {
            inputs = new TreeSet<>();
            if (setInputs()) {
                break;
            }
            check = new boolean[inputs.size() + 1];
            permutations = new int[inputs.size() + 1];


            dfs(1);
            printAnswers();
        }
    }

    private static void printAnswers() {
        Iterator iter = answers.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println();
    }

    private static void dfs(int depth) {
        if (depth == 7) {
            setAnswer();
            return;
        }
        for (int i = 1; i <= inputs.size(); i++) {
            if (!check[i]) {
                check[i] = true;
                permutations[depth] = list.get(i - 1);
                dfs(depth + 1);
                check[i] = false;
            }
        }
    }

    private static void setAnswer() {
        StringBuilder sb = new StringBuilder();
        List<Integer> tempList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            tempList.add(permutations[i]);
        }
        Collections.sort(tempList);
        for (Integer num : tempList) {
            sb.append(num + " ");
        }
        answers.add(sb.toString());
    }

    private static boolean setInputs() throws IOException {
        String input = br.readLine();
        if (input.equals("0")) {
            return true;
        }

        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            inputs.add(Integer.parseInt(st.nextToken()));
        }
        list = new ArrayList<>(inputs);
        return false;
    }
}
