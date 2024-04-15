package hanghae.day14.Q1149;

import java.io.*;
import java.util.*;
/*
 * 1번 집 색은 2번 집의 색과 같지 않아야한다.
 * N번 집의 색 N-1 집의 색과 같지 않아야함
 * rgbrgb
 * gbrgbr
 * brgbrg
 * 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
 */
//탑다운 방식 생각 해볼것

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] rgbCost = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            rgbCost[i][0] = Integer.parseInt(st.nextToken()); //R
            rgbCost[i][1] = Integer.parseInt(st.nextToken()); //G
            rgbCost[i][2] = Integer.parseInt(st.nextToken()); //B
        }

        for (int i = 1; i < n; i++) {
            rgbCost[i][0] += Math.min(rgbCost[i - 1][1], rgbCost[i - 1][2]);
            rgbCost[i][1] += Math.min(rgbCost[i - 1][0], rgbCost[i - 1][2]);
            rgbCost[i][2] += Math.min(rgbCost[i - 1][0], rgbCost[i - 1][1]);
        }

        int min = rgbCost[n - 1][0];
        for (int i = 1; i < 3; i++) {
            min = Math.min(min, rgbCost[n - 1][i]);
        }
        System.out.println(min);
    }
}
