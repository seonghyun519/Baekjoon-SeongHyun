package hanghae.day7.Q11286;

import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11286
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //연산 횟수
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Object> pq = new PriorityQueue<>();
//        PriorityQueue<Object> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (Math.abs(o1) == Math.abs(o2)) {
//                    return o1 - o2;
//                } else {
//                    return Math.abs(o1) - Math.abs(o2);
//                }
//            }
//        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
            }else {
                pq.offer(x);
            }
        }
        System.out.println(sb);
    }
}