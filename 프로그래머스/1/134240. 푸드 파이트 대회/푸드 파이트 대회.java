class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<food.length;i++){
            food[i]/=2;
        }
        
        for(int i=0;i<food.length;i++){
            for(int j=0;j<food[i];j++){
                sb.append(i);
            }
        }
        String ret = sb.toString();
        ret+="0";
        ret+=sb.reverse().toString();
        
        return ret;
        
        
        
    }
}