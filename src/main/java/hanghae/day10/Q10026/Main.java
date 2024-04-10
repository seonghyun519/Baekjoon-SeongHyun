//package hanghae.day10.Q10026;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    static int N;
//    static  char[][] g;
//    static  int[] visited;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//        N = Integer.parseInt(st.nextToken());//정점의 수
//        M = Integer.parseInt(st.nextToken());//간선의 수
//        R = Integer.parseInt(st.nextToken());//시작 정점
//        graph = new ArrayList[N+1];
//        visited = new int[N+1];
//        for (int i = 1; i <= N; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x = Integer.parseInt(st.nextToken());
//            int y = Integer.parseInt(st.nextToken());
//            if (graph[x] == null) {
//                graph[x] = new ArrayList<>();
//            }
//            if (graph[y] == null) {
//                graph[y] = new ArrayList<>();
//            }
//            graph[x].add(y);
//            graph[y].add(x);
//        }
//        bfs(R);
//        for (int i = 1; i <= N; i++) {
//                sb.append(visited[i]).append('\n');
//        }
//        System.out.println(sb);
//    }
//    public static void bfs(int start) {
//        Queue<Integer> queue = new LinkedList<>();
//        int cnt = 1;
//        queue.offer(start);
//        while (!queue.isEmpty()) {
//            int vertex = queue.poll();
//            if (visited[vertex] ==0) {
//                visited[vertex] = cnt++;
//                if (graph[vertex] != null){
//                    Collections.sort(graph[vertex]);
//                    for (int a : graph[vertex]){
//                            queue.offer(a); // 큐에 추가
//                    }
//                }
//            }
//        }
//    }
//}