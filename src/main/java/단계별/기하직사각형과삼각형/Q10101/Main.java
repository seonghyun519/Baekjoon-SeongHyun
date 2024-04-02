package 단계별.기하직사각형과삼각형.Q10101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        if ((A + B + C) != 180) {
            sb.append("Error");
        } else if (A == B && B == C) {
            sb.append("Equilateral");
        } else if (A == B || B == C || A == C) {
            sb.append("Isosceles");
        } else {
            sb.append("Scalene");
        }
        System.out.println(sb);
    }
}
