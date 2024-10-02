class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] featMap = new int[n][m];
        
        // 웅덩이
        for (int i = 0; i < puddles.length; i++) {
            int y = puddles[i][1] - 1; 
            int x = puddles[i][0] - 1; 
            featMap[y][x] = -1;        
        }
        
        
        for (int i = 0; i < n; i++) {
            if (featMap[i][0] == -1) {
                break; 
            }
            featMap[i][0] = 1;
        }
        
        for (int i = 0; i < m; i++) {
            if (featMap[0][i] == -1) {
                break; 
            }
            featMap[0][i] = 1;
        }

        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (featMap[i][j] == -1) {
                    continue; 
                }
                if (featMap[i-1][j] != -1) {
                    featMap[i][j] += featMap[i-1][j] % 1000000007;
                }
                if (featMap[i][j-1] != -1) {
                    featMap[i][j] += featMap[i][j-1] % 1000000007;
                }
                featMap[i][j] %= 1000000007;
            }
        }

        return featMap[n-1][m-1]; 
    }
}
