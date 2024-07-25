class 시저암호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char use = s.charAt(i);
            if (use == ' ') sb.append(' ');
            else {
                if (use >= 'a') {
                    if (use + n > 'z') sb.append((char) (use + n - ('z' - 'a' + 1)));
                    else sb.append((char) (use + n));
                } else {
                    if (use + n > 'Z') sb.append((char) (use + n - ('Z' - 'A' + 1)));
                    else sb.append((char) (use + n));
                }
            }
        }
        return sb.toString();
    }
}