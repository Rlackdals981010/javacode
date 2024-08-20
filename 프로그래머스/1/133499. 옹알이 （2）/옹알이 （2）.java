class Solution {
    private static final String[] use = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int ret = 0;
        
        for (String val : babbling) {
            boolean hasConsecutive = false;
            
            for (String item : use) {
                if (val.contains(item + item)) {
                    hasConsecutive = true;
                    break;
                }
            }
            
            if (!hasConsecutive) {
                String temp = val;
                for (String item : use) {
                    temp = temp.replace(item, " ");
                }
                temp = temp.replace(" ", "");
                
                if (temp.equals("")) {
                    ret++;
                }
            }
        }
        
        return ret;
    } 
}
