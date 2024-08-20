import java.util.*;

class Solution {
    public int solution(String s) {
        int ret = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            String rotated = s.substring(i) + s.substring(0, i);  // 문자열 회전
            // 위 코드는 s.substring(i)로 idx=i부터 끝까지 + s.substring(0, i)로 0~i-1 까지 
            if (isValid(rotated)) {
                ret++;
            }
        }

        return ret;
    }

    private boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); //여는 괄호는 무조건 push
            } 
            else {
                if (stack.isEmpty()) { //처음에 닫는 괄호면 무조건 실패
                    return false;                    
                }
                char top = stack.pop(); //아니면 비교
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false; 
                }
            }
        }

        return stack.isEmpty();
    }
}
