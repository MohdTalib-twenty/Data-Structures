class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer>mp = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++)mp.put(nums[i], i);
        int f =-1; int s=-1;
        for(int i=0;i<n;i++){
            if(mp.containsKey(target-nums[i])){
                f = i;
                s = mp.get(target-nums[i]);
               if(s != f) break; 
            }
        }
        int[] res = {f,s};
        return res;

    }
}