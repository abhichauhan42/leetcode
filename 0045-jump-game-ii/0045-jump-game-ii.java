class Solution {
    public int jump(int[] nums) {
        int totaljumps=0;
        
        int dest=nums.length-1;
        int coverage=0,lastJumpidx=0;
        
        if(nums.length==1){
            return 0;
        }
        
        //greedy approach
        for(int i=0;i<nums.length;i++){
            coverage=Math.max(coverage,i+nums[i]);
            
            if(i==lastJumpidx){
                lastJumpidx=coverage;
                totaljumps++;
                
                if(coverage>=dest){
                    return totaljumps;
                }
            }
            
        }
        return totaljumps;
        
    }
}