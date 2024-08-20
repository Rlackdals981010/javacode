import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> arr = new HashSet<>();
        
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                arr.add(numbers[i]+numbers[j]);
            }
        }
        
        return arr.stream().sorted().mapToInt(Integer::intValue).toArray();
        
        
        
    }
}