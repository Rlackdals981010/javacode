class Solution {
    public int solution(int[] arrayA, int[] arrayB) {

        int gcdA = arrayA[0];
        for (int val : arrayA) {
            gcdA = gcd(gcdA, val);
        }

        int gcdB = arrayB[0];
        for (int val : arrayB) {
            gcdB = gcd(gcdB, val);
        }

        if (canDivideNone(gcdA, arrayB)) {
            if (canDivideNone(gcdB, arrayA)) {
                return Math.max(gcdA, gcdB); 
            }
            return gcdA; 
        } else if (canDivideNone(gcdB, arrayA)) {
            return gcdB; 
        }

        return 0; 
    }

    private boolean canDivideNone(int gcd, int[] array) {
        for (int num : array) {
            if (num % gcd == 0) {
                return false;
            }
        }
        return true;
    }


    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
