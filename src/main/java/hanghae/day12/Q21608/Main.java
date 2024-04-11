package hanghae.day12.Q21608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * N * N 크기 교실 (교실 가장 왼쪽 윗 1, 1), 가장 오른쪽 아랫 칸(N, N) - 0, N - N, 0  버림
 *
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {

    static int n;

    static int[][] visited, relation;

    static int[] dx = {-1, 0, 1, 0};//상우하좌
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new int[n + 1][n + 1];
        relation = new int[n * n + 1][4];

        for (int i = 0; i < n * n; i++) {
            var tokenizer = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(tokenizer.nextToken());

            for (int j = 0; j < 4; j++) {
                relation[student][j] = Integer.parseInt(tokenizer.nextToken());
            }

            simulate(student);
        }

        calculateScore();
    }

    private static void calculateScore() {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int student = visited[i][j];
                int likeCount = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        continue;
                    }

                    for (int l = 0; l < 4; l++) {
                        if (visited[nx][ny] == relation[student][l]) {
                            likeCount++;
                        }
                    }
                }

                answer += Math.pow(10, likeCount - 1);
            }
        }

        System.out.println(answer);
    }

    private static void simulate(int student) {
        int maxEmptyCount = 0;
        int maxLikeCount = 0;
        int x = 0;
        int y = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (visited[i][j] != 0) {
                    continue;
                }

                int likeCount = 0;
                int emptyCount = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        continue;
                    }

                    if (visited[nx][ny] == 0) {
                        emptyCount++;
                    } else {
                        for (int l = 0; l < 4; l++) {
                            if (visited[nx][ny] == relation[student][l]) {
                                likeCount++;
                            }
                        }
                    }
                }

                if (likeCount > maxLikeCount || (likeCount == maxLikeCount && maxEmptyCount <= emptyCount)) {
                    maxLikeCount = likeCount;
                    maxEmptyCount = emptyCount;
                    x = i;
                    y = j;
                }
            }
        }

        visited[x][y] = student;
    }
}
