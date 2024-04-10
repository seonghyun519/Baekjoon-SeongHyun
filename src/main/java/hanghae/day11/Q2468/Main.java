package hanghae.day11.Q2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 * 완전탐색, 시물레이션
 * https://www.acmicpc.net/problem/2468
 --------------------------------------------------
 *
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */

public class Main {
    static int N;
    static int[][] matrix;
    static boolean[][] visited;//
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        matrix = new int[N + 1][N + 1];
        int maxHeight = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, matrix[i][j]);
            }
        }
        int answer = 0;
        for (int h = 0; h < maxHeight; h++) {
            visited = new boolean[N + 1][N +1];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 특정 좌표에서 안정영역 확인
                    if (!visited[i][j] && matrix[i][j] > h){
                        dfs(i, j, h);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

    }

    private static void dfs(int x, int y, int h) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;

        while (!stack.isEmpty()) {
            int[] now = stack.pop();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dx[i];

                if (nx < 0 || ny<0 || nx >= N || ny >=N) {
                    continue;
                }

                //새로운 지점의 높이가 물높이보다 높은 경우
                if (matrix[nx][ny] > h) {
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx,ny});
                }
            }
        }
    }
}