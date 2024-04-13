package hanghae.day14.Q11722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 *  {10, 30, 10, 20, 20, 10}
 *  처음 가장 작은수 arr.length
 *  뒤에서 부터 최대값 for문
 *  인덱스 뒤에서 max값
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] str = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        int[] memo = new int[N];
        memo[arr.length-1] = 1;

        for (int i = arr.length-2; i > -1; i--) {
            memo[i] = 1;
            for (int j = arr.length -1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }

        int answer = Arrays.stream(memo).max().getAsInt();
        System.out.println(answer);
    }
}