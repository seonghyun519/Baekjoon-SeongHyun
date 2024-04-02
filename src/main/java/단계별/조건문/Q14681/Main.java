package 단계별.조건문.Q14681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean a = Integer.parseInt(br.readLine()) > 0;
        boolean b = Integer.parseInt(br.readLine()) > 0;

        if (a) {
            if (b) {
                sb.append(1);
            }else {
                sb.append(4);
            }
        } else if (b) {
            sb.append(2);
        } else {
            sb.append(3);
        }
        System.out.println(sb);
        br.close();
    }
}