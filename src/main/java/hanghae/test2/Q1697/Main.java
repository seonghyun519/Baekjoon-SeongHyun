package hanghae.test2.Q1697;

import java.io.*;
import java.util.*;
/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)
 * 현재 수빈이 위치 점 N, 동생 K
 * 이동 방법 걷기 1초후 X -1, X + 1
 * 이동 순간 이동 1초후 2 * X
 * 수빈이 찾을 수 있는 최단 시간
 *
 * 5 6 7 8 9 10 11 12 13 14 15 16 17
 * 5(현위치) 10순간이동 9걷기(왼) 18순간이동 17걷기 왼
 *
 * 알고리즘 분류 최단거리 bfs
 *
 * 문제
 * 예제 출력 2나옴 (정답 4) NM실수
 * 런타임 에러 (ArrayIndexOutOfBounds)
 * 조건식 순서 변경 배열 후순위
 * 틀렸습니다
 * N, K가 바로 같을 때 조건식
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    static int N, K;
    static  int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//수빈이 위치
        K = Integer.parseInt(st.nextToken());//동생 위치
        visited = new int[100001]; //인덱스 0, +1
        if (N == K) {
            System.out.println(0);
        } else {
            bfs();
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = 1;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int i = 1; i <= 3; i++) {//3가지 방법 X-1 X+1 X*2
                int next = 0;//탐색
                switch (i) {
                    case 1: next = vertex - 1; break; //X - 1
                    case 2: next = vertex + 1; break; //X + 1
                    case 3: next = vertex * 2; break; //X * 2
                }
                if (next == K) {
                    System.out.println(visited[vertex]);
                    queue.clear();
                    break;
                }
                if (next >= 0 && next < 100001 && visited[next] == 0){ //방문한적 없고 0<= K <100001 에러 / if (visited[next] == 0 && next >= 0 && next <= visited.length){ 조건식 순서 변경
                    queue.add(next);
                    visited[next] = visited[vertex] + 1; //소요시간 추가
                }

            }
        }
    }
}
