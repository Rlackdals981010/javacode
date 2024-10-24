import java.util.*;

class Solution {

    private static final int[] dx = {-1, 1, 0, 0}; 
    private static final int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        
        int startX = -1, startY = -1, goalX = -1, goalY = -1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                }
                if (board[i].charAt(j) == 'G') {
                    goalX = i;
                    goalY = j;
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        
        boolean[][] visited = new boolean[n][m];
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];
            
            if (x == goalX && y == goalY) {
                return moves;
            }
            
            for (int i = 0; i < 4; i++) {
                int newX = x;
                int newY = y;
                
                while (true) {
                    int nextX = newX + dx[i];
                    int nextY = newY + dy[i];
                    
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || board[nextX].charAt(nextY) == 'D') {
                        break;
                    }
                    
                    newX = nextX;
                    newY = nextY;
                }
                
                if (!visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY, moves + 1});
                }
            }
        }
        
        return -1;
    }
}
