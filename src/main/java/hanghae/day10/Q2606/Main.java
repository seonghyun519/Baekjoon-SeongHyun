package hanghae.day10.Q2606;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());//컴퓨터 수
        int C = Integer.parseInt(br.readLine());//컴퓨터간 연결되어있는 간선의 수

        int graph[][] = new int[N + 1][N + 1];//무방향 그래프 이차원 배열
        boolean visited[] = new boolean[N + 1];//정점 방문 기록

        for (int i = 0; i < C; i++) {//간선 수 만큼 for문을 돌며 연결되어있는 정점(배열 인덱스)에 유효값 넣어줌
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        sb.append(dfs(graph, visited, 1) );//문제 1번 컴퓨터가 웜 바이러스 걸렸을 때 연결된 컴퓨터 바이러스 걸린 대수 찾기
        System.out.println(sb);//1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다. 1번은 제외
    }

    private static int dfs(int[][] graph, boolean[] visited, int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true; //스택에 넣으면 방문
        int count = 0;

        while (!stack.isEmpty()) {
            int vertex = stack.pop();//해당 정점의 인접 정점 찾기 위해 스택에서 꺼냄
            for (int i = 1; i < graph.length; i++) {//인접 행렬에서 연결되어 있는 정점 파악
                if (graph[vertex][i] == 1 && !visited[i]) {//해당 행(정점)에서 열(연결된 정점)에 값이 있으면 연결된 정점인지, 방문 리스트를 봤을 때 방문한적 없는 정점인지
                    visited[i] = true; //정점 방문 기록
                    stack.push(i);
                    count++;
//                    System.out.println("i: " + i);
//                    System.out.println("count: " + count);
                }
            }
        }return count;
    }
}
