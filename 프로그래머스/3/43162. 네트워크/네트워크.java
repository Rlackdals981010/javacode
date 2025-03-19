import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] vis = new boolean[n];    
        int ret = 0;
        for(int i=0;i<computers.length;i++){
            if(!vis[i]){                
                ret++;
                connectNetwork(i,vis,computers,n);
            }
        }
        return ret;
    }
    private void connectNetwork(int idx,boolean[] vis,int[][] computers, int n){
        vis[idx]=true;
        for(int i=0;i<n;i++){
            if(!vis[i]&&i!=idx){
                if(computers[idx][i]==1){
                    connectNetwork(i,vis,computers,n);
                }
            }
        }
    }
    
}