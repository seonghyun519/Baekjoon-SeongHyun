package 단계별.기하직사각형과삼각형.Q1085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;

        min = Math.min(min, Math.min(x, w-x));
        min = Math.min(min, Math.min (y, h-y));

        sb.append(min);

        System.out.println(sb);
    }
}