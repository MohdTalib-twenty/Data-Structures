class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j] = temp;
    }
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n==1)return n;
        int i=0,j=1;
        while(j<n){
            if(nums[j] == nums[i])j++;
            else{
                i++;
                nums[i]= nums[j];
                j++;
            }
        }
        return i+1;
    }
}