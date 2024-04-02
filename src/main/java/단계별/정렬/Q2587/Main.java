package 단계별.정렬.Q2587;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[5];
        int avg = 0;

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            avg += arr[i];
        }
        Arrays.sort(arr);

        sb.append(avg / 5).append('\n');
        sb.append(arr[2]);
        System.out.println(sb);
    }
}
