class Solution {
    private int Nth(int i, int n){
        int ans =  i;
        for(int p=1;p<n;p++){
            ans =  ans*i;
        }
        return ans;
        
    }
    
    public int nthRoot(int n, int m) {
        // code here
        int l=0, h=m;
        int ans = 0;
        while(l<=h){
           // System.out.println(l+ " " +h);
            int mid = l+(h-l)/2;
            
            int nth = Nth(mid, n);
           // System.out.println("Nth value is"+mid+ " "+nth);
            if(nth == m)return mid;
            if(nth < m){
                //ans = mid;
                l=mid+1;
            }else h=mid-1;
        }
        return -1;
    }
}