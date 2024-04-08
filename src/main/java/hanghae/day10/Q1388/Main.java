package hanghae.day10.Q1388;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char graph[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());//세로
        M = Integer.parseInt(st.nextToken());//가로

        graph = new char[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                graph[i][j] = line.charAt(j - 1);
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (visited[i][j]) {
                    continue;
                } else if (graph[i][j] == '-') {
                    dfs(i, j, true);
                } else {
                    dfs(i, j, false);
                }
                count++;
            }
        }

        System.out.println(count);
    }
    private static void dfs(int i, int j, boolean row) {
        visited[i][j] = true;
        if (row) {
            j++;
            if (j <= M && graph[i][j] == '-') dfs(i, j, true);
        } else {
            i++;
            if (i <= N && graph[i][j] != '-') {
                dfs(i, j, false);
            }
        }
    }
}
