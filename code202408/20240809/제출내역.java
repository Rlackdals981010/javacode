class 제출내역 {
    public String solution(String s) {
        String[] arr=s.split(" ");
        int[] nums = new int[arr.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(arr[i]);
        }

        int max = nums[0];
        int min = nums[0];
        for(int i=1;i<nums.length;i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        String ret = min+" "+max;
        return ret;


    }
}