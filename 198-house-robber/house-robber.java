class Solution {
    int Solve(int i, int n,int[] nums, List<Integer>dp){
        if(i>=n)return 0;
        if(dp.get(i) != -1)return dp.get(i);
        int t = nums[i]+Solve(i+2,n,nums,dp);
        int nt = Solve(i+1,n, nums, dp);
        int res = Math.max(t, nt);
        dp.set(i,res);
        return res;
        

    }
    public int rob(int[] nums) {
        int n = nums.length;
        List<Integer>dp = new ArrayList<>(Collections.nCopies(n, -1));
        return Math.max(Solve(0,n,nums, dp), Solve(1,n, nums, dp));
    }
}