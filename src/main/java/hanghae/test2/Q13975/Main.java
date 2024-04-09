package hanghae.test2.Q13975;

import java.io.*;
import java.util.*;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * C1, C2, C3, C4
 * 40, 30, 30, 50
 * 60+100+150=310(C2 + C3= X1(60) / X1 + C1 = X2(100) / X2 + C4 = 최종(150) 총합 310
 * C1+ C2 =Y1(70) / C3 + C4 = Y2(80) / Y1 + Y2 = 최종150 총합 300
 * 60 90  150 = 300 같음
 * 알고리즘 분류 우선순위 큐
 --------------------------------------------------
 문제
 틀렸습니다
 long
 양의 정수 K (3 ≤ K ≤ 1,000,000)
 장부터 K장까지 수록한 파일의 크기를 나타내는 양의 정수 K개가 주어진다. 파일의 크기는 10,000을 초과하지 않는다
 파일의 크기의 합은 10,000  1,000,000 = 10,000,000,000
 int 2,147,483,647 초과
 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());//테스트 케이스 개수
        for (int i = 0; i < T; i++) {
            PriorityQueue<Long> pq = new PriorityQueue<>(); //오름차순 pq
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            long sum = 0;
            while (pq.size() > 1) {//홀수 상관 없이 마지막에 남으면 결과값
                long C = pq.poll();
                long X = pq.poll();
                sum += (C + X);//누적합
                pq.offer(C + X);//현재 최소값 합
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
