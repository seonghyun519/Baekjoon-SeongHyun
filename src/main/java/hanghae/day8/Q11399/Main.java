package hanghae.day8.Q11399;

import java.io.*;
import java.util.*;
//14516kb	136ms
/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * ATM기 1대 / N명이 대기 /대기인원은 i번 인출하는데 걸리는시간 P분
 * 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값
 * 걸리는시간이 적은 수로 정렬하고 값을 더해주는식으로 진행
 * 5
 * 3 1 4 3 2
 * 정렬 1 2 3 4 5
 * sum = 1 -> 3 -> 6 -> 10 -> 15
 * total = 1+3+6+10+15(35)
 * 첫번째 1 / sum = 1
 * 두번째 2 / sum += 2
 * 세번째 3 / sum += 3
 * 네번째 4 / sum += 4
 * 다섯번째 5 / sum += 5
 *
 * 예제 1
 * 5
 * 3 1 4 3 2
 * 정렬 1 2 3 3 4
 * sum = 1 -> 3 -> 6 -> 9 -> 13
 * total = 1+3+6+9+13(32)
 * 첫번째 1 / sum = 1
 * 두번째 2 / sum += 2
 * 세번째 3 / sum += 3
 * 네번째 4 / sum += 3
 * 다섯번째 5 / sum += 4
 --------------------------------------------------
 *시간복잡도: O(N log N)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //대기인원 N명
        //필요시간 오름차순 정렬 PriorityQueue
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {// 시간복잡도: O(log N)
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        int sum = 0;//정렬된 순서대로 합산
        int total= 0;//현재 총합 + 합산
        while (!pq.isEmpty()){// 시간복잡도: O(log N)
            sum += pq.poll();
            total += sum;
        }
        System.out.println(total);
    }
}
