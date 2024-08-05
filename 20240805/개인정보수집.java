import java.util.*;
//정규표현식, split, equals
class 개인정보수집 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> arr = new ArrayList<>();

        String[] use_today = today.split("\\.");
        long total = chang_day(use_today);

        String[][] use_terms = new String[terms.length][2];
        for (int i = 0; i < terms.length; i++) {
            String[] sp_terms = terms[i].split(" ");
            use_terms[i][0] = sp_terms[0];
            use_terms[i][1] = sp_terms[1];
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] sp_privacies = privacies[i].split(" ");
            String[] use_privacies = sp_privacies[0].split("\\.");
            long ret = chang_day(use_privacies);
            for (int j = 0; j < use_terms.length; j++) {
                if (sp_privacies[1].equals(use_terms[j][0])) {
                    ret += Integer.parseInt(use_terms[j][1]) * 28;
                    break;
                }
            }
            if (total >= ret)
                arr.add(i + 1);
        }

        int[] sol = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            sol[i]=arr.get(i);
        }

        return sol;
    }

    public static long chang_day(String[] use) {
        long total = 0;
        total += Long.parseLong(use[2]);
        total += (Long.parseLong(use[1]) - 1) * 28;
        total += (Long.parseLong(use[0]) - 1) * 28 * 12;

        return total;
    }
}
