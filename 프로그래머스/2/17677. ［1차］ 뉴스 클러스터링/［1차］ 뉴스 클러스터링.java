import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        String lowstr1 = str1.toLowerCase();
        String lowstr2 = str2.toLowerCase();
        
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        for (int i = 0; i < lowstr1.length() - 1; i++) {
            String use = lowstr1.substring(i, i + 2);
            if (Character.isLetter(use.charAt(0)) && Character.isLetter(use.charAt(1))) {
                list1.add(use);
            }
        }

        for (int i = 0; i < lowstr2.length() - 1; i++) {
            String use = lowstr2.substring(i, i + 2);
            if (Character.isLetter(use.charAt(0)) && Character.isLetter(use.charAt(1))) {
                list2.add(use);
            }
        }

        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }

        
        ArrayList<String> inter = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        

        for (String s : list1) {

            if (list2.remove(s)) {
                inter.add(s);
            }

            union.add(s);
        }
        union.addAll(list2);

        double jacquard = (double) inter.size() / (double) union.size();
        return (int) (jacquard * 65536);

    }
}