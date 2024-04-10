package hanghae.day11.DFSBFS_Q2644;

import java.io.*;
import java.util.*;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 촌수 계산
 * 가족, 친척 사이 관계 촌수라는 단위
 * 부모 자식 관계 1촌, 나와 할아버지 2촌, 아버지 형제들과 할아버지 1촌, 나와 아버지 형제들과 3촌
 *
 *
 * 입력
 * 첫째 줄 전체 사람의 수 n
 * 사람들은 1,2,3... n 으로 연속된 번호 / 1<= n <=100
 *
 * 둘째 줄
 * 촌수를 계산해야하는 서로 다른 두사람의 번호
 *
 * 세째 줄
 * 부모 자식들 간의 관계 개수 m
 *
 * 넷째 줄
 * 부모 자식간의 관계를 나타내는 두 번호 x, y
 * x= y의 부모 번호
 *
 * 부모는 한명만 주어짐
 *
 * 본인에서 관계를 시작할 때 관계가 없으면 멈춤
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    static List<Integer> graph[]; //관계
    static int n, m, findOne, findTwo; //사람수n, 관계수m, 찾을놈1 start, 찾을놈2 end
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //전체 사람의 수
        graph = new ArrayList[n + 1];
        visited = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        findOne = Integer.parseInt(st.nextToken());//찾아야할 놈1
        findTwo = Integer.parseInt(st.nextToken());//찾아야할 놈2
        m = Integer.parseInt(br.readLine()); //관계 개수

        for (int i = 0; i < m; i++) { //관계 개수 만큼 for문
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (graph[x] == null) {
                graph[x] = new ArrayList<>();
            }
            if (graph[y] == null) {
                graph[y] = new ArrayList<>();
            }
            graph[x].add(y);
            graph[y].add(x);

        }
        dfs();
        int result = visited[findTwo] > 0 ? visited[findTwo] : -1;//촌수 없으면 -1 응답
        System.out.println(result);
    }

    private static void dfs() {
        Stack<Integer> stack = new Stack<>();
        stack.push(findOne);
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            if (temp == findTwo) {//찾으면 반복문 종료
                return;
            }
            if (graph[temp] != null) { //관계가 없는게 아니면
                for (int index :graph[temp]) { //현재 찾은놈의 관계 털기
                    if (visited[index] == 0) { //현재 찾는놈 촌수 없으면
                        visited[index] =  visited[temp] + 1; //기존 촌수 + 1촌 값 입력
                        stack.push(index);
                    }
                }
            }
        }
    }
}
