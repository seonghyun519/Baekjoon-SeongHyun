package hanghae.day2.Q2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        //StringBuilder의 reverse메서드로 문자열 뒤집기
        int a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int b = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        //삼항연산자 쓰니깐 Math.max 추천하는 인텔리제이
        sb.append(a>b ? a:b);
        System.out.println(sb);
    }
}