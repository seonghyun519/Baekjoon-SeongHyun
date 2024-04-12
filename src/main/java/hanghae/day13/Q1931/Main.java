package hanghae.day13.Q1931;

import java.io.*;
import java.util.*;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 한개의 회의실 N개의 회의에 대한 사용표 만듬
 * 회의 1 시작시간 끝나는 시간 주어지고 각회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의 최대 개수 찾기
 * 조건
 * 회의가 시작되면 중담 불가
 * 회의가 끝나는것과 동시에 회의는 시작될 수 있음
 * 회의의 시작시간과 끝나는 시간이 같을 수 있음->회의 진행된거임
 *
 * 입력
 * 첫줄 회의의 수 N(1 ≤ N ≤ 100,000)
 * 둘째줄 N+1 줄까지 회의의 정보 회의 시작시간 끝나는 시간
 * 시작 시간과 끝나는 시간 2^31-1보다 작거나
 *
 * (1,4), (5,7), (8,11), (12,14) 를 이용할 수 있다.
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //회의 개수
        Meet[] meets = new Meet[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meets[i] = new Meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        //        인텔리제이 람다 추천
//        Arrays.sort(meets, new Comparator<Meet>() {
//            @Override
//            public int compare(Meet o1, Meet o2) {
//                if (o1.endTime == o2.endTime){//끝나는 시간이 같다면 빠른 시작순
//                    return o1.startTime - o2.startTime;
//                }
//                return o1.endTime - o2.endTime;//회의 빨리 끝나는 순
//            }
//        });
        Arrays.sort(meets, (o1, o2) -> {
            if (o1.endTime == o2.endTime){//끝나는 시간이 같다면 빠른 시작순
                return o1.startTime - o2.startTime;
            }
            return o1.endTime - o2.endTime;//회의 빨리 끝나는 순
        });

        int meetinsCount =0;
        int lastTime = -1;
        for (int i = 0; i < N; i++) {
            if (meets[i].startTime >= lastTime) {//회의가 빨리 끝나는 순으로 반복문, 회의 진행 가능한지확인 = 종료시간과 같거나 진행가능, 종료시간 보다 크거면 진행가능
                meetinsCount++;//미팅 카운트
                lastTime = meets[i].endTime;//끝나는 시간 갱신
            }
        }
        System.out.println(meetinsCount);
    }
    static class Meet{
        int startTime;
        int endTime;

        public Meet(int start, int end) {
            this.startTime = start;
            this.endTime = end;
        }
    }
}