import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 인접 리스트로 변환
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        // 노드 번호가 1부터 시작한다고 가정하고 인접 리스트 초기화
        for (int i = 1; i <= n; i++) {  
            graph.put(i, new ArrayList<>());
        }
        
        // 각 엣지에 대해 양방향 연결을 설정
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);            
        }
        
        // bfs(1) 호출하여 가장 먼 노드의 개수를 반환
        return bfs(graph, 1, n);
    }
    
    int bfs(Map<Integer, List<Integer>> graph, int startVertex, int n) {
        // 시작점 예약
        int maxDist = -1;  // 최대 거리를 저장할 변수 초기화
        int count = 0;     // 최대 거리에 있는 노드의 개수를 저장할 변수 초기화
        
        boolean[] visited = new boolean[n + 1];  // 방문 여부를 체크하는 배열, 노드 번호가 1부터 시작한다고 가정
        Queue<int[]> queue = new ArrayDeque<>(); // BFS 탐색을 위한 큐, 배열 [노드, 거리]를 저장
        queue.offer(new int[]{startVertex, 0});  // 시작 노드와 거리를 큐에 추가
        visited[startVertex] = true;             // 시작 노드를 방문으로 표시
        
        // 큐가 빌 때까지 BFS 탐색
        while (!queue.isEmpty()) {
            // 현재 노드 방문
            int[] cur = queue.poll();   // 큐에서 현재 노드를 꺼냄
            int curVertex = cur[0];     // 현재 노드 번호
            int dist = cur[1];          // 현재 노드까지의 거리
            
            // 새로운 최대 거리가 발견되면 초기화
            if (maxDist < dist) {
                maxDist = dist;         // 최대 거리를 갱신
                count = 1;              // 최대 거리에 있는 노드의 개수를 초기화
            } else if (maxDist == dist) {
                count++;                // 최대 거리가 같은 경우 개수 증가
            }
            
            // 다음 노드를 예약 (현재 노드의 인접 노드들을 순회)
            for (int nextVertex : graph.get(curVertex)) {
                if (!visited[nextVertex]) {      // 인접 노드가 방문되지 않았다면
                    queue.offer(new int[]{nextVertex, dist + 1}); // 인접 노드와 그 노드까지의 거리를 큐에 추가
                    visited[nextVertex] = true;  // 인접 노드를 방문으로 표시
                }
            }
        }
        return count; // 최대 거리에 있는 노드의 개수를 반환
    }
}
