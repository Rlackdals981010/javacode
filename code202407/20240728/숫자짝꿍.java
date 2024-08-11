class 숫자짝꿍 {
    public String solution(String X, String Y) {
        int[] x = new int[10];
        int[] y = new int[10];

        for(int i=0;i<X.length();i++){
            int idx=X.charAt(i)-'0';
            x[idx]++;
        }

        for(int i=0;i<Y.length();i++){
            int idx=Y.charAt(i)-'0';
            y[idx]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9;i>=0;i--){
            int cnt = Math.min(x[i],y[i]);
            for(int j=0;j<cnt;j++)
                sb.append(i);
        }
        String ret = sb.toString();

        if(ret.equals(""))return "-1";
        if (ret.charAt(0) == '0') {
            return "0";
        }
        return ret;
    }
}