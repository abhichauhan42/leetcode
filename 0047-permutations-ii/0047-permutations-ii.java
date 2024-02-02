class Solution {
       private void backtrack(List<List<Integer>> resultlist,ArrayList<Integer> templist,int[] nums, boolean[] used){
        if(templist.size()==nums.length){
            resultlist.add(new ArrayList<>(templist));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            
            used[i]=true;
            templist.add(nums[i]);
            
            //backtrack
            backtrack(resultlist,templist,nums,used);
            
            //remove last
            used[i]=false;
            templist.remove(templist.size()-1);
        }
        
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultlist=new ArrayList<>();
        Arrays.sort(nums);
        
        backtrack(resultlist,new ArrayList<>(),nums,new boolean[nums.length]);
        return resultlist;
        
    }
}