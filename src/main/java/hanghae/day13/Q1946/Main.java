package hanghae.day13.Q1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
7
3 6
7 3
4 2
1 4
5 7
2 5
6 1
서류 심사 기준 정렬
*서류기준 합격 -인터뷰기준 합격
1 4 *-
2 5
3 6
4 2 *-
5 7
6 1 *-
7 3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N =Integer.parseInt(br.readLine());
            int[] rank = new int[N+1];

            for (int j = 0; j < N; j++) {
                String[] str =br.readLine().split(" ");

                int documentRank = Integer.parseInt(str[0]);
                int interviewRank = Integer.parseInt(str[1]);

                rank[documentRank] = interviewRank;
            }
            int answer = 1; //서류점수 1등 한명 시작
            int standard = rank[1]; //서류점수 1등

            for (int k = 2; k <= N; k++) { //서류 2등부터
                if (rank[k] < standard) {// 서류1등의 인터뷰 등수보다 높으면
                    answer++;
                    standard = rank[k];
                }
            }
            System.out.println(answer);
        }

    }
}
