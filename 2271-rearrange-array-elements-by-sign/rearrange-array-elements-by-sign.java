class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(nums[i] > 0)arr1.add(nums[i]);
            else arr2.add(nums[i]);
        }

        int[] res = new int[n];
        int x=0,y=0, i=0;
        while(i<n){
            res[i++] = arr1.get(x++);
            res[i++] = arr2.get(y++);
        }
        return res;
    }
}