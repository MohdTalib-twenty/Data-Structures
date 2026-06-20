class Solution {
    private boolean Solve(int i, int[] nums, int sum, int[][] dp){
        if(sum == 0)return true;
        if(i>=nums.length)return false;

        if(dp[i][sum] != -1)return dp[i][sum] == 1 ? true :false;
        boolean nt = Solve(i+1,nums, sum, dp);
        boolean t = false;
        if(nums[i] <= sum){
            t = Solve(i+1,nums, sum-nums[i], dp);
        }
        boolean res = t || nt;
        dp[i][sum] = res == true ? 1: 0;
        return res;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int i=0;i<n;i++)sum += nums[i];
        if(sum%2 != 0)return false;
        sum = sum/2;
        int[][] dp = new int[n][sum+1];
        for(int[] r: dp){
            Arrays.fill(r, -1);
        }
        return Solve(0,nums,sum,dp);
    }
}