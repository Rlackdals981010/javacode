import java.util.*;

class Solution {
    
    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;        
    
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));         
        
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int distance = node.distance;            
            
            if (x == m - 1 && y == n - 1) {
                return distance;
            }            
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                                
                if (ny >= 0 && ny < n && nx >= 0 && nx < m && maps[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true; 
                    queue.add(new Node(nx, ny, distance + 1));
                }
            }
        }        
     
        return -1;
    }    
    
    static class Node {
        int x, y, distance;
        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
