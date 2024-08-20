class Solution {
    public int solution(int[] numbers) {
        int[] arr = new int[10];
        arr[0]=0;        
        for(int i=1;i<arr.length;i++)
            arr[i]=arr[i-1]+i;
        
        int max = arr[arr.length-1];
        for(int val:numbers)
            max-=val;
        
        return max;
    }
}