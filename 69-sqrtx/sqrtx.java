class Solution {
    public int mySqrt(int x) {
        int l=0,h=x;
        int ans = 0;
        while(l<=h){
            int m = l+(h-l)/2;
            long sqr = (long)m*m;
            if(sqr == x)return m;
            else if(sqr < x){
                ans = m;
                l=m+1;
            }else{
                h=m-1;
            }
        }
        return ans;

    }
}