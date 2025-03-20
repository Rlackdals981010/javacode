import java.util.*;

class Solution {
    
    static final int[] dy = {-1, 0, 1, 0}; 
    static final int[] dx = {0, 1, 0, -1}; 
    
    public int solution(int[][] maps) {
        
        Queue<Integer> yQueue = new LinkedList<>();
        Queue<Integer> xQueue = new LinkedList<>();
        
        int[][] retMap = new int[maps.length][maps[0].length];
        retMap[0][0]=1;
        
        yQueue.offer(0);
        xQueue.offer(0);
        while(!yQueue.isEmpty()&&!xQueue.isEmpty()){
            int y = yQueue.poll();
            int x = xQueue.poll();
            
            for(int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny<0||ny>=maps.length||nx<0||nx>=maps[0].length||maps[ny][nx]==0||retMap[ny][nx]!=0){
                    continue;
                }
                if (retMap[ny][nx] == 0) { // 처음 방문하는 경우만 갱신
                    retMap[ny][nx] = retMap[y][x] + 1;
                    yQueue.offer(ny);
                    xQueue.offer(nx);
                }                
            }           
            
        }
        return retMap[maps.length-1][maps[0].length-1]==0?-1:retMap[maps.length-1][maps[0].length-1];
       
    }
}