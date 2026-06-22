class Solution {
    private int Solve(int i, int n, int[] arr, int sum, int[][] dp){
        if(i==n){
            return sum == 0 ? 1: 0;
        }
        if(dp[i][sum] != -1)return dp[i][sum];
        
        int nt = Solve(i+1,n,arr,sum,dp);
        int t=0;
        if(arr[i] <= sum){
            t= Solve(i+1,n, arr,sum-arr[i],dp);
        }
        
        return dp[i][sum] = nt + t;
    }
    public int countPartitions(int[] arr, int diff) {
        // code here
        int n = arr.length;
        int sum = 0;
        for(int i=0;i<n;i++)sum+=arr[i];
        
        if((sum+diff)%2 != 0)return 0;
        int f= (sum+diff)/2;
        sum = Math.max(sum,diff);
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
        // return dp[n][sum];
        // int res=0;
        // for(int i=1;i<=(sum/2);i++){
        //     int f = i, s= sum-i;
        //     if(dp[0][f] == 1 && dp[0][s] == 1){
        //         if(Math.abs(f-s) == diff)res++;
        //     }
        // }
        // return res;
        return dp[0][f];
        
    }
}
