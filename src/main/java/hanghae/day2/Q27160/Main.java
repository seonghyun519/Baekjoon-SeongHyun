package hanghae.day2.Q27160;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //펼쳐진 카드 값
        int N = Integer.parseInt(br.readLine());
        //카드의 종류 만큼 배열 생성
        int[] card = new int[4];
        //펼쳐진 카드 수(N) 만큼 for문 동작
        //과일의 종류에 따라 특정 인덱스값 지정하여 값을 추가하는 방식으로 동작
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = IndexFind(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            card[index] += value;
        }
        //과일 종류에 따른 배열을 순회하여 값이 5라면 "YES"출력하고 Main메서드 종료
        for (int i = 0; i < 4; i++) {
            if (card[i] == 5) {
                System.out.println("YES");
                return;
            }
        }
        br.close();
        System.out.println("NO");
    }
    public static int IndexFind (String s) {
        switch (s) {
            case "STRAWBERRY":
                return 0;
            case "BANANA":
                return 1;
            case "LIME":
                return 2;
            case "PLUM":
                return 3;

        }
        return -1;
    }
}