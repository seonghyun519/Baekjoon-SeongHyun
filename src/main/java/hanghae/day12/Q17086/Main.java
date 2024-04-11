package hanghae.day12.Q17086;

import java.io.*;
import java.util.*;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * N * M 크기 공간
 * 아기상어 한마리?
 * ?칸의 안전거리는 그칸과 가장 거리가 가까운 상어와의 거리
 * 입력
 * 첫줄 N*M 값
 * N개의 줄의 공간 상태 0빈칸 1상어
 * 안전거리 최대값
 * 이차원배열로 값 받고
 * 상어와 거리 계산하여 배열에 담음
 * 상어가 다수일 때
 *
 ------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    static int N, M;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];//공간
        visited = new int[N][M];//위치에서 안전거리 값

        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    q.offer(new Pair(i,j)); //상어의 위치를담아준다.
                }
            }
        }

        int cnt = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            Pair pair = q.poll();
            int x = pair.x;
            int y = pair.y;

            for(int i=0; i<8; i++) {//위에서 시계방향 상어 이동
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(valid(nx, ny)) {
                    if(visited[nx][ny] == 0 && map[nx][ny] != 1) {	//안전거리가 저장안되어있거나, 상어의 위치가 아니면
                        visited[nx][ny] = visited[x][y]+1; //안전거리 1증가
                        cnt = Math.max(visited[nx][ny], cnt);//안전거리 최대값 변경
                        q.offer(new Pair(nx, ny));
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    public static boolean valid(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }
        return true;
    }

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}