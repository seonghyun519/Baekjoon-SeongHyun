package hanghae.day7.Q2075;

import java.io.*;
import java.util.*;

/**
 * --------------------------------------------------
 * 알고리즘 우선순위 큐 / 정렬
 * 우선순위 큐 내림차순으로 받고 N번째 큰수 출력
 * --------------------------------------------------
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        //기본 오름차순 Collections.reverseOrder() 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //N X N
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 1; i < N; i++) {//N번째 전 큐 비우고
            pq.poll();
        }
        sb.append(pq.poll());
        System.out.println(sb);
    }
}