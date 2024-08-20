import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] report_arr = new int[id_list.length];
        HashSet<String> set = new HashSet<String>(Arrays.asList(report));
        report=set.toArray(new String[0]);
        
        HashMap<String,Integer> get_report = new HashMap<>();
        HashMap<String,Integer> get_email = new HashMap<>();
        for(String name : id_list){
            get_report.put(name,0);
            get_email.put(name,0);
        }
        
        for(String report_get : report){ //신고 당한 횟수
            String[] use = report_get.split(" ");
            get_report.put(use[1],get_report.get(use[1])+1);
        }

        for(int i=0;i<report.length;i++){ //이메일 받은 횟수
            String[] use = report[i].split(" ");
            if(get_report.get(use[1])>=k){
                get_email.put(use[0],get_email.get(use[0])+1);
            }
        }
        
        for(int i=0;i<id_list.length;i++){
            String use_name = id_list[i];
            report_arr[i]=get_email.get(use_name);        
        }
        
        
        
        
        return report_arr;
    }
}