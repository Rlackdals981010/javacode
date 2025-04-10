import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> ret = new ArrayList<>();
        for(int c:course){
            Map<String, Integer> map = new HashMap<>();
            int maxCount = 0;
            
            for(String order:orders){
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                makeCombination(chars,new StringBuilder(), 0,c,map);
            }
            
            for(Map.Entry<String,Integer>entry:map.entrySet()){
                int count = entry.getValue();
                if(count>=2&&count>maxCount){
                    maxCount=count;
                }
            }
            for(Map.Entry<String,Integer>entry:map.entrySet()){
                int count = entry.getValue();
                if(count==maxCount&&maxCount>=2){
                    ret.add(entry.getKey());
                }
            }           
      
        }
        Collections.sort(ret);
        return ret.toArray(new String[0]);
        
        
    }
    private void makeCombination(char[] arr, StringBuilder sb, int idx, int target, Map<String, Integer> map){
        if(sb.length()==target){
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            return;
        }
        for(int i=idx; i<arr.length;i++){
            sb.append(arr[i]);
            makeCombination(arr,sb,i+1,target,map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}