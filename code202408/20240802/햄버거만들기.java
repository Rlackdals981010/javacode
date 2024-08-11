import java.util.*;

class 햄버거만들기 {
    public int solution(int[] ingredient) {
        ArrayList<Integer> arr = new ArrayList<>();
        int ret = 0;

        for (int val : ingredient) {
            arr.add(val);

            if (arr.size() >= 4) {
                if(arr.get(arr.size() - 1) == 1 &&
                        arr.get(arr.size() - 2) == 3 &&
                        arr.get(arr.size() - 3) == 2 &&
                        arr.get(arr.size() - 4) == 1 ){
                    ret++;
                    arr.remove(arr.size() - 1);
                    arr.remove(arr.size() - 1);
                    arr.remove(arr.size() - 1);
                    arr.remove(arr.size() - 1);
                }

            }
        }
        return ret;
    }
}
