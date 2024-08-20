class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row_len = arr1.length;
        int col_len =arr1[1].length;
        int[][] ret = new int[row_len][col_len];
        
        for(int i=0;i<row_len;i++){
            for(int j=0;j<col_len;j++){
                ret[i][j]=arr1[i][j]+arr2[i][j];
            }
        }
        return ret;
    }
}