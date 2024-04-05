package hanghae.day8.Q2805;

import java.io.*;
import java.util.*;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 상근이 M미터 나무 필요
 * 나무는 한줄로 이어져 있음
 * 나무의 H높이를 절단기 H높이로 잘라서 필요한 나무길이 M을 구해야함
 * 절단기의 최대 높이 값을 출력해야함
 * 4 7
 * 20 15 10 17
 * 17
 * 3 0 0 0
 * 이분 탐색?
 * 19 부터 빼면 안되나..
 * 19 -> 1 0 0 0
 * 18 -> 2 0 0 0
 * 17 -> 3 0 0 0
 * 16 -> 4 0 0 1
 * 15 -> 5 0 0 2 = 7
 --------------------------------------------------
 * 최소값 10 최대값 20
 * 10 + 20 = 30/2
 * 15
 * ---
 * 5 20
 * 4 42 40 26 46
 *
 * mid로 시작
 * mid = 최소0 최대값 46 = 46/2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());//나무 개수
        int M = Integer.parseInt(st.nextToken());//필요한 나무 길이

        int[] t = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            t[i] = Integer.parseInt(st.nextToken());//각 나무 길이 넣기
            max = Math.max(max, t[i]);
        }

        int start = 0;
        while (start <= max) {
            int mid = (start + max) / 2; // 나무를 자르는 높이
            long total = 0;
            for (int i = 0; i < N; i++) {
                if (t[i] > mid) {
                    total += t[i] - mid;
                }
            }
            //자르는 높이 감소
            if (total < M) {
                max = mid - 1;
            }
            //자르는 높이 증가
            else {
                max = Math.max(max, mid);
                start = mid + 1;
            }
        }
        System.out.println(max);
    }
}