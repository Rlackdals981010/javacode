class Solution {
    

    public int solution(String name) {
        int count = 0 ;
        
        for(int i=0;i<name.length();i++){
            count += toAlphabet(name.charAt(i));
        }
        
        int minMove = name.length() - 1; 
        
        for (int i = 0; i < name.length(); i++) {
            int next = i + 1;
            
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            
            minMove = Math.min(minMove, i + name.length() - next + Math.min(i, name.length() - next));
        }
        
        return count + minMove;             
        
    }
    private int toAlphabet(char y){
        int c = Math.min(y-'A','Z'-y+1);
        return c;
    }
}