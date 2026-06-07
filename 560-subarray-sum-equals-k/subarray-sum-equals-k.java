class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer>mp = new HashMap<>();
        mp.put(0,1);
        int sum =0;
        int res=0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            if(mp.containsKey(sum-k))res+= mp.get(sum-k);
            if(mp.containsKey(sum))mp.put(sum, mp.get(sum)+1);
            else mp.put(sum, 1);
        }
        return res;
    }
}