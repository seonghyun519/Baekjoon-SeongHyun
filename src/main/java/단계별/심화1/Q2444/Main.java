package 단계별.심화1.Q2444;


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n-i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i + (i -1); j++) {
                sb.append("*");
            }
            sb.append('\n');
        }
        for (int i = n -1; i > 0; i--) {
            for (int j = 0; j < n-i ; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i + (i -1); j++) {
                sb.append("*");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}