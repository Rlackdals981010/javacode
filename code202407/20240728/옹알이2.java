class 옹알이2 {
    private static final String[] use = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int ret = 0;

        for (String val : babbling) {
            boolean hasConsecutive = false;

            for (String item : use) {
                if (val.contains(item + item)) { // 동일 발음이 연속된 경우
                    hasConsecutive = true;
                    break;
                }
            }

            if (!hasConsecutive) { //연속된게 없을때 실행
                String temp = val;
                for (String item : use) {
                    temp = temp.replaceAll(item, " "); //전부 공백으로 바꾸고
                }
                temp = temp.replaceAll(" ", ""); //공백 제거

                if (temp.equals("")) {
                    ret++;
                }
            }
        }

        return ret;
    }
}
