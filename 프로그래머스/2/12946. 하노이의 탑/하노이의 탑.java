import java.util.*;
class Solution {
    ArrayList<int[]> ret;
    
    public int[][] solution(int n) {
        
        ret = new ArrayList<>();
        
        move(n,1,3);
        
        int[][] result = new int[ret.size()][2];
        for (int i = 0; i < ret.size(); i++) {
            result[i][0] = ret.get(i)[0];
            result[i][1] = ret.get(i)[1];            
        }
        return result;
        
        
        
    }
    // n개의 원판을 first에서 destination으로 옮기기
    private void move(int n, int first, int destination){
        if(n==1){            
            ret.add(new int[]{first,destination});
            return;
        }
        move(n-1, first, 6-first-destination); // 시작 -> 중간
        ret.add(new int[]{first,destination});
        move(n-1,6-first-destination,destination); // 중간 -> 목표
        
    }
}