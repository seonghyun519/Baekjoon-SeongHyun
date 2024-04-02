package hanghae.day2.Q1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //인자값으로 받아와서 기본 구분자(띄어쓰기)를 기준으로 나누는 StringTokenizer를 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        //countTokens() 메서드를 활용 전체 토큰수 반환
        sb.append(st.countTokens());
        System.out.print(sb);
    }
}

//참고 StringTokenizer와 Split의 차이
//https://velog.io/@effirin/Java-StringTokenizer%EC%99%80-Split-%EB%A9%94%EC%84%9C%EB%93%9C-%EC%96%B8%EC%A0%9C-%EC%8D%A8%EC%95%BC%ED%95%A0%EA%B9%8C
//팀 코드 리뷰에서 트림으로 앞뒤 공백 제거 문자열의 " " 공백을 (공백 아스키코드 = 32)를 기준으로 체크하신분 신선했음.