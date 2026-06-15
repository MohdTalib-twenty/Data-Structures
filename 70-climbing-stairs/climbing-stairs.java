class Solution {
    private int Solve(int n, List<Integer>dp){
        if(n==1 || n == 0)return 1;
        if(dp.get(n) != -1)return dp.get(n);
        int ans = Solve(n-1, dp)+Solve(n-2, dp);
        dp.set(n,ans);
        return ans;
    }
    public int climbStairs(int n) {
        List<Integer>dp = new ArrayList<>(Collections.nCopies(n+1, -1));
        return Solve(n,dp);
    }
}