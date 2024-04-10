package hanghae.day11.Q1182;

import java.io.*;
import java.util.*;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * N개의 정수로 이루어진 수열
 * 크기가 양수인 부분수열 중에서 수열의 원소를
 * 수열이라 순서 신경안써도 되네~
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    static int[] arr;
    static int N, S;//정수의 개수 N, 찾아야하는 원소의 합 S
    static int count;// 유효한 부분수열의 개수
    static boolean[] visited;//

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //1~N개 조합의 합에서 유효값 카운트
        for (int i = 1; i <= N; i++) {
            combination(0, i);
        }
        System.out.println(count);
    }
    public static void combination(
            int start,//시작 값
            int r
    ) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    sum += arr[i]; //부분 수열 합
                }
            }
            if (sum == S){ // 찾고자하는 값과 동일하면 카운트
                count++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(i + 1, r - 1);
            visited[i] = false;
        }
    }
}
