package hanghae.test3.Q2212;

import java.io.*;
import java.util.*;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * N개 센서(N개의 센서가 적어도 하나의 집중국과는 통신이 가능해야함)
 * 집중국의 수신 가능영역의 길이는 0 이상œ
 * 각 집중국의 수신 가능영역의 거리의 합의 최솟값
 *
 * 입력
 * 첫째 줄에 센서의 개수 N(1 ≤ N ≤ 10,000), 둘째 줄에 집중국의 개수 K(1 ≤ K ≤ 1000)가 주어진다. 셋째 줄에는 N개의 센서의 좌표가 한 개의 정수로 N개 주어진다. 각 좌표 사이에는 빈 칸이 하나 있으며, 좌표의 절댓값은 1,000,000 이하이다.
 *
 * 첫째 줄에 문제에서 설명한 최대 K개의 집중국의 수신 가능 영역의 길이의 합의 최솟값을 출력한다.
 * 모든 센서의 좌표가 다를 필요는 없다.
 * 1 6 9 3 6 7
 * 13679
 * 2
 * 3
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        //좌표값
        List<Integer> list = new ArrayList<>();
        List<Integer> di = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            list.add(n);
        }
        Collections.sort(list);//오름차순으로 차이 구함
        //차이 구하고
        //다시 내림차순 정렬
        //차이합 구하기
    }
}
