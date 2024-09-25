import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        Arrays.sort(data, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[col-1]==o2[col-1]){
                    return Integer.compare(o2[0], o1[0]);
                }
                return Integer.compare(o1[col - 1], o2[col - 1]);      
            }
        });
        
        int[] S = new int[data.length];
        for(int i=0;i<S.length;i++){
            for(int val : data[i]){
                S[i]+=val%(i+1);
            }
        }
        int ret = 0;
        for(int i=row_begin-1;i<row_end;i++){
            ret = ret ^ S[i];
        }
        return ret;
        
        
    }
}