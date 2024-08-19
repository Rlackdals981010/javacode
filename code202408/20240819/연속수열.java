import java.util.*;

class 연속수열 {
    public int solution(int[] elements) {
        HashSet<Integer> uniqueSums = new HashSet<>();
        int n = elements.length;

        for (int counter = 1; counter <= n; counter++) {
            for (int i = 0; i < n; i++) { //시작점
                int sum = 0;
                for (int j = 0; j < counter; j++) { //카운터
                    sum += elements[(i + j) % n];
                }
                uniqueSums.add(sum);
            }
        }

        return uniqueSums.size();
    }
}
