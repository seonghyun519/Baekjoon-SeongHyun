package hanghae.day5.Q16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//에러 체크 필요/////////////////////////////////////////////////////////////////////////////////////////
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
//            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); //2중 for문 없이 for문 하나로 가능 -출처 영우님/에러 자바 버전?
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //회전 그룹 갯수
        int rotateGroupCount = Math.min(N, M) / 2;

        //시계 반대 방향 증감 값, 행열 구분
        int[] rowValue = {0, 1, 0, -1};
        int[] columValue = {1, 0, -1, 0};

        for (int i = 0; i < R; i++) { //회전 횟수만큼 for문 동작
            for (int j = 0; j < rotateGroupCount; j++) { //회전 그륩
                int row = j;
                int colum = j;
                int temp = arr[row][colum];

                int index = 0;
                while (index < 4) {
                    int sumRow = row + rowValue[index];
                    int sumColum = colum + columValue[index];
                    if (sumRow < N - j && sumColum < M-j && sumRow >= j && sumColum >=j) {
                        arr[row][colum] = arr[sumRow][sumColum];
                        row = sumRow;
                        colum = sumColum;
                    } else {
                        index++;
                    }
                    arr[j+1][j] = temp;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}