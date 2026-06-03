class Solution {
    private void Swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i =0;
        while(i<n && nums[i] != 0)i++;
        if(i == n)return ;
        int j= i+1;
        while(j<n ){
            if(nums[j] != 0){
                Swap(nums, i, j);
                i++; j++;
            }else{
                j++;
            }
            
        }
    }
}