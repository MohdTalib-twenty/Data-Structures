class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res= new ArrayList<>();
        res.add(new ArrayList<>(Collections.nCopies(1,1)));
        for(int i=1;i<n;i++){
            List<Integer> temp = new ArrayList<>(Collections.nCopies(i+1, 1));
            for(int j=1;j<i;j++){
                int t = res.get(i-1).get(j-1)+ res.get(i-1).get(j);
                temp.set(j, t);
            }
            res.add(temp);
        }
        return res;
    }
}