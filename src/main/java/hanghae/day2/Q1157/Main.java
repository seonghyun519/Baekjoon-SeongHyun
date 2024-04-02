package hanghae.day2.Q1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //알파벳 갯수만큼 배열
        int[] arr = new int[26];
        String s = br.readLine();

        //문자 갯수 만큼 for문 동작
        for (int i = 0; i < s.length(); i++) {
            //소문자일 경우
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                arr[s.charAt(i) - 97]++; //알파벳 등장 횟수 추가
                //대문자일 경우
            } else {
                arr[s.charAt(i) - 65]++;
            }
        }
        int max = -1;
        char ch = '?';
        //알파벳 갯수 만큼 for문 동작
        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) { //최대값보다 클 때 최대값 수와 알파벳 업데이트
                max = arr[i];
                ch = (char) (i + 65);
            } else if (arr[i] == max) { // 최대값과 동일할 경우 ?로 업데이트
                ch = '?';
            }
        }
        sb.append(ch);
        System.out.print(sb);
    }
}