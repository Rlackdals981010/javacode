class Solution {
    public String solution(int a, int b) {
        int[] month = {0,31,29,31,30,31,30,31,31,30,31,30};
        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        
        int total=b-1;
        for(int i=1;i<a;i++){
            total+=month[i];
        }
        return day[total%7];
        
    }
}