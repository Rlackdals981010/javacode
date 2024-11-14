class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long totalDistance = 0;
        int lastDelivery = n;
        int lastPickup = n;

        while (lastDelivery > 0 || lastPickup > 0) {
            
            while (lastDelivery > 0 && deliveries[lastDelivery - 1] == 0) lastDelivery--;
            while (lastPickup > 0 && pickups[lastPickup - 1] == 0) lastPickup--;

            int farthest = Math.max(lastDelivery, lastPickup);
            totalDistance += farthest * 2;

            int capacity = cap;
            for (int i = lastDelivery; i > 0 && capacity > 0; i--) {
                if (deliveries[i - 1] > 0) {
                    int deliver = Math.min(deliveries[i - 1], capacity);
                    deliveries[i - 1] -= deliver;
                    capacity -= deliver;
                }
            }

            capacity = cap;
            for (int i = lastPickup; i > 0 && capacity > 0; i--) {
                if (pickups[i - 1] > 0) {
                    int pickup = Math.min(pickups[i - 1], capacity);
                    pickups[i - 1] -= pickup;
                    capacity -= pickup;
                }
            }
        }
        return totalDistance;
    }
}
