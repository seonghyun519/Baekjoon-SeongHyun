package hanghae.day6.Q2346;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("1 ");//첫번째 시작

        int count = Integer.parseInt(br.readLine());
        //풍선 위치와 종이의 값을 확인하기 위해 덱 생성
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> dequeIndex = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        //첫번째 값 확인
        int paperNum = Integer.parseInt(st.nextToken());
        //두번째 부터 deque 값, 인덱스 저장
        for (int i = 2; i <= count; i++) {
            int temp = Integer.parseInt(st.nextToken());
            deque.offerLast(temp);
            dequeIndex.offerLast(i);
        }
        for (int i = 2; i <= count; i++) {
            int pn = paperNum;
            int[] valueTemp = new int[Math.abs(pn) - 1];
            int[] indexTemp = new int[Math.abs(pn) - 1];
            if (paperNum > 0) {
                for (int j = 0; j < pn - 1; j++) {
                    valueTemp[j] = deque.pollFirst();
                    indexTemp[j] = dequeIndex.pollFirst();
                }
                paperNum = deque.pollFirst();
                sb.append(dequeIndex.pollFirst()).append(" ");
                if (valueTemp.length > 0) {
                    for (int j = valueTemp.length - 1; j >= 0 ; j--) {
                        deque.offerFirst(valueTemp[j]);
                        dequeIndex.offerFirst(indexTemp[j]);
                    }
                }
            }else {//음수에서 걸림--------------------
                for (int j = 0; j < valueTemp.length - 1; j--) {
                    valueTemp[j] = deque.pollLast();
                    indexTemp[j] = dequeIndex.pollLast();
                }
                paperNum = deque.pollLast();
                sb.append(dequeIndex.pollLast()).append(" ");
                if (valueTemp.length > 0) {
                    for (int j = valueTemp.length - 1; j >= 0 ; j--) {
                        deque.offerLast(valueTemp[j]);
                        dequeIndex.offerLast(indexTemp[j]);
                    }
                }
            }

        }

//        eque.offerFirst(1); // 덱 앞쪽에 1 추가
//        deque.offerLast(2); // 덱 뒤쪽에 2 추가
//        System.out.println(deque.peekFirst()); // 덱 앞쪽 요소 조회: 1
//        System.out.println(deque.peekLast()); // 덱 뒤쪽 요소 조회: 2
//        deque.pollFirst(); // 덱 앞쪽 요소 제거
//        deque.pollLast(); // 덱 뒤쪽 요소 제거
        System.out.println(sb);
    }
}