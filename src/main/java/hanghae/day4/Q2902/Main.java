package hanghae.day4.Q2902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        //for문에서 nextToken()으로 가져올 때 Toekn이 빠지면서 st.countTokens() 감소하여 for문이 정상 동작하지 않음/ 예제 KM까지 출력
        int count = st.countTokens();

        for (int i = 0; i < count; i++) {
            sb.append(st.nextToken().charAt(0));
        }
        System.out.println(sb);
    }
}