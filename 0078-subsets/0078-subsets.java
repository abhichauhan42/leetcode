class Solution {
    
    public List<List<Integer>> sets(int[] nums,int i,ArrayList<Integer> list){
        ArrayList<List<Integer>> mainlist=new ArrayList<>();
        if(i==nums.length){
            mainlist.add(new ArrayList<>(list));
            return mainlist;
        }
        
        //for yes choice
        list.add(nums[i]);
        mainlist.addAll(sets(nums,i+1,list));
        list.remove(list.size()-1);
        //for No choice
        mainlist.addAll(sets(nums,i+1,list));
        
        return mainlist;
    }
    public List<List<Integer>> subsets(int[] nums) {
        return sets(nums,0,new ArrayList<>());
    }
}