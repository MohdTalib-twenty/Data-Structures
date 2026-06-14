class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int n = a.length;
        int m = b.length;
        if(m < n)return kthElement(b,a,k);
        
        int l=Math.max(0,k-m);
        int h= Math.min(n,k);
        while(l<=h){
            int mid = l+(h-l)/2;
            int r1 = (mid >=n) ? Integer.MAX_VALUE : a[mid];
            int l1 = (mid-1 < 0) ? Integer.MIN_VALUE : a[mid-1];
            int mid2 = k-mid;
            int r2 = (mid2 >=m) ? Integer.MAX_VALUE : b[mid2];
            int l2 = (mid2-1 < 0) ? Integer.MIN_VALUE : b[mid2-1];
            
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }else if(l1<=r2)l =mid+1;
            else h=mid-1;
            
        }
        return -1;
    }
}