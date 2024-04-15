package hanghae.day9.Q1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 53 47 88%
 * 수학
 * 이분 탐색
 * 틀림
 * 47 47 = -148 출력
 *

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        int Z = (int)(100 * Y  / X);

        long start = 1;
        long end =X;

        if (Z >= 99) {//한판이라도 지면 100% 불가, 100% 101% 불가
            System.out.print(-1);
            System.exit(0);
            //return;
        }
        while (start <= end) {
            int mid = (int)(start + end) / 2;
            int percent= (int)(100 * (Y+mid)/(X+mid));

            if (Z < percent){
                end = mid -1;
            } else {
             start = mid + 1;
            }
        }
        sb.append(start);
        System.out.print(sb);
    }
}