package hanghae.day5.Q1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int coulum = Integer.parseInt(st.nextToken());
        String[] checkBoard = {"WBWBWBWB", "BWBWBWBW"};

        String[] board = new String[row];
        for (int i = 0; i < row; i++) {
            board[i] = br.readLine();
        }
        //최소값을 저장할 변수 선언
        int min = Integer.MAX_VALUE;
        findMin:
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= coulum - 8; j++) {
                //블랙 화이트 시작 각각 비교 후 최소값 구하기
                int whiteMin = getWhiteStartMin(i,j,board,checkBoard);
                int blackMin = getBlackStartMin(i,j,board,checkBoard);
                if (whiteMin == 0 || blackMin == 0){
                    min = 0;
                    break findMin;
                    //라벨로 for문 종료
                }
                int whiteBlackMin = Math.min(whiteMin, blackMin);
                if (min > whiteBlackMin){
                    min = whiteBlackMin;
                }
            }
        }
        sb.append(min);
        System.out.println(sb);
    }

    public static int getWhiteStartMin(int checkRow, int checlColum, String[] board, String[] checkBoard) {
        int startWhite = 0;
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int row =  checkRow + i;
            for (int j = 0; j < 8; j++) {
                //checkBoard white로 인덱스 지정해서 charAt 문자열 인덱스 값을 찾아오는거에서 오류
                //startWhite 값 추가로 변경....
                if (board[row].charAt(checlColum + j) != checkBoard[startWhite].charAt(j)){
                    count++;
                }
            }
            startWhite = startWhite == 0 ? 1 : 0;
        }
        return count;
    }
    public static int getBlackStartMin(int checkRow, int checlColum, String[] board, String[] checkBoard) {
        int startBlack = 1;
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int row =  checkRow + i;
            for (int j = 0; j < 8; j++) {
                if (board[row].charAt(checlColum + j) != checkBoard[startBlack].charAt(j)){
                    count++;
                }
            }
            startBlack = startBlack == 1 ? 0 : 1;
        }
        return count;
    }
}