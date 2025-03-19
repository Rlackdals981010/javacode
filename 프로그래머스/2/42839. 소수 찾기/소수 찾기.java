import java.util.*;
class Solution {
    public int solution(String numbers) {
        Set<Integer> numberSet = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        findNumber(numberSet,"",visited,numbers);
        
        int ret =0;
        for(Integer use : numberSet){
            if(isPrime(use)){
                ret++;
            }
        }
        return ret;
        
        
    }
    private void findNumber(Set<Integer> numberSet,String current,boolean[] visited, String numbers){
        if(!current.isEmpty()){
            numberSet.add(Integer.parseInt(current));
        }
        
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i]=true;
                findNumber(numberSet, current+numbers.charAt(i),visited, numbers);
                visited[i]=false;
            }
        }
    }
    private boolean isPrime(int num){
        if(num<2) return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0)return false;
        }
        return true;
    }
}