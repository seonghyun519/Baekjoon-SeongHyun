package 단계별.조건문.Q2753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        int result = a % 4 == 0 && (a % 100 != 0 || a % 400 == 0) ? 1 : 0;
        sb.append(result);
        System.out.println(sb);
        br.close();
    }
}