class Solution {
    private boolean isPossible(int[] stalls, int m, int k){
        int n = stalls.length;
        int cs = stalls[0];
        int c=1;
        for(int i=1;i<n;i++){
            if(stalls[i]-cs >= m){
                c++;
                cs = stalls[i];
            }
        }
        return c >= k;
    }
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n = stalls.length;
        int l=0,h = stalls[n-1];
        int ans = -1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(isPossible(stalls, m, k)){
                ans = m;
                l=m+1;
            }else h=m-1;
        }
        return ans;
    }
}