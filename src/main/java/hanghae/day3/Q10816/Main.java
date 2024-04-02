package hanghae.day3.Q10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine()); // 숫자 카드 개수
        int m = 0; // 찾을 카드 개수
        HashMap<Integer, Integer> map = new HashMap<>();

        // 숫자 카드 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 카드가 없을 때 코드 리뷰에서 getOrDefault
            if(!map.containsKey(num)) {
                map.put(num, 1);
            }
            // 이미 있는 숫자라면 값 +1
            else {
                map.put(num, map.get(num) + 1);
            }
        }

        // 찾을 카드 갯수
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 같은 카드가 있으면 값 가져옴
            if(map.containsKey(num)) {
                sb.append(map.get(num) + " ");
            }
            // 없으면 0
            else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);
    }
}