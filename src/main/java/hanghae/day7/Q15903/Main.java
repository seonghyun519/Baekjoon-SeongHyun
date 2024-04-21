package hanghae.day7.Q15903;

import java.io.*;
import java.util.*;

/**
 * --------------------------------------------------
 * 석환이 자연수 카드
 * x + y 합산
 * 계산된 값은 x, y번 카드에 덮어 쓴다.
 * 합산을 m번 하고 n장의 카드에 쓰여있는 수를 모두 더한 값이 점수
 * 점수를 가장 작게 만드는게 목표
 *
 * 가장 적은 점수를 계산하는 프로그램 필요
 *
 * 입력 첫째 카드의 개수n 카드 합체 횟수 m
 * 입력 두번째 n개의 카드의 값
 *
 * 예제 입력 1
 * 3 1 // n3개의 카드 m1번의 놀이
 * 3, 2, 6 // 2, 3이 가장 작으므로 선택하여 합산하고 해당 값을 합산값으로 변경
 * 5, 5, 6
 *
 * 예제 출력 1
 * 16
 *
 * 우선 순위큐 생성 기본이 오름차순이니 따로 정렬 필요 없음
 * 횟수만큼 2개의 값을 꺼내서 더해주고 더한값을 두번 넣어주는식으로 진행
 *
 * --------------------------------------------------
//출력값 타입 고려하지 않아 틀림 int -> long변경 통과
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //카드 개수
        int m = Integer.parseInt(st.nextToken()); //놀이 횟수
        //디폴트 오름차순
        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }
        //놀이 횟수 만큼 for문 동작
        for (int i = 0; i < m; i++) {
            long sum = pq.poll() + pq.poll();//낮은 수 두개 합
            pq.offer(sum); //합산 값 넣기
            pq.offer(sum); //합산 값 넣기2
        }
        //총합
        long total = 0;
        while (!pq.isEmpty()){
            total += pq.poll();
        }
        sb.append(total);
        System.out.println(sb);
    }
}