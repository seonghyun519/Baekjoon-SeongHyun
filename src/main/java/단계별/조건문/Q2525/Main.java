package 단계별.조건문.Q2525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt((br.readLine()));

        int total = (h * 60) + m + t;
        h = total / 60;
        h = h < 24 ? h : h > 24 ? h - 24 : 0;
        m = total % 60;

        sb.append(h);
        sb.append(" ");
        sb.append(m);
        System.out.println(sb);
        br.close();
    }
}