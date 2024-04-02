package hanghae.test.Q1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //스위치 개수
        int switchCount = Integer.parseInt(br.readLine());
        //스위치 상태
        StringTokenizer st = new StringTokenizer(br.readLine());
        //index 부분에서 오류가 나는거 같아 수정
        int[] state = new int[switchCount + 1];
        for (int i = 1; i <= switchCount; i++) {
            state[i] = Integer.parseInt(st.nextToken());
        }
        //학생 수
        int students = Integer.parseInt(br.readLine());
        //학생 수 만큼 for문 동작
        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());//성별
            int switchNum = Integer.parseInt(st.nextToken());//받은 스위치 번호
            if (gender == 1) { //남자
                for (int j = switchNum; j <= switchCount; j += switchNum) {//범위 내에 배수
                    state[j] = switchStateChange(state[j]);
                }
            }else if (gender == 2) {//여자
                state[switchNum] = switchStateChange(state[switchNum]);
                for (int j = 1; j < switchNum; j++) {
                    int left = switchNum - j;
                    int right = switchNum + j;
                    if (right > switchCount || left < 0 || state[left] != state[right]) {//대칭 범위 벗어나거나 상태값이 다를 경우 break
                        break;
                    }
                    state[left] = switchStateChange(state[left]);
                    state[right] = state[left];
                }
            }
        }
        //정답
        for (int i = 1; i <= switchCount; i++) {
            sb.append(state[i]).append(" ");
            if (i % 20 == 0){
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    public static int switchStateChange(int state) {
        if (state == 0){
            return 1;
        }
        return 0;
    }
}