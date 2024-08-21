class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        //ab * bc = ac
        int[][] ret = new int[arr1.length][arr2[0].length];
        
        //ret ij = arr1 ix * arr2 xj (0<=x=<arr1[0].length)
        
        for(int i=0;i<ret.length;i++){
            for(int j=0;j<ret[0].length;j++){
                for(int k =0;k<arr1[0].length;k++){
                    ret[i][j]+=arr1[i][k]*arr2[k][j];
                }
            }
        }
        return ret;
        
    }
}