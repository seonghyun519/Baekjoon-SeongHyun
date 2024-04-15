package hanghae.day13.Q13164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * N명의 원생 키순 줄세우고 k개의 조로 나누려고 한다.
 * 각 조에 원생 1명은 있어야하며 같은 조에 속한 원생은 서로 인접해야한다.
 * 각 조 티셔츠 맞추는데 맞추는 비용은 가장 키가 큰 원생과 가장 작은 원생의 키 차이만큼 비용 발생
 * K개의 조에 대해 티셔츠 만드는 비용의 합을 최소로 하고 싶어한다.
 *
 * 인접한 항끼리만 조를 편성 할 수 있음!
 *
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] students = new int[N];
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            list.add(students[i] - students[i - 1]);
        }
        Collections.sort(list);
        int sum = 0;
        for (int i = 0; i < N-K; i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}
