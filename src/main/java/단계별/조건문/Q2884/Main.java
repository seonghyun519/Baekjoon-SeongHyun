package 단계별.조건문.Q2884;

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


        if (m < 45) {
            if (h > 0) {
                h--;
                m = (60 - 45) + m;
            }else {
                h = 23;
                m = (60 - 45) + m;
            }
        }else {
            m = m - 45;
        }
        sb.append(h);
        sb.append(" ");
        sb.append(m);
        System.out.println(sb);
        br.close();
    }
}