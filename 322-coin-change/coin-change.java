class Solution {
    private int Solve(int i, int[] coins, int sum, int[][] dp){
        if(sum == 0)return 0;
        if(i==0){
            if((sum%coins[0] == 0))return sum/coins[0];
            return (int)1e8;
        }
        if(dp[i][sum] != -1)return dp[i][sum];

        int nt = Solve(i-1, coins, sum,dp);
        int t = (int)1e8;
        if(coins[i] <= sum){
            t = 1+Solve(i,coins,sum-coins[i],dp);
        }
        return dp[i][sum]=Math.min(t, nt);

    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        int res= Solve(n-1,coins,amount,dp);

        return res >= 1e8 ? -1 : res;
    }
}