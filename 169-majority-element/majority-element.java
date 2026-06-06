class Solution {
    public int majorityElement(int[] nums) {
       int n = nums.length;
       int el = -1, c=0;
       for(int i=0;i<n;i++){
        if(c == 0){
            el = nums[i];
            c++;
        }else if(nums[i] == el)c++;
        else c--;
       }
       return el;
    }
}