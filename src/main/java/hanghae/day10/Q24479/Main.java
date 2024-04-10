package hanghae.day10.Q24479;

import java.io.*;
import java.util.*;

/*
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
 * graph 배열 크기 [n + 1][n + 1] 크기로 설정 n의 최댓값이 100,000 이니까
 */
public class Main {
    static int N, M, R;
    static List<Integer> graph[];
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());//정점의 수
        M = Integer.parseInt(st.nextToken());//간선의 수
        R = Integer.parseInt(st.nextToken());//시작 정점
        graph = new ArrayList[N + 1];
        visited = new int[N + 1];
        for (int i = 1; i <= M; i++) {
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
        dfs(R);
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        int cnt = 1;

        while (!stack.isEmpty()) {
            int vertex = stack.pop();//해당 정점의 인접 정점 찾기 위해 스택에서 꺼냄
            if (visited[vertex] == 0) {
                visited[vertex] = cnt++;
                if (graph[vertex] != null) {
                    Collections.sort(graph[vertex], Collections.reverseOrder());//오름차순 stack 1 -> 2,4 -> 4 -> 2,3 -> 3//내림차순으로 변경
                    for (int a : graph[vertex]) {
                        if (visited[a] == 0) {
                            stack.push(a);
                        }
                    }
                }

            }
        }
    }
}
