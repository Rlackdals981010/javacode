import java.util.*;

class Solution {
    public int[] solution(String s) {

        String[] tuple = s.substring(2, s.length() - 2).split("\\},\\{");
        
        Arrays.sort(tuple, new Comparator<String>() {            
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }            
        });
        
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();
        
        for (String str : tuple) {
            String[] values = str.split(",");
            for (String value : values) {        
                uniqueNumbers.add(Integer.parseInt(value));
            }
        }
                
        int[] ret = new int[uniqueNumbers.size()];
        int index = 0;
        for (Integer num : uniqueNumbers) {
            ret[index++] = num;
        }
        
        return ret;
    }
}
