package 알고리즘스터디5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13023_골5_ABCDE {
    private static int n;
    private static int m;
    private static boolean[] check;
    private static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        // ! 양방향 인접 리스트 생성
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> tempList = new ArrayList<>();
            list.add(tempList);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }
        // 모든 시작점을 다 탐색해야하니까 for문 돌림
        for (int i = 0; i < n; i++) {
            check = new boolean[n];
            check[i] = true;
            dfs(0, list.get(i));
        }
        /*
            이거 그래프로 그리라는거 같은데
            그래프 그려서 bfs로 12345 이렇게 다섯개 연결된거 있는지 체크하는거인듯
            => 아님 그래프 그려서 생각해보니까 dfs로 타고타고 들어가면서 5이상이면 체크하는거임 
            근데 그럼 중복되는경우도 생기는거 아님 ? 
            => 근데 문제 출력조건이 존재하면 1 없으면 0 임  ㅋㅋ 굳
            그래프 어케 그리지
            일단 이차원 배열만들고 0 1 이면 map[i][j] = 1; map[j][i] = 1; 달아주면될듯      
            01000
            10100
            01010
            00101
            00010 
         */
        /*
            하나 타고 들어가면 1이있는지 for문으로 쭉 확인함
            1이 있으면 해당 놈으로 dfs들어감
            depth가 카운트랑 같음
            체크도 필요함 check[i] 이면 넘겨야됨
         */
        //! 계속 시간초과가 떠서 다른사람 코드보니까 이차원배열이 아니라 
        //! 양방향 인접리스트로 인풋을 세팅해서 사용하더라......
        //! 그럼 모든 맵을 탐색하면서 1인지 아닌지 볼필요가없다.

        System.out.println(0);
    }

    private static void dfs(int depth, List<Integer> currentList) {
        if (depth == 4) {
            System.out.println(1);
            System.exit(0);
            return;
        }

        for (int i = 0; i < currentList.size(); i++) {
            int current = currentList.get(i);
            if (!check[current]) {
                check[current] = true;
                dfs(depth + 1, list.get(current));
                check[current] = false;
            }
        }
    }
}


/*
    문제 복기해보면
    양방향 인접리스트로 각 노드를 담아서 DFS로 처리할수있느냐?
    에 대한 문제였다.
    어떻게 보면 DFS 문제는 정형화된 풀이가 있고, 
    그 풀이 안에서 어떻게 응용을 하면서 
    예외처리, 백트래킹 조건 설정, 베이스케이스 잘 짤라내는것,
    인풋아웃풋 처리 잘하기 
    이런 구현을 어떻게 처리하느냐를 보는 문제인것같다.

    양방향 인접리스트로 처리하는 방법을 몰랐던것처럼 
    아직 모르는 스킬들이 더 있을것 같은데, 
    스터디를 통해 모든 스킬을 한바퀴 경험해보고
    문제를 많이 풀어보면 시험을 위한 정도까진 익힐수 있을것 같다.
 */