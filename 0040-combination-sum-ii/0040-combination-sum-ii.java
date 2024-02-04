class Solution {
      public List<List<Integer>> backtrack(int start,List<List<Integer>> mainlist,ArrayList<Integer> list,int target,int[] cand){
        if(target<0){
            return mainlist;
        }
        if(target==0){
           mainlist.add(new ArrayList<>(list));
           return mainlist; 
            
        }
        for(int i=start;i<cand.length;i++){
            if(i>start && cand[i]==cand[i-1]){
                continue;
            }
            list.add(cand[i]);
            
            //use element one time
            backtrack(i+1,mainlist,list,target-cand[i],cand);
            
            //backtrack
            list.remove(list.size()-1);
        }
        return mainlist;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> mainlist=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,mainlist,new ArrayList<>(),target,candidates);
        return mainlist;
    }
}