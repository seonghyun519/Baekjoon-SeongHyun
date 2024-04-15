package hanghae.day11.Q10971;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 14704kb	180ms
 --------------------------------------------------
 N 도시의 수 2 ≤ N ≤ 10
 N 개의 줄의 비용 행렬
 4
 0 10 15 20
 5 0 9 10
 6 13 0 12
 8 8 9 0

 35
 //갈 수 없는 경우는 0이 주어진다!!!!
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {

    private static int n; // 도시 개수
    private static int[][] cost; // 도시 간 이동 비용
    private static boolean[] visited; // 방문
    private static int min = Integer.MAX_VALUE; // 최소 비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        //도시간 이동 비용
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n];
        //출발
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);
        }
        System.out.println(min);
    }

    private static void dfs(int start, int now, int depth, int sum) {
        if (depth == n-1) {
            int returnCost = cost[now][start];
            if (returnCost != 0) {//출발점에서 다 돌고 돌아가는 간선이 0이 아닐때
                sum +=returnCost;
                min = Math.min(sum, min);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && cost[now][i] != 0){//아직 방문 안함, 간선이 있을때
                visited[i] = true;
                dfs(start, i, depth +1, cost[now][i] + sum);
                visited[i] = false;
            }
        }
    }
}