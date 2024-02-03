class Solution {
    
     public List<List<Integer>> backtrack(List<List<Integer>> mainlist,ArrayList<Integer> list,int[] nums,int start){
        mainlist.add(new ArrayList<>(list)); 
        for(int i=start;i<nums.length;i++){
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
        //for yes choice
        list.add(nums[i]);
        backtrack(mainlist,list,nums,i+1);
        list.remove(list.size()-1);
        }
        return mainlist;
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> mainlist=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(mainlist,new ArrayList<>(),nums,0);
        return mainlist;
    }
}