import java.util.*;
class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] ret = new int[commands.length];
        for(int i=0;i<ret.length;i++){
            int start= commands[i][0]-1;
            int last= commands[i][1]-1;
            int target= commands[i][2]-1;
            if(start==last){
                ret[i]=array[start];
            }
            else{
                int len = last-start+1;
                int[] arr = new int[len];
                for(int j=start;j<=last;j++){
                    arr[j-start]=array[j];
                }
                Arrays.sort(arr);

                ret[i]=arr[target];
            }

        }
        return ret;
    }
}