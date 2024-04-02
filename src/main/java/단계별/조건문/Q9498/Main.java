package 단계별.조건문.Q9498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        String result = (a >= 90 && a <=100) ? "A" : (a >= 80 && a <= 89) ? "B" : (a >= 70 && a <=79) ? "C" : (a >= 60 && a <=69) ? "D" : "F";
        sb.append(result);
        System.out.println(sb);
        br.close();
    }
}