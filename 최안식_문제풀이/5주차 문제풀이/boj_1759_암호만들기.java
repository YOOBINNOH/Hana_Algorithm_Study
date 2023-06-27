
package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// TODO: 2023/06/21 1759번 암호만들기 (골드5)
// TODO: 2023/06/21 !성공!
/**
 * 최소 1개의 모음(a,e,i,o,u) 와 2개의 자음으로 이루어 져야 한다.
 * 처음에는 for dfs 수행중에 자음인지 모음인지 체크하는 부분을 넣어서 카운팅을 해주었는데 모든 경우에 대해 체크함으로 비효율적으로 느껴졌음.
 * isvalid 라는 이름으로 함수화를 진행하여 depth 만큼 들어갔을때 정답 체크를 할때 조건에 만족하는지 체크하였음.
 * 알파벳이 증가하는 순서대로 배열되기때문에 Array.sort 를 사용해서 정렬먼저 해준다.
 * 또한 앞에서 풀었던 N과 M 의 경우에는 abc bac도 정답이었지만 "증가하는 순서대로" 이기 때문에
 * a t c i s w 를 입력받았을 경우 ==> a c i s t w 순으로 정렬되고 a에 대해서 dfs 재귀를 끝내고 나면 다시 사용해서는 안된다.
 *
 * 1번 풀이. depth를 넘겨서 탈출조건을 지정하면서, 앞선 값을 사용해서는 안되기 때문에 이전처럼 visited를 이용해서 앞에서부터 다시 탐색하는것이 아닌
 * 현재 위치한 인덱스 + 1 을 넘겨서 다음 부분부터 탐색하도록 한다.
 * for(int i = next ; i < m ; i ++){
 *     solution[depth] = arr[i]
 *     dfs(i+1,depth+1)
 * }
 * */
public class boj_1759_암호만들기 {
    static char[] arr;
    static char[] solution;
    static boolean[] visited;
    static int cnt_con, cnt_vowels,n,m;
    static boolean isConsonant;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new char[m];
        solution = new char[n];
        visited = new boolean[m];
        cnt_con=0;
        cnt_vowels = 0;
        isConsonant = false;
        stk = new StringTokenizer(br.readLine());
        int i = 0;
        while (stk.hasMoreTokens()) {
            arr[i++] = stk.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        dfs(0,0);
    }
    static void dfs(int next,int depth){
        if (depth == n) {
            if (isValid()) {
                System.out.println(solution);
            }
            return;
        }
        // a c i s t w
        // 0 1 2 3 4 5
        /** n = 4, m = 6;
         * a(next=0,depth=0, i=0) , ac(1,1,1), aci(2,2,2) ,acis(3,3,i=3), acit(3,3,i=4),aciw(3,3,i=5)
         * a, ac, acs(2,2,3), acst(4,3,i=4), acsw(4,3,i=5)
         * a, ac ,act(2,2,4), actw(5,3,5)
         * */
        else {
            for (int i = next ; i < m; i++) {
                solution[depth] = arr[i];
                dfs(i+1,depth+1);
                solution[depth] = 'X';
            }
        }
    }
    // 최소 모음 1개, 최소 자음 2개인지 확인
    public static boolean isValid() {
        int mo = 0;
        int ja = 0;

        for (char x : solution) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }
}
