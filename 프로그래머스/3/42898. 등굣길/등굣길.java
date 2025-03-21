class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // m이 x고 n이 y임
        int[][] dp = new int[n+1][m+1];
        boolean[][] isPuddle = new boolean[n+1][m+1];
        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            isPuddle[y][x] = true;
        }
        
        dp[1][1]=1;
        for(int y=1;y<=n;y++){
            for(int x=1;x<=m;x++){
                if (isPuddle[y][x]) {
                    dp[y][x] = 0;
                    continue;
                }
                if(x>1){dp[y][x]=(dp[y][x]+dp[y][x-1])%1000000007;}
                if(y>1){dp[y][x]=(dp[y][x]+dp[y-1][x])%1000000007;}                
            }
        }
        return dp[n][m];
        
        
        
        
    }
}