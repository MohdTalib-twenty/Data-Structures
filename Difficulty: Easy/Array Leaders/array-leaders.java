class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        int temp = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(arr[i] >= temp){
                temp = arr[i];
                res.add(temp);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
