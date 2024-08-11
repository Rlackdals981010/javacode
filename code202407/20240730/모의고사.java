import java.util.*;
class 모의고사 {
    public int[] solution(int[] answers) {
        int[] arr1= {1,2,3,4,5};
        int[] arr2= {2,1,2,3,2,4,2,5};
        int[] arr3= {3,3,1,1,2,2,4,4,5,5};
        int c1=0;
        int c2=0;
        int c3=0;

        for(int i=0;i<answers.length;i++){
            int coll = answers[i];
            if(coll==arr1[i%arr1.length])c1++;
            if(coll==arr2[i%arr2.length])c2++;
            if(coll==arr3[i%arr3.length])c3++;
        }

        List<Integer> arr = new ArrayList<>();
        int max = Math.max(c1,Math.max(c2,c3));
        if(c1==max)arr.add(1);
        if(c2==max)arr.add(2);
        if(c3==max)arr.add(3);

        int[] ret = new int[arr.size()];
        for(int i=0;i<ret.length;i++){
            ret[i]=arr.get(i);
        }
        return ret;



    }
}