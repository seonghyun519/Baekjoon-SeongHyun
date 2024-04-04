package hanghae.day7.Q9375;

import java.io.*;
import java.util.*;

/*
예제 입력 -> 정답 5
3 의상수
hat headgear
sunglasses eyewear
turban headgear

headgear = 2
eyewear = 1
경우의 수
headgear(1), headgear(2), eyewear
headgear(1), eyewear
headgear(2), eyewear
2(+1 착용하지 않는 경우의수) X 2(+1) = 6 - 1(맨몸)
----
headgear = 3
eyewear = 2
H1
H2
H3
E1
E2
H1, E1
H1, E2
H2, E1
H2, E2
H3, E1
H3, E2
3(+1 착용하지 않는 경우의수) X 2(+1) = 12 - 1(맨몸)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        //테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            //옷 전체 개수
            int n = Integer.parseInt(br.readLine());
            //hashMap으로 중복 걸러서 값 저장
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();//옷의 이름 필요 없음
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);//의류 타입 값 추가
            }
            //경우의 수 계산, 인덱스 사용 불가 차례대로 값 가져옴
            int totalValue = 1;
            for (int value : map.values()){
                totalValue *= value + 1;
            }
            sb.append(totalValue - 1).append('\n');//맨몸 빼줌
        }
        System.out.println(sb);
    }
}