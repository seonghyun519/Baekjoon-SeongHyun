package 단계별.심화1.Q2444;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 2 * n - 1; i++) {
            if (i <= n) {
                for (int j = 1; j <= n - i; j++) {
                    sb.append(" ");
                }
                for (int j = 1; j <= 2 * i - 1; j++) {
                    sb.append("*");
                }
            } else {
                for (int j = 1; j <= i % n; j++) {
                    sb.append(" ");
                }
                for (int j = 1; j <= (2 * n - 1) - 2 * (i % n); j++) {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }
        br.close();

    }
}