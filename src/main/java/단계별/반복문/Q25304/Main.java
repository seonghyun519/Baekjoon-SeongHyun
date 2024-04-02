package 단계별.반복문.Q25304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalM = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        int lastTotalM = 0;
        StringTokenizer st;

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lastTotalM += a * b;
        }
        if (totalM == lastTotalM) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
        br.close();
    }
}