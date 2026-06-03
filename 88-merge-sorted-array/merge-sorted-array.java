class Solution {
    private void reverse(int[] nums, int left, int right) {
    while (left < right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        left++;
        right--;
    }
}
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int k = m+n;
       k= k-1;
       int i =m-1, j=n-1;
       while(i>=0 && j>=0){
        if(nums1[i] > nums2[j]){
            nums1[k--] = nums1[i];
            i--;
        }else{
            nums1[k--] = nums2[j];
            j--;
        }
       } 
       
       while(i>=0){
        nums1[k--] = nums1[i];
            i--;
       }
    //    for(int p=0;p<nums1.length;p++){
    //     System.out.println(nums1[p]);
    //    }

       while(j>=0){
        nums1[k--] = nums2[j];
            j--;
       }

    //reverse(nums1, 0, nums1.length-1);
    }
}