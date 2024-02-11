class Solution {
    public boolean canJump(int[] nums) {
        int lastposition=nums.length-1;
        
        for(int indx=nums.length-2;indx>=0;indx--){
            if(indx+nums[indx]>=lastposition){
                lastposition=indx;
            }
        }
        return lastposition==0;
    }
}