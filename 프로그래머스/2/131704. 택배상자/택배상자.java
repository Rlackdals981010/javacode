import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int result = 0;  
        int idx = 0;  
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 1; i <= order.length; i++) { //지금 순서
            //지금 순서에 일치하는 상자인경우
            if (order[idx] == i) {
                result++;
                idx++;
            } 
            //스택에서 지금 처리 가능한 산자가 있는 경우
            else if (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                result++;
                idx++;
                i--; // 스택에서 처리했으므로 i를 증가시키지 않음
            } 
            // 박스를 스택에 쌓아야 하는 경우
            else {
                stack.push(i);
            }
        }
        
        // 스택에 남아있는 박스를 처리하는 루프
        while (!stack.isEmpty() && stack.peek() == order[idx]) {
            stack.pop();
            result++;
            idx++;
        }
        
        return result;
    }
}
