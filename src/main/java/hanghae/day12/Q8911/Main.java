package hanghae.day12.Q8911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 --------------------------------------------------
 * F:한 눈금 앞으로 B: 한 눈금 뒤로 L: 왼쪽으로 90도 회전 R: 오른쪽으로 90도 회전
 * L: 왼쪽으로 90도 회전 -이동 없음 방향만 변경
 * R: 오른쪽으로 90도 회전 -이동 없음 방향만 변경
 * 거북이는 항상 x축과 y축에 평행한 방향 / 상하 좌우
 * 동서남북 좌표값 시작 북을 바라본다는 기준으로.. 어디를 바라보든 상관없을듯?
 * 시작 조건 북쪽
 * 방향 좌표값 동서남북 구하고
 * 입력값 테스트 케이스 횟수, 테스트 케이스 방향행동 명령 받고
 * 테스트 케이스만큼 반복문
 * 선을 그어주는데 음수가 되었을 때? 절대값으로 +x , -x 음수 절대값으로 더해주고 x * y
 *
 * 문제
 * 출력 0 0 0
 * 2중 for문 i값
 --------------------------------------------------
 */
public class Main {
    static int[] dx = {0, 1, 0, -1}; // 북, 동, 남, 서
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int x = 0, y = 0, maxX = 0, maxY = 0, minX = 0, minY = 0, direction = 0;
            String orders = br.readLine();
            for (int j = 0; j < orders.length(); j++) {
                char order = orders.charAt(j);
                if (order == 'F') { //전진
                    x += dx[direction];
                    y += dy[direction];
                }
                if (order == 'B') { //후진
                    x -= dx[direction];
                    y -= dy[direction];

                }
                if (order == 'L') { //왼쪽 회전
                    if (direction == 0){//북쪽이면 서쪽으로 0북, 1동, 2남, 3서
                        direction = 3;
                    }else {
                        direction -= 1;
                    }
                }
                if (order == 'R') { //오른쪽 회전
                    if (direction == 3){//서쪽이면 북쪽으로 0북, 1동, 2남, 3서
                        direction = 0;
                    }else {
                        direction += 1;
                    }
                }
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
            }
            sb.append((maxX + Math.abs(minX)) * (maxY + Math.abs(minY))).append('\n');
        }
        System.out.println(sb);
    }
}