package hanghae.day6.Q9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
괄호 문자열이 열리고 닫힘이 있다면 VPS, 이어서 열리고 이어서 닫힘의 개수가 동일하더라도 VPS, YES 반환
괄호가 열렸을 때 이어지는 닫힘 괄호의 개수가 열린 괄호를 초과하면 틀린 VPS로 NO를 반환
열린 괄호면 스택에 값을 추가하고 닫힌 괄호 스택에 내용을 확인 후 스택에 값을 제거한다. 닫힌 괄호일 때 스택에 값이 존재 하지 않으면 false
정상적으로 조건식이 수행 되었다면 true를 반환

메모리: 14340KB 시간: 128ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        //입력 데이터 수만큼 for문 동작
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            //괄호가 열린 개수와 이어지게 닫힌 개수가 맞을 경우 true 반환하여 삼항 연산자로 YES or NO 추가
            sb.append(solution(str) ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);
    }
    public static boolean solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') { //열린 괄호면 스택에 추가
                stack.push(c);
            } else if (stack.isEmpty()) {//열린 괄호가 스택에 없다면 fasle
                return false;
            }else {//열린 괄호가 아니면 마지막 스택 제거
                stack.pop();
            }
        }
        return stack.isEmpty(); //for문이 정상 종료 되었다면 스택에 '(' 값이 있다면 false 반환
    }
}
