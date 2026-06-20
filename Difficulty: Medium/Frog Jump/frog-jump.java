class Solution {
    
    private int Solve(int i, int[] height, List<Integer>dp){
        
        if(i == 0)return 0;
        if(dp.get(i) != -1)return dp.get(i);
        
        int one = Math.abs(height[i]- height[i-1])+ Solve(i-1,height,dp);
        int two = Integer.MAX_VALUE;
        if(i-2 >= 0){
            two = Math.abs(height[i]- height[i-2])+ Solve(i-2,height,dp);
        }
        
        int res = Math.min(one, two);
        dp.set(i,res);
        return res;
    }
    int minCost(int[] height) {
        // code here
        int n = height.length;
        List<Integer>dp = new ArrayList<>(Collections.nCopies(n,-1));
        return Solve(n-1, height, dp);
    }
}