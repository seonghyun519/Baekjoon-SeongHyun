package 단계별.문자와문자열.Q27866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        int i = Integer.parseInt(br.readLine());
        sb.append(S.charAt((i - 1)));

        br.close();
        System.out.println(sb);
    }
}