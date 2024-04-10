package hanghae.day11.Q14889;

import java.io.*;
import java.util.*;
/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 * https://www.acmicpc.net/problem/14889
 --------------------------------------------------
 * 완전탐색(1)알고리즘 강의에서 풀이
 * 축구를 하기 위해 모인 인원 N명 N명은 짝수
 * N/2명으로 이루워진 2팀 스타팀, 링크팀
 * 팀원은 1~N번까지 번호 배정
 * 팀원들은 각 능력치 부여
 * S12 + S21 = 1 + 4 = 5
 * S34 + S43 = 2 + 5 = 7
 * 브루트포스 접근 -> 시간복잡도 계산 -> 터질거 같으면 ->브루트포스에서 효율 찾아보고 자료구조 바꿔보고 그리디, bfs dfs접근
 *
 * 36분 순열, 조합 시간복잡도 접근
 *
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */

public class Main {
    static int[][] matrix;
    static int N;
    static int answer;// 팀들간의 능력치 차이 최소값
    static boolean[] visited;//조합간의 방문 기록

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        answer = Integer.MAX_VALUE; //최소값 초기화
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(0, N/2);
        System.out.println(answer);

    }

    public static void combination(
            int start,
            int r
    ) {
        if (r == 0) {
            answer = Math.min(answer, calculate());
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(i + 1, r - 1);
            visited[i] = false;
        }
    }

    private static int calculate() {
        int starTeam = 0;
        int linkTeam = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j <N; j++) {
                if (visited[i] && visited[j]){
                    starTeam += matrix[i][j];
                    starTeam += matrix[j][i];
                }
                if (!visited[i] && !visited[j]){
                    linkTeam += matrix[i][j];
                    linkTeam += matrix[j][i];
                }
            }
        }return Math.abs(starTeam - linkTeam);
    }

}