import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = check(places[i]) ? 1 : 0;
        }
        
        return answer;
    }

    // 모든 사람이 거리두기를 잘 하고 있는지 체크하는 함수
    // 모두 다 잘 지키고 있으면 return true
    // 한 명이라도 잘 안 지키면 return false
    boolean check(String[] place) { 
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (place[r].charAt(c) == 'P') { // 하나씩 접근하기 위한 용도
                    if (!bfs(r, c, place)) return false; // 거리 2 이하에 사람(P)가 있으면 false 반환
                }
            }
        }
        return true;
    }

    boolean bfs(int startRow, int startCol, String[] place) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {-1, 0, 1, 0};
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            
            if (dist > 2) continue; // 거리가 2를 초과하면 계속 진행
            
            if (dist != 0 && place[r].charAt(c) == 'P') { // 현재 거리가 1 이하일 때 P가 있으면 false
                return false;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && !visited[nr][nc] && place[nr].charAt(nc) != 'X') {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }
        return true;
    }
}
