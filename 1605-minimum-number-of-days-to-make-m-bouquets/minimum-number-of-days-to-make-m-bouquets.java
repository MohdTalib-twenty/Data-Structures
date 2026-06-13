class Solution {
    private boolean isPossible(int[] bloomDay, int m , int k, int cd){
        int n = bloomDay.length;
        int i=0;
        int nbm=0;
        while(i<n){
            if(bloomDay[i]<=cd){
                int tempc =1;
                int j=i+1;
                while(j<n && bloomDay[j]<=cd){
                    if(tempc == k) break;
                    tempc++;
                    j++;
                    
                }
                if(tempc == k){
                    nbm++;
                }
                i=j;
            }else i++;
        }
        return nbm >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int l=1,h=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)h = Math.max(h, bloomDay[i]);
        int ans =-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(isPossible(bloomDay,m,k,mid)){
                ans = mid;
                h= mid-1;
            }else l = mid+1;
        }
        return ans;
    }
}