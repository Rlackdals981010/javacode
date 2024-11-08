class Solution {
    
    public int[] discount = {40, 30, 20, 10};
    private int maxSubscribers = 0; // 최대 가입자
    private int maxSales = 0; // 최대 매출

    public int[] solution(int[][] users, int[] emoticons) {
        
        // 모든 할인율 조합에 대해 가입자 수, 매출액 계산
        calculateDiscounts(0, users, emoticons, new int[emoticons.length]);
        
        return new int[] {maxSubscribers, maxSales};
    }

    private void calculateDiscounts(int depth, int[][] users, int[] emoticons, int[] discounts) {
        if (depth == emoticons.length) {
            // 모든 할인율 조합 완료시 평가
            evaluate(users, emoticons, discounts);
            return;
        }
        
        // 각 이모티콘당 할인율 조합
        for (int d : discount) {
            discounts[depth] = d;
            calculateDiscounts(depth + 1, users, emoticons, discounts);
        }
    }

    private void evaluate(int[][] users, int[] emoticons, int[] discounts) {
        int subscribers = 0; // 현재 가입자 수
        int sales = 0; // 현 매출액

        for (int[] user : users) {
            int userDiscountThreshold = user[0]; // 이 사람의 최소 할인 기준
            int userPriceThreshold = user[1]; // 이 사람의 변환 금액 기준
            int totalCost = 0;
            
            // 각 이모티콘
            for (int i = 0; i < emoticons.length; i++) {
                // 할인가 계산
                if (discounts[i] >= userDiscountThreshold) {
                    int discountedPrice = emoticons[i] * (100 - discounts[i]) / 100;
                    totalCost += discountedPrice;
                }
            }           
            // 초과시 가입자, 이때 구입가격은 매출가에 포함 x
            if (totalCost >= userPriceThreshold) {
                subscribers++;
            } else { // 미가입자는 매출가 o
                sales += totalCost;
            }
        }
        // 최대 가입자와 매출액 업데이트
        if (subscribers > maxSubscribers || (subscribers == maxSubscribers && sales > maxSales)) {
            maxSubscribers = subscribers;
            maxSales = sales;
        }
    }
}
