class Solution {
    public List<List<Integer>> backtrack(List<List<Integer>> mainlist,ArrayList<Integer> list,int[] nums,int start,int k){
        
        if(list.size()==k){
            mainlist.add(new ArrayList<>(list));
            return mainlist;
        }
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(mainlist,list,nums,i+1,k);
            list.remove(list.size()-1);
        }
        return mainlist;
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> mainlist=new ArrayList<>();
                int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }

        backtrack(mainlist,new ArrayList<>(),nums,0,k);
        return mainlist;
        
    }
}