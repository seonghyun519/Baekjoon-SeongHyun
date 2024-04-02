package hanghae.day1.Q2480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int num3 = Integer.parseInt(st.nextToken());

        if (num == num2 && num == num3) {
            System.out.println(10000 + (num * 1000));
        } else if (num == num2 || num == num3 || num2 == num3) {
            int match = (num == num2) ? num : (num == num3) ? num : num2;
            System.out.println(1000 + (match * 100));
        } else {
            System.out.println(Math.max(num, Math.max(num2, num3)) * 100);
        }
        br.close();
    }
}