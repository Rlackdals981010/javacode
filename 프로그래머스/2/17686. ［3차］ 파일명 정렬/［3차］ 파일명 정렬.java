import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                String[] f1 =spiltString(o1);
                String[] f2 =spiltString(o2);
                
                int headCompare = f1[0].compareToIgnoreCase(f2[0]);
                if(headCompare!=0){
                    return headCompare;
                }
                
                int n1 = Integer.parseInt(f1[1]);
                int n2 = Integer.parseInt(f2[1]);
                return Integer.compare(n1,n2);
            }            
        });
        return files;       
    }
    private String[] spiltString(String file){
        String head = "";
        String number = "";
        int i=0;
        
        while(i<file.length() && !Character.isDigit(file.charAt(i))){
            head+=file.charAt(i);
            i++;
        }
        while(i<file.length() && Character.isDigit(file.charAt(i))){
            number+=file.charAt(i);
            i++;
            if(number.length()==5)break;
        }
        
        return new String[]{head,number};
    }
}