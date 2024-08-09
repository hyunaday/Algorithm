import java.util.*;

class Solution {
    // 기본 setting 값
    public int solution(int[][] maps) {
      int n = maps.length; // 행
      int m = maps[0].length; // 열
        boolean[][] visited = new boolean[n][m]; // 방문여부 체크
        Queue<int[]>queue = new ArrayDeque<>(); // BFS 탐색을 위한 큐
        
        // BFS 탐색 시작점 추가 : (0,0)과 거리를 큐에 추가
        queue.add(new int[] {0,0,1}); // (n, m, dis)
        visited[0][0] = true; // 시작위치 : 방문으로 표시
        // 4방향 배열, 상하좌우
        int[] dr = {0,1,0,-1}; // 열
        int[] dc = {-1,0,1,0}; // 행
        
        // 큐가 비어있지 않은 동안 BFS 탐색
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int r = cur[0], c =cur[1], dist = cur[2];
            
            if (r==n-1&&c==m-1) {
                return dist;
            }
            
            // 5*5(n*m) 범위 내에서 이동할 때
            for(int d = 0; d<4; d++) {
                // 다음 위치 계산, 현재 + 다른방향 거리
                int nr = r+dr[d], nc=c+dc[d];
                // n과 m은 0부터 n,m까지 이동 가능, 상하좌우 중 1칸씩만 이동
                if(nr>=0 && nr <n && nc>=0 && nc<m &&  maps[nr][nc] ==1 ) {
                    if(!visited[nr][nc]) {
                        visited[nr][nc] = true; 
                        queue.add(new int[] {nr, nc, dist+1});
                    }
                    
                }
            }
        }
        return -1;
    }
}