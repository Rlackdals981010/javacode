import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] ret = new int[commands.length];
        for(int x = 0 ; x<ret.length;x++){
            int[] command = commands[x];
            int i = command[0];
            int j = command[1];
            int k = command[2];
            int[] sliced = Arrays.copyOfRange(array,i-1,j);
            Arrays.sort(sliced);
            ret[x]=sliced[k-1];
        }
        return ret;
    }
}