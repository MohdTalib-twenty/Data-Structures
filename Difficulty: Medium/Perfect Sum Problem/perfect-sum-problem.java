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
    public int perfectSum(int[] arr, int sum) {
        // code here
        int n = arr.length;
        //int sum = 0;
        // for(int i=0;i<n;i++)sum+=arr[i];
        int[][] dp = new int[n+1][sum+1];
        
        for(int[] rows: dp){
            Arrays.fill(rows, -1);
        }
        // Solve(0,n,arr,sum,dp);
        dp[n][0]=1;
        for(int j=1;j<=sum;j++){
            dp[n][j]=0;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=sum;j>=0;j--){
                int nt = dp[i+1][j];
                int t = 0;
                if(arr[i]<=j){
                    t = dp[i+1][j-arr[i]];
                }
                dp[i][j] = t+nt;
            }
        }
        return dp[0][sum];
    }
}