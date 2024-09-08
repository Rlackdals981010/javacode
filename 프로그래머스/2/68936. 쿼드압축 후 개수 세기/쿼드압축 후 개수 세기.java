class Solution {
    static int[] ret;
    public int[] solution(int[][] arr) {
        ret = new int[2];
        
        splitArr(arr,0,0,arr.length);
        return ret;
    }
    private void splitArr(int[][] arr, int y,int x, int size){
        if(check(arr,y,x,size)){
            ret[arr[y][x]]++;
            return;
        }
        splitArr(arr,y,x,size/2);
        splitArr(arr,y+size/2,x,size/2);
        splitArr(arr,y,x+size/2,size/2);
        splitArr(arr,y+size/2,x+size/2,size/2);
       
    }
    
    private boolean check(int[][] arr, int y,int x, int size){
        int pivot = arr[y][x];
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(arr[i][j]!=pivot){
                    return false;
                }
            }
        }
        return true;        
    }
}