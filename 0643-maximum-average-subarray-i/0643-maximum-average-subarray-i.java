class Solution {
    public double findMaxAverage(int[] nums, int k) {
         int currentsum=0;
        
        if(nums.length==1){
            return (double)nums[0];
        }
        
        for(int i=0;i<k;i++){
            currentsum+=nums[i];
        }
        
        int maxsum=currentsum;
        
        for(int i=k;i<nums.length;i++){
            currentsum+=(nums[i]-nums[i-k]);
            maxsum=Math.max(currentsum,maxsum);
        }
        
        double ans=(double) maxsum/k;
        return ans;
        
    }
} 
