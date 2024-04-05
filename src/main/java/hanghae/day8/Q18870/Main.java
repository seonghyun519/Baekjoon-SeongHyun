package hanghae.day8.Q18870;

import java.io.*;
import java.util.*;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 수직선 위 N개 좌표 X1, X2 ... Xn
 * 좌표 압축
 * 낮은 좌표순으로 Rank 순위는 인덱스 0순위부터
 * 5
 * 2 4 -10 4 -9 //기존 값
 * 0 1 2 3 4 //기존 인덱스
 *
 * -10 -9 -4 2 4 //정렬
 *  2   4  1 0 1 //변경된 인덱스
 *
 *  hashMap 키를 인덱스로 정한다면 값으로 찾는다? 모두 순회해야함.
 *  좌표값을 키로
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 좌표 개수

        //좌표 값
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] orign = new int[N];
        int[] sort = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sort[i] = orign[i] = Integer.parseInt(st.nextToken());
        }
        //키는 좌표값 순위는 값으로 맵에 넣기
        int rank = 0;
        Arrays.sort(sort);
        for (int a : sort) {
            if (!map.containsKey(a)){
                map.put(a, rank);
                rank++;
            }
        }
        //원본 배열 순위 체크
        for (int b : orign) {
            sb.append(map.get(b)).append(" ");
        }
        System.out.println(sb);

    }
}
