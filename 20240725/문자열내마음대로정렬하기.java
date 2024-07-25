import java.util.*;
class 문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings,new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.charAt(n)==b.charAt(n)){//a가 뒤
                    return a.compareTo(b);
                }
                else return Character.compare(a.charAt(n),b.charAt(n));
            }
        });
        return strings;
    }
}