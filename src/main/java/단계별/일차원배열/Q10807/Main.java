package 단계별.일차원배열.Q10807;

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
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int foundNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            if (foundNum == array[i]){
                result++;
            }
        }
        sb.append(result);
        System.out.println(sb);
        br.close();
    }
}