class Solution {
    private final int[] dx = {1, 0, 0, -1}; // d, l, r, u
    private final int[] dy = {0, -1, 1, 0};
    private final char[] dir = {'d', 'l', 'r', 'u'}; 
    private boolean found = false;
    private String answer = "";
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dis = Math.abs(x-r) + Math.abs(y-c);
        if(dis>k||(k-dis)%2!=0){
            return "impossible";
        }
        
        dfs(n, m, x, y, r, c, k, 0, new StringBuilder());
        return answer;
        
    }
    private void dfs(int n, int m, int x, int y, int r, int c, int k, int depth, StringBuilder path) {
        if(found){
            return;
        }
        if(depth==k){
            if(x==r&&y==c){
                answer = path.toString();
                found = true;                
            }
            return;
        }
        
        int remain = Math.abs(x - r) + Math.abs(y - c);
        if (remain > k - depth || ((k - depth - remain) % 2 != 0)) return; 
        
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(nx<1||ny<1||nx>n||ny>m){
                continue;
            }
            
            path.append(dir[i]);
            dfs(n,m,nx,ny,r,c,k,depth+1,path);
            path.deleteCharAt(path.length()-1);
        }
        
    }
}