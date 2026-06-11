class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l =0,h=n-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(nums[m] == target)return m;
            else if(nums[m] > nums[0]){
                if(nums[0] <= target && nums[m] >= target){
                    h=m-1;
                }else l=m+1;
            }else{
                if(m+1 <n && nums[m+1] <= target && nums[h] >= target){
                    l=m+1;
                }else h= m-1;
            }
        }
        return -1;
    }
}