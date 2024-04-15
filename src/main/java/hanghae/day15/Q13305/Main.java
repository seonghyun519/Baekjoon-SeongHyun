package hanghae.day15.Q13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 36492kb	388ms
 --------------------------------------------------
 * N개의 도시, 일직선 도로 위
 * 제일 왼쪽 도시에서 제일 오른쪽 도시 이동
 * 제일 왼쪽 도시 -> 제일 오른쪽 도시로 자동차를 이용하여 이동
 * 처음 출발 기름 0 넣고 출발
 * 연비 1km/1L
 * 각 도시에 주유소가 있으며 도시 마다 주요소의 리터당 가격 다를 수 있음
 * 제일 왼쪽 도시에서 제일 오른쪽 도시 이동하는 최소 비용
 *
 * 입력
 * 도시 개수 N
 * 인접한 두 도시 연결하는 도로 길이(N-1)
 * 도시 순서대로 N개의 주유소 리터당 가격 (마지막 주유소 금액 필요 없음) 1,000,000,000
 *
 *
 * 4
 * 2 3 1
 * 5 2 4 1
 * 시작 5
 * 10
 * min 2
 * 16
 * min 2
 * 18
 *
 * 4
 * 3 3 4
 * 1 1 1 1
 * 시작 1
 * 3
 * min 1
 * 6,10
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        //이동 비용
        long distance[] = new long[N-1];
        long gas[] = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        //도시 주유소 리터당 금액
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gas[i] = Long.parseLong(st.nextToken());
        }

        long total = 0;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < N-1; i++) {
            long city = distance[i];
            long cost = gas[i];

            min = Math.min(min, cost);//최소값 갱신
            total += city * min;
        }
        System.out.println(total);
    }
}