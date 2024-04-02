package 단계별.일반수학1.Q2292;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int a = 1;
        int b = 0;
        int count = 1;

        while(n != 1) {
            a += (b * 6);
            if(n <= a) break;

            count++;
            b++;
        }
        sb.append(count);
        System.out.println(sb);
    }
}