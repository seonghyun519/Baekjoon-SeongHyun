package hanghae.day5.Q2566;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int row= 0;
        int column = 0;
        int max = 0;
        //배열 선언했다가 삭제함 재탐색할 필요 없고 바로 최대값을 갱신, 중복시에 하나만 출력되어도 된다는 조건
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (max < value) { //최대값 보다 크다면
                    max = value; //최대값 갱신
                    row = i; //행 갱신
                    column = j; //열 갱신
                }
            }
        }
        //인덱스 0부터 시작이라 행과 열에 +1
        sb.append(max).append("\n").append(row + 1).append(" ").append(column + 1);
        System.out.println(sb);
    }
}