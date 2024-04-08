package hanghae.day10.Q24479;

import java.io.*;
import java.util.*;

/**
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * N개의 정점 M개의 간선
 * 정점 번호 1~N, 모든 간선의 가중치 1
 * 정점 R에서 시작하여 DFS으로 노드를 방문 할 경우 방문 순서 출력
 * 깊이 우선 탐색 의사 코드는 다음과 같다. 인접 정점은 "오름차순"으로 방문한다.
 * 입력
 * 첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)이 주어진다.
 * 다음 M개 줄에 간선 정보 u v가 주어지며 정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸다. (1 ≤ u < v ≤ N, u ≠ v) 모든 간선의 (u, v) 쌍의 값은 서로 다르다.
 *
 * 입력 받을때 정점을 인덱스로 사용하니 정렬 필요는 없고 마지막에 출력할때 sort?
 * 방문 기록순으로 가져오니 정렬 필요 없음
 * 출력 마지막에 0, 없으면 0만 출력, 있어도 마지막에 0출력
 *
 * 문제
 * 메모리 초과
 * graph 배열 크기 [n + 1][n + 1] 크기로 설정 n의 최댓값이 100,000 이니까 제곱하면 약 10,000,000,000 크기
 *
 --------------------------------------------------

 * 그리고 각 핵심코드에 1)의도를 설명하는 주석 2)의미를 명료하게 밝히는 주석을 적습니다.
 아래 코드 참고

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());//정점 수
        int M = Integer.parseInt(st.nextToken());//간선의 수
        int R = Integer.parseInt(st.nextToken());//시작 정점

        List<Integer> graph[] = new List[N + 1];//무방향 그래프 이차원 배열
        boolean visited[] = new boolean[N + 1];//정점 방문 기록

        for (int i = 0; i < M; i++) {//간선 수 만큼 for문을 돌며 연결되어있는 정점(인덱스)에 유효값 넣어줌
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (graph[x] == null) {//.isEmpty nullpointException null체크
                graph[x] = new ArrayList<>();
            }
            if (graph[y] == null) {
                graph[y] = new ArrayList<Integer>();
            }
            graph[x].add(y);
            graph[y].add(x);
        }
        dfs(graph, visited, R);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                sb.append(i).append('\n');
            }
        }
        sb.append(0);
        System.out.println(sb);
    }

    private static void dfs(List[] graph, boolean[] visited, int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true; //정점 방문 기록

        while (!stack.isEmpty()) {
            int vertex = stack.pop();//해당 정점의 인접 정점 찾기 위해 스택에서 꺼냄
            if (graph[vertex] != null) { //해당 행(정점)에서 리스트의 값(연결된 정점)이 있으면 연결된 정점이 있는지
                for (Object a : graph[vertex]) {
                    int index = (int) a;
                    if (!visited[index]) {// 방문 리스트를 봤을 때 방문한적 없는 정점인지
                        stack.push(index);
                        visited[index] = true;
                    }
                }
            }
        }
    }
}