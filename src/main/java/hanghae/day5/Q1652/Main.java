package hanghae.day5.Q1652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//틀림 하나의 행 또는 열에서 누울자리가 하나가 아님 수정 필요
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //정사각형 이차원배열 하나씩 넣는것 보다 String배열로 선언하여 받음
        int N = Integer.parseInt(br.readLine());
        String[] board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }
        boolean location = false; //유효한 자리인지 저장할 수 있는 변수 선언
        int rowCount = 0;//누울자리 행 카운트
        int columCount = 0;// 누울자리 열 카운트
        //유효한 자리가 있는지 행 탐색, 정사각형
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (location) {
                    if (board[i].charAt(j) == '.') {
                        rowCount++;
                        location = false;
                        break;
                    } else location = false;
                } else if (board[i].charAt(j) == '.') {
                    location = true;
                } else location = false;
            }
        }
        //유효한 자리가 있는지 열 탐색, 정사각형
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (location) {
                    if (board[j].charAt(i) == '.') {
                        columCount++;
                        location = false;
                        break;
                    } else location = false;
                } else if (board[j].charAt(i) == '.') {
                    location = true;
                } else location = false;
            }
        }
        sb.append(rowCount).append(" ").append(columCount);
        System.out.println(sb);
    }

//    public static void scanMatrix(int N, boolean isRow, String[] board) {
//        int
//        boolean location = false; //유효한 자리인지 저장할 수 있는 변수 선언
//        int count = 0;//누울자리 카운트
//        //유효한 자리가 있는지 행 탐색, 정사각형
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (location) {
//                    if (board[i].charAt(j) == '.') {
//                        count++;
//                        location = false;
//                        break;
//                    } else {
//                        location = false;
//                    }
//                } else if (board[i].charAt(j) == '.') {
//                    location = true;
//                } else {
//                    location = false;
//                }
//            }
//        }
//    }

}