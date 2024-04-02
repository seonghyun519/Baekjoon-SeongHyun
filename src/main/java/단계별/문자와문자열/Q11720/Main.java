package 단계별.문자와문자열.Q11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int result = 0;
        int size = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split("");
        for (int i = 0; i < size; i++) {
            result += Integer.parseInt(array[i]);
        }
        sb.append(result);
        System.out.print(sb);
    }
}