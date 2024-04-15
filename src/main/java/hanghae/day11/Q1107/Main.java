package hanghae.day11.Q1107;

import java.io.*;
import java.util.*;
/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 리모콘 0~9, +, - 있음
 * 현재 채널에서 + 현재 채널 +1, - 현재채널 -1, 0에서 - 안내려감
 * 이동하려는 채널 N, 고장난 버튼 주어졌을 때 버튼을 몇번 눌러야하는지
 * 수빈 현재 채널 100
 *
 * 5457
 * 3
 * 6,7,8
 * 5455 5,4,5,5
 * 5456 +
 * 5457 +
 * = 6
 * 100
 * 5
 * 0 1 2 3 4
 * 시작 100 = 0
 * 1
 * 9
 * 1 2 3 4 5 6 7 8 9
 *
 * 500000
 * 8
 * 0 2 3 4 6 7 8 9
 * 511111 =6
 * - *11111
 * = 6+ 11111 = 11117
 --------------------------------------------------
 //gg https://moonsbeen.tistory.com/64 참고
 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];//0~9
        int M = Integer.parseInt(br.readLine());

        //고장난 버튼
        if (M != 0) { //NullPointer
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        if (N == 100) {
            System.out.println(0);
            return;
//            System.exit(0);
        }
        // 위,아래 버튼만 눌러서 이동하는 수
        int count = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for (int j = 0; j < len; j++) {
                if (broken[str.charAt(j) - '0']) { //고장난 버튼을 눌러야 하면
                    isBreak = true;
                    break; //더 이상 탐색하지 않고 빠져나온다.
                }
            }
            if (!isBreak) { //i를 누를때 고장난 버튼을 누르지 않는다면
                int min = Math.abs(N - i) + len; //i를 누른 후(len) N까지 이동하는 횟수(N - i)
                count = Math.min(min, count);
            }
        }
        System.out.println(count);
    }
}