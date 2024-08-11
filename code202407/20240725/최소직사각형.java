class 최소직사각형{
    public int solution(int[][] sizes) {
        int left=-1;
        int right=-1;
        for(int[] val : sizes){
            left = Math.max(left,Math.max(val[0],val[1]));
            right = Math.max(right,Math.min(val[0],val[1]));
        }
        return left*right;
    }
}