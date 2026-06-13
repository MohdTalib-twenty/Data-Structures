class Solution {
    private boolean isPossible(int[] nums, int m, int k){
        int sum =0;
        int c=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > m)return false;
            sum += nums[i];
            if(sum > m){
                c+=1;
                sum = nums[i];
            }
        }
        return c <= k;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(n < k)return -1;
        //Arrays.sort(arr);
        int l = Integer.MAX_VALUE, h= 0;
        for(int i=0;i<n;i++){
            l = Math.min(l, nums[i]);
            h += nums[i];
        }
        int ans = -1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(isPossible(nums,m,k)){
                ans = m;
                h=m-1;
            }else l=m+1;
        }
        return ans;
    }
}