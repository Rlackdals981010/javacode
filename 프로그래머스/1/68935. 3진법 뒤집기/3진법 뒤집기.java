
class Solution {
    public int solution(int n) {
        String use = Integer.toString(n, 3);   
        StringBuilder sb = new StringBuilder(use);
        sb.reverse();         
        return Integer.parseInt(sb.toString(),3);        
    }
}