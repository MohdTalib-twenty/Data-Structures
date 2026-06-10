class Solution {
    private void SWap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int maxProduct(int[] nums) {
        int n = nums.length;
        long maxi = nums[0];
        long mini = nums[0];

        int res=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i] < 0){
                long temp = maxi;
                maxi = mini;
                mini = temp;
            }

            maxi = Math.max(nums[i], (long) nums[i]*maxi);
            mini = Math.min(nums[i], (long)nums[i]*mini);

            res = Math.max(res, (int)maxi);
        }
        return res;
    }
}