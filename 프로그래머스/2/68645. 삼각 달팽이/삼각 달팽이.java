import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        if(n == 1) {
            return new int[]{1};
        }
        
        int[][] mat = new int[n][n]; 
        int[] ret = new int[(n + 1) * n / 2]; 
        
        int now = 1;
        int y = 0, x = 0;
        mat[y][x] = now++;
        
        int c = 1; // 1: 아래로, 2: 오른쪽으로, 3: 대각선 위로
        while(now <= (n + 1) * n / 2) {
            if(c == 1) { 
                if(y + 1 == n || mat[y + 1][x] != 0) { 
                    c = 2; 
                    continue;
                }
                y++;
            } else if(c == 2) { 
                if(x + 1 == n || mat[y][x + 1] != 0) { 
                    c = 3; 
                    continue;
                }
                x++;
            } else if(c == 3) { 
                if(y - 1 < 0 || x - 1 < 0 || mat[y - 1][x - 1] != 0) { 
                    c = 1; 
                    continue;
                }
                y--;
                x--;
            }
            mat[y][x] = now++;
        }
        
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) { 
                ret[idx++] = mat[i][j];
            }
        }
        
        return ret;
    }
}
