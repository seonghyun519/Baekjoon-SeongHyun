package hanghae.day14.Q11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 이 클래스는 사용자가 지정한 최대 값까지 소수를 구한다.
 * 알고리즘은 에라스토테네스 체다.
 * 2에서 시작하는 정수 배열을 대상으로 작업한다.
 * 처음으로 남아 있는 정수를 찾아 배수를 모두 제거한다.
 * 배열에 더 이상 배수가 없을 때까지 반복한다.
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
        memo[0] = 1;

        for (int i = 1; i < N; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }

        int answer = Arrays.stream(memo).max().getAsInt();
        System.out.println(answer);
    }
}
