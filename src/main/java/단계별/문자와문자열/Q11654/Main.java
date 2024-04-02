package 단계별.문자와문자열.Q11654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char result = br.readLine().charAt(0);
        sb.append((int) result);
        System.out.print(sb);
    }
}