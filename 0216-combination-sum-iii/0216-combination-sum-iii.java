class Solution {
          public List<List<Integer>> backtrack(List<List<Integer>> mainlist,ArrayList<Integer> list,int n,int start,int[] nums,int k){
        if(n<0){
            return mainlist;
        }
        if(n==0){
            if(list.size()==k){
           mainlist.add(new ArrayList<>(list));
           return mainlist; 
            }      
        }
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            
            //use element one time
            backtrack(mainlist,list,n-nums[i],i+1,nums,k);
            
            //backtrack
            list.remove(list.size()-1);
        }
        return mainlist;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> mainlist=new ArrayList<>();
        int[] nums=new int[9];
        for(int i=1;i<=9;i++){
            nums[i-1]=i;
        }
        backtrack(mainlist,new ArrayList<>(),n,0,nums,k);
        return mainlist;
        
    }
}