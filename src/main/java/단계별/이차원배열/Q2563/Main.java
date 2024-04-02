package 단계별.이차원배열.Q2563;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[][] paper = new boolean[100][100];

        int count = 0;
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for (int i = 90 - x; i < 100 - x; i++) {
                for (int j = y; j < y+10; j++) {
                    if (!paper[i][j]) {
                        paper[i][j] = true;
                        ++count;
                    }
                    if (paper[i][j]) {
                        continue;
                    }
                }
            }
        }
        sb.append(count);
        System.out.println(sb);
    }
}