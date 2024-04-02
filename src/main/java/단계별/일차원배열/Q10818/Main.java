package 단계별.일차원배열.Q10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        int[] array = new int[count];
        int min;
        int max;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        min = array[0];
        max = array[0];
        for (int i = 1; i < count; i++) {
            if (max < array[i]) {
                max = array[i];
            } else if (min > array[i]) {
                min = array[i];
            }
        }
        sb.append(min + " " + max);
        System.out.println(sb);
        br.close();
    }
}