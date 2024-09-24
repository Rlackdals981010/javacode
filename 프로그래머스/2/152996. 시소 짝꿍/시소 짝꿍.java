import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long ret = 0;
        
        Arrays.sort(weights);
        
        double[] length = {2.0 / 2, 2.0 / 3, 2.0 / 4, 3.0 / 4};
        Map<Double, Integer> countMap = new HashMap<>();
        
        for(int weigth:weights){
            for(double len : length){
                double a = weigth*len;
                if(countMap.containsKey(a)) ret += countMap.get(a);                
            }
            countMap.put((double)weigth,countMap.getOrDefault((double)weigth,0)+1);
        }
        return ret;
        
    }
}
