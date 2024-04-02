package 단계별.시간복잡도.Q24263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        sb.append(n).append("\n");
        sb.append(1).append("\n");

        System.out.print(sb);
        br.close();
    }
}