package 단계별.문자와문자열.Q11718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String w;
        while (true) {
            w = br.readLine();
            if (w == null || w.isEmpty()) {
                break;
            }
            sb.append(w).append("\n");;
        }
        System.out.println(sb);
    }
}
