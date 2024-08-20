class Solution {
    public int solution(int[] arr) {
        int ret = arr[0]*arr[1]/get(arr[0],arr[1]);
        
        for(int i=2;i<arr.length;i++){
            ret=ret*arr[i]/get(ret,arr[i]);
        }
        return ret;
    }
    private int get(int a, int b){
        if(b==0)return a;
        return get(b,a%b);        
    }
}