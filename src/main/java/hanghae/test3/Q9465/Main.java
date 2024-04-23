package hanghae.test3.Q9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 스티커 2n개 구매
 * 스티커 2행n열 배치
 * 스티커 때면 변을 공유 하고있는 스티커 사용불가
 * 테스트 각 최대점수
 * 2
 * 5
 * 50 10 100 20 40
 * 30 50 70 10 60
 * 50(0,0) ,100(0,+2),40(0,+4)
 * 50(+1.+1),10(+1,+3) = 250
 * 50 10 100 20 40
 * 30 50 70 10 60
 * 50(0,0) ,100(0,+2)
 * 50(+1.+1),60(+1,+4) = 260
 * 10(0,1),20(0,3)
 * 30(1,0),70(1,2),60(1,4)=190
 * 50(0,0),100(0,2),40(0,4)
 *50(1,1),10(1,3)
 *
 * +2 좌우 비교
 *
 * (0,0),(0,2)(0,4)
 * (1,1),(1,3)
 *
 * 6020701050
 * 80120130
 * 180
 * 7
 * 10 30 10 50 100 20 40
 * 20 40 30 50 60 20 80
 --------------------------------------------------
 * 반례
 * 1
 * 3
 * 21 69 96
 * 81 50 24

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    static int dp[][];
    static int stickers[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            stickers = new int[2][N + 1];
            dp = new int[2][N + 1];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k < N + 1; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            /*
              50 10 100 20 40
              30 50 70 10 60
              50(0,0) ,100(0,+2)
              50(+1.+1),60(+1,+4) = 260

            */
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int j = 2; j < N + 1; j++) {//174?
                dp[0][j] = Math.max(dp[1][j - 2], dp[1][j - 1]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j - 2], dp[0][j - 1]) + stickers[1][j];
            }
            sb.append(Math.max(dp[0][N], dp[1][N])).append('\n');//스타트 2케이스 최대값 비교
        }
        System.out.print(sb);
    }
}