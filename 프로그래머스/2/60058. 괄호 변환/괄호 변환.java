import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.equals("")) {
            return p;
        }

        String[] sP = splitW(p);
        String u = sP[0];
        String v = sP[1];

        if (isCorrect(u)) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(solution(v));
            sb.append(')');

            for (int i = 1; i < u.length() - 1; i++) {
                char c = u.charAt(i);
                sb.append(c == '(' ? ')' : '(');
            }

            return sb.toString();
        }
    }

    private boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private String[] splitW(String w) {
        int left = 0, right = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                return new String[]{w.substring(0, i + 1), w.substring(i + 1)};
            }
        }
        return new String[]{w, ""};
    }
}