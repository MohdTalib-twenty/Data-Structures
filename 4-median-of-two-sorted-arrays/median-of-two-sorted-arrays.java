class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if(n > m){
            return findMedianSortedArrays(nums2, nums1);
        }
        int tl = (n+m);
        int ts = (n+m+1)/2;
        int l=0,h=n;
        while(l<=h){
            int m1 = l+(h-l)/2;
            int m2 = ts-m1;

            int r1 = m1 >=n ? Integer.MAX_VALUE: nums1[m1];
            int l1 = (m1-1 >= n || m1-1 <0) ? Integer.MIN_VALUE : nums1[m1-1];

            int r2 = m2 >=m ? Integer.MAX_VALUE: nums2[m2];
            int l2 = (m2-1 >= m || m2-1 < 0) ? Integer.MIN_VALUE : nums2[m2-1];

            if(l1<=r2 && l2<=r1){
                if(tl %2 == 0){
                    return  ( (double)Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }else  return (double) Math.max(l1,l2);
            }else if(l1<=r2)l=m1+1;
            else h= m1-1;
        }
        return -1;
    }
}