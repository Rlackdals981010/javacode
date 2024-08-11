class 문자열나누기 {
    public int solution(String s) {
        int ret =0;
        char first = s.charAt(0);
        int[] arr = {1,0}; //first 추가해둠

        for(int i=1;i<s.length();i++){
            if(arr[0]==arr[1]){ //같으면
                ret++; //전체 개수 증가
                first = s.charAt(i);
            }
            if(s.charAt(i)==first){
                arr[0]++;
            }
            else{
                arr[1]++;
            }

        }
        ret++;
        return ret;
    }
}