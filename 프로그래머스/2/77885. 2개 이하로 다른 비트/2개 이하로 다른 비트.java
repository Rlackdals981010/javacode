class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];

            if (n % 2 == 0) {
                answer[i] = n + 1;
            } 
            else {

                long bit = 1;
                while ((n & bit) != 0) { //해당 위치가 1이면
                    bit <<= 1;//2배 해서 10 .. 이런식임
                }
                answer[i] = n + bit - (bit >> 1);
                // 그러면 이건 최초 0을 1로 바꾸고, 뒤에는 원복한느것.
            }
        }
        
        return answer;
    }
}