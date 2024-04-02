package hanghae.day3.Q24265;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long n = Long.parseLong(br.readLine());

        sb.append((n*(n-1))/2).append("\n");
        sb.append(2);

        System.out.print(sb);
        br.close();
    }
}
//        int n = 7;
//        int sum = 0;
//        for (int i = 1; i <= n-1; i++) { 6
//            for (int j = i = 1; i <= n; j++) { 7
//                sum++;
//            }
//        }
//등차수열/ 가우스 합 공식