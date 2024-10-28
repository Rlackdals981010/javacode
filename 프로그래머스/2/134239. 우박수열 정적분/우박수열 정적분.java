import java.util.*;

class Solution {

    public double[] solution(int k, int[][] ranges) {        
        double[] ret = new double[ranges.length];
        
        List<Integer> list = new ArrayList<>();
        list.add(k);       
        
        while(k > 1) {
            if(k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            list.add(k);
        }
        
        int n = list.size() - 1;

        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = n + ranges[i][1];
            
            if(a > b) {
                ret[i] = -1.0;
                continue;
            }
            
            double sum = 0.0;
            for(int j = a; j < b; j++) {
                double st = list.get(j);
                double ed = list.get(j + 1);
                sum += (st + ed) / 2;
            }
            ret[i] = sum;            
        }
        
        return ret;
    }
}
