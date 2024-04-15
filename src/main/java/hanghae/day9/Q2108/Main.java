package hanghae.day9.Q2108;

import java.io.*;
import java.util.*;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 이 클래스는 사용자가 지정한 최대 값까지 소수를 구한다.
 * 알고리즘은 에라스토테네스 체다.
 * 2에서 시작하는 정수 배열을 대상으로 작업한다.
 * 처음으로 남아 있는 정수를 찾아 배수를 모두 제거한다.
 * 배열에 더 이상 배수가 없을 때까지 반복한다.
 --------------------------------------------------

 문제
 수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

 산술평균 : N개의 수들의 합을 N으로 나눈 값
 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

 입력
 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.

 출력
 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
 둘째 줄에는 중앙값을 출력한다.
 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
 넷째 줄에는 범위를 출력한다.

 산술평균 : N개

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        //산술평균---------
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        sb.append(Math.round((double) sum/N)).append('\n');

        //중앙값------
        int[] arrSort = arr;
        Arrays.sort(arrSort);
        int center = arrSort.length/2;
        sb.append(arrSort[center]).append('\n');
        //최빈값----------
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : arrSort) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        int maxKey = 0;
        //최빈 값
        for (int n : map.keySet()) {
            max = Math.max(max, map.get(n));
        }
        //최빈값이 두개인지
        List<Integer> list = new ArrayList<>();
        for (int n : map.keySet()) {
            if (map.get(n) == max) {
                list.add(n);
            }
        }
        if (list.size() >= 2) {
            sb.append(list.get(1)).append('\n');//2개 이상이면 두번째
        }else {
            sb.append(list.get(0)).append('\n');
        }

        //범위 최대값 최솟값 차이
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int n : arrSort) {
            maxValue = Math.max(maxValue, n);
            minValue = Math.min(minValue, n);
        }
        sb.append(maxValue-minValue).append('\n');

        System.out.print(sb);

    }
}
