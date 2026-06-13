class Solution {
      private Boolean isPossible(int[] piles, int m, int h){
            int n = piles.length;
            long res =0;
            for(int i=0;i<n;i++){
                if(piles[i] <= m)res++;
                else {
                    res += (piles[i] % m  == 0) ? (piles[i]/m) : (piles[i]/m)+1;
                }

            }
            return res <= h;
        }
    public int minEatingSpeed(int[] piles, int target) {
      
        int n = piles.length;
        int l=1;
        int h=Integer.MIN_VALUE;
        int ans =-1;
        for(int i=0;i<n;i++)h = Math.max(h, piles[i]);

        while(l<=h){
            int m = l+(h-l)/2;
            if(isPossible(piles,m,target)){
                ans =m ;
                h=m-1;
            }else l=m+1;
        }
        return ans;
    }
}