import java.util.*;

class Solution {
    static final int[] dy = {-1,0,1,0};
    static final int[] dx = {0,1,0,-1};
    
    private class Node{
        int x;
        int y;    
        
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] vis = new int[n][m];
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, 0));
        vis[0][0] = 1; // 시작점의 거리를 1로 초기화

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int y = node.y, x = node.x;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;     // 범위체크
                if (maps[ny][nx] == 0) continue;                          // 벽 체크
                if (vis[ny][nx] != 0) continue;                           // 이미 방문
                vis[ny][nx] = vis[y][x] + 1;                              // 거리 갱신
                queue.offer(new Node(nx, ny));                            // 큐에 추가
            }
        }

        int answer = vis[n-1][m-1];
        return answer == 0 ? -1 : answer;
    }
}