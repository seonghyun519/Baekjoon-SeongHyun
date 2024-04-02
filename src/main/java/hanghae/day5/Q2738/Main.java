package hanghae.day5.Q2738;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        //행렬 크기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //두 행렬 선언
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        //중복 기능 saveMatrix메서드
        saveMatrix(br, A, N, M);
        saveMatrix(br, B, N, M);
        Math.abs(N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다. 클경우 -1
//                if (Math.abs(A[i][j] + B[i][j]) > 100) {
//                    sb.append("-1 "); 조건식 넣으니 err
                    sb.append(A[i][j] + B[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    //행렬 차례로 원소값 넣음
    public static void saveMatrix(BufferedReader br, int[][] matrix, int N, int M) throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}