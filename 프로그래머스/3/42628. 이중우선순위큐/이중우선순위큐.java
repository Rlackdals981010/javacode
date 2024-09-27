import java.util.*;
class Solution {
    
    private TreeSet<Integer> ps;
    
    public int[] solution(String[] operations) {
        
        ps = new TreeSet<>(Comparator.naturalOrder());  
        
        for(String operation : operations){
            String[] oper = operation.split(" ");
            if(oper[0].equals("I")){
                addNum(Integer.parseInt(oper[1]));
            }
            if(oper[0].equals("D")){
                if (ps.isEmpty()) continue;
                int use = Integer.parseInt(oper[1]);
                if(use<0){delMin();}
                else{delMax();}
            }
        }
        if(ps.size()==0){
            return new int[]{0,0};
        }
        else{
            return new int[]{ps.last(),ps.first()};
        }
        
        
    }
    private void addNum(int a){
        ps.add(a);
    }
    private void delMax(){        
        ps.pollLast();
    }
    private void delMin(){
        ps.pollFirst();
    }
}