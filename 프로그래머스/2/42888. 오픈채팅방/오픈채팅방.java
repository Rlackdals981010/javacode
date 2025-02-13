import java.util.*;

class Solution {
    public String[] solution(String[] record) {       
        
        ArrayList<String[]> toRet = new ArrayList<>(); 
        HashMap<String,String> name = new HashMap<>();
        
        
        for(String use : record){
            String[] ment = new String[2];
            String[] splitUse = use.split("\\s+");
            if (splitUse[0].equals("Enter")){
                ment[0]=splitUse[1];
                ment[1]="님이 들어왔습니다.";         
                name.put(splitUse[1], splitUse[2]); // ID → 닉네임 업데이트
                toRet.add(ment); // 메시지 리스트 추가
            }
            else if (splitUse[0].equals("Leave")){
                ment[0]=splitUse[1];
                ment[1]="님이 나갔습니다.";
                toRet.add(ment);
            }
            else{
                name.put(splitUse[1],splitUse[2]);    
            }           
            
        }
        
        String[] ret = new String[toRet.size()];
        for(int i=0;i<toRet.size();i++){
            String[] ment = toRet.get(i);
            ret[i] = name.get(ment[0])+ment[1];
        }
        
        return ret;     
        
        
    }
}