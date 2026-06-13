class Solution {
    private long Sum(int[] nums, int mid){
        long sum =0;
        for(int i=0;i<nums.length;i++){
            sum += (nums[i]%mid == 0) ? (nums[i]/mid) : (nums[i]/mid)+1;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int l=1,h=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            h= Math.max(h, nums[i]);
        }
        int ans =-1;
        while(l<=h){
            int m = l+(h-l)/2;
            long sum = Sum(nums, m);
            if(sum <= threshold){
                ans = m;
                h=m-1;
            }else l=m+1;
        }
        return ans;
    }
}