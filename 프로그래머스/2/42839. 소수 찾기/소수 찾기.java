import java.util.*;
class Solution {
    
    static boolean[] visited;
    static Set<Integer> primes = new HashSet<>();
    
    public int solution(String numbers) {       
        String[] arr = numbers.split("");
        visited = new boolean[arr.length];
        
        // 모든 자리수 조합으로 소수 찾기
        for (int i = 0; i < arr.length; i++) {
            visited[i]=true;
            dfs(arr, arr[i]);
            visited[i]=false;
        }  
        
        return primes.size();
    }
    
    private void dfs(String[] arr, String str){
        int num = Integer.parseInt(str);
        if(check(num)){
            primes.add(num);
        }
        
        if(str.length()==arr.length){
            return;
        }
        
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(arr,str+arr[i]);
                visited[i]=false;
            }
        }
    }
        
    
    private boolean check(int chk){
        if (chk < 2) return false;
        for(int i=2;i<=Math.sqrt(chk);i++){
            if(chk%i==0) return false;
        }
        return true;
    }
}