package 단계별.일차원배열.Q10871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int foundNum = Integer.parseInt(st.nextToken());
        int[] array = new int[count];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < count; i++) {
            if (foundNum > array[i]){
                sb.append(array[i] + " ");
            }
        }
        System.out.println(sb);
        br.close();
    }
}