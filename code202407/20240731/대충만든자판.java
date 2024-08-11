class 대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] ret = new int[targets.length];

        for(int i = 0; i < targets.length; i++) { // 각 타겟에 대해
            String target = targets[i];

            for(char point : target.toCharArray()) { // 타겟의 각 문자에 대해
                int min =102;

                for(String key : keymap) { // 각 키맵 문자열에 대해
                    int index = key.indexOf(point);
                    if(index != -1) {
                        min = Math.min(min, index + 1);
                    }
                }

                if(min == 102) { // 문자를 찾을 수 없는 경우
                    ret[i] = -1;
                    break;
                } else {
                    ret[i] += min;
                }

            }
        }

        return ret;
    }
}
