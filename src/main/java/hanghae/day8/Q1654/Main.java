package hanghae.day8.Q1654;

import java.io.*;
import java.util.*;

/**
 * --------------------------------------------------
 * 입력
 * 첫째 줄에는 오영식이 이미 가지고 있는 랜선의 개수 K, 그리고 필요한 랜선의 개수 N이 입력된다. K는 1이상 10,000이하의 정수이고,
 * N은 1이상 1,000,000이하의 정수이다. 그리고 항상 K ≦ N 이다. 그 후 K줄에 걸쳐 이미 가지고 있는 각 랜선의 길이가 센티미터 단위의 정수로 입력된다. 랜선의 길이는 231-1보다 작거나 같은 자연수이다.
 * 출력
 * 첫째 줄에 N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력한다.
 * --------------------------------------------------
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());//랜선의 개수
        int N = Integer.parseInt(st.nextToken());//필요한 랜선의 개수

        long max = 0;
        //Binary search는 기본적으로 인덱스를 활용
        long[] arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        //fifo
        long start = 1;
        long end = max;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
//            long sum = Arrays.stream(arr).map(e -> e/mid).sum();
            for (int i = 0; i < K; i++) {//잘라진 랜선의 개수 합
                sum += (arr[i] / mid);
            }
            if (sum >= N) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}