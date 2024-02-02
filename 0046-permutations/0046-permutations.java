class Solution {
    private void backtrack(List<List<Integer>> resultlist,ArrayList<Integer> templist,int[] nums){
        if(templist.size()==nums.length){
            resultlist.add(new ArrayList<>(templist));
            return;
        }
        
        for(int i : nums){
            if(templist.contains(i))
            {
                continue;
            }
            templist.add(i);
            
            //backtrack
            backtrack(resultlist,templist,nums);
            
            //remove last
            templist.remove(templist.size()-1);
        }
        
    }
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> resultlist=new ArrayList<>();
        backtrack(resultlist,new ArrayList<>(),nums);
        return resultlist;    
    }
}