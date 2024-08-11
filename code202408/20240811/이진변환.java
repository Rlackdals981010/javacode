class 이진변환 {
    public int[] solution(String s) {
        int cnt_zero=0;
        int cnt_trn=0;

        StringBuilder sb;

        while(!s.equals("1")){
            cnt_trn++;
            sb=new StringBuilder();

            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1'){
                    sb.append(s.charAt(i));
                }
                else{
                    cnt_zero++;
                }
            }
            s=Integer.toBinaryString(sb.length());

        }
        return new int[]{cnt_trn,cnt_zero};

    }
}