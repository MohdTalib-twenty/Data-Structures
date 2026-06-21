class Solution {
    private int Solve(int i, int n, int[] nums, int target, int[][] dp){
       if(i==n){
           return target == 0 ? 1 : 0;
       }
       if(dp[i][target] != -1)return dp[i][target];
        
        int nt = Solve(i+1,n, nums, target,dp);
        int t =0;
        if(nums[i] <= target){
            t = Solve(i+1,n, nums, target-nums[i],dp);
        }
        
        return  dp[i][target]= t + nt;
    }
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int c=0;
        // if(target == 0){
        //     for(int i=0;i<n;i++){
        //         if(nums[i] == 0)c++;
        //     }
        //     return (int)Math.pow(2,c);
        // }
        int [][] dp = new int[n][target+1] ;
        for(int[] rows: dp){
            Arrays.fill(rows,-1);
        }
        return Solve(0,n,nums,target,dp);
    }
}