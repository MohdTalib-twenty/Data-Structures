class Solution {
    private static Boolean Solve(int i, int n, int []arr, int sum,int[][] dp){
        
        if(sum == 0)return true;
        if(i>=n)return false;
        // int x = dp.get(i).get(sum);
        int x = dp[i][sum];
        if(x != -1){
            return x== 1 ? true: false;
        }
        Boolean t =false;
        Boolean nt =Solve(i+1,n,arr,sum,dp); 
        if(arr[i]<=sum){
            t= Solve(i+1,n,arr,sum-arr[i],dp);
        }
        boolean res = t || nt;
        // dp.get(i).set(sum, res == true ? 1 : 0);
        dp[i][sum] = res == true ?1 : 0;
        return t || nt;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        // List<List<Integer>>dp = new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     List<Integer>temp = new ArrayList<>(Collections.nCopies(sum+1, -1));
        //     dp.add(temp);
        // }
        int[][] dp = new int[n][sum+1];
        for(int [] rows : dp){
            Arrays.fill(rows, -1);
        }
        return Solve(0,n,arr,sum, dp);
    }
}