class Solution {
    private int Solve(int[] prices, int i, int t, int n,  ArrayList<ArrayList<Integer>>dp){
        if(t>=2 || i>=n)return 0;
        if(dp.get(i).get(t) != -1)return dp.get(i).get(t);
        int res = 0;
        int buy = 0;
        if(t%2 == 0){//buy
           res =  Math.max(-prices[i]+Solve(prices,i+1,t+1,n, dp), Solve(prices, i+1, t, n, dp));
        }else{
            res = Math.max(prices[i]+Solve(prices,i+1,t+1,n, dp), Solve(prices, i+1, t, n, dp));
        }
        dp.get(i).set(t,res);
        return res;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        ArrayList<ArrayList<Integer>>dp = new ArrayList<>();
        for(int i=0;i<n;i++){
            dp.add(new ArrayList<>(Collections.nCopies(2, -1)));
        }
        return Solve(prices, 0,0,n, dp);
    }
}