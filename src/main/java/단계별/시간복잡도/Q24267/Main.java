package 단계별.시간복잡도.Q24267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long n = Long.parseLong(br.readLine());

        sb.append(n*(n-1)*(n-2)/6).append("\n");
        sb.append(3).append("\n");

        System.out.print(sb);
        br.close();
    }
}