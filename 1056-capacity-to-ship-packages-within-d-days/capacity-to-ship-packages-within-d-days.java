class Solution {
    private boolean isPossible(int[] weights, int m, int days){
        int sum =0, c=0;
        for(int i=0;i<weights.length;i++){
            if(weights[i] > m)return false;
            sum += weights[i];
            if(sum > m){
                sum = weights[i];
                c++;
            }
            
        }
        if(sum <= m)c++;
        return c <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int l=1,h=0;
        for(int i=0;i<n;i++)h+= weights[i];
        int ans =-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(isPossible(weights, m, days)){
                ans = m;
                h=m-1;
            }else l=m+1;
        }
        return ans;

    }
}