import java.util.*;
class Solution {
    public String solution(String s) {
        String use="";
        String[] arr = s.split(" ");
        
        for(int i=0;i<arr.length;i++){
            if(arr[i].length()!=0){                
                use+=arr[i].substring(0,1).toUpperCase();
                use+=arr[i].substring(1,arr[i].length()).toLowerCase();
            }      
            use+=" ";
            
        }
        if(use.length()==s.length())
            return use;
        return use.substring(0,use.length()-1);
    }
}