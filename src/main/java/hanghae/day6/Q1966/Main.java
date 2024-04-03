package hanghae.day6.Q1966;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        //케이스 수
        int casCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < casCount; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());//문서 개수
            int M = Integer.parseInt(st.nextToken());//찾고자 하는 큐 순서

            Queue<Integer> queue = new LinkedList<>();
            //중요도 중복 허용하여 TreeMap으로 정렬, 중복 개수 구함
            TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder()); //역순 정렬
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                queue.offer(temp);
                map.put(temp, map.getOrDefault(temp, 0) + 1); //중복된 중요도 개수 추가
            }

            List<Integer> level = new ArrayList<>(map.keySet()); //map 역순으로 저장한 키값 가져옴
            int levelKey = 0; //중요도 key
            int findIndex = M; //찾고자 하는 큐 인덱스
            int printCount = 0; //출력 횟수
            while (!queue.isEmpty()) { //큐에 값이 없으면 false
                int temp = queue.poll();
                int max = level.get(levelKey);
                if (max > temp) { // 큐에서 꺼낸 값이 크지 않다면
                    queue.offer(temp);
                    if (findIndex == 0 && !queue.isEmpty()) { //찾아야하는 큐의 인덱스가 첫번째라면 뒤로 보냄
                        findIndex = queue.size();
                    }
                } else if (queue.isEmpty() || max == temp) { //큐에서 꺼낸 값이 현재 최고 중요도라면 출력
                    printCount++;
                    map.put(temp, map.get(temp) - 1); //중요도 같은 문서 개수 감소
                    if (map.get(temp) == 0) { //현재 중요도의 개수가 0 이면 다음 중요도로 넘어감
                        levelKey++;
                    }
                }
                if (findIndex == 0) {
                    break;
                }
                findIndex--;

            }
            sb.append(printCount).append('\n');
            queue.clear();
        }
        System.out.println(sb);
    }
}