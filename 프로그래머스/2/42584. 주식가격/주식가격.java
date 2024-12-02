import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] ret = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();                        
        
        for(int i=0;i<prices.length;i++){
            while(!stack.empty()&&prices[i]<prices[stack.peek()])
            {
                int top = stack.pop();
                ret[top]=i-top;
            }
            stack.push(i);                
                  
        }
        
        while(!stack.empty()){
            int top = stack.pop();
                ret[top]=prices.length-top-1;
        }
        return ret;
    }
}