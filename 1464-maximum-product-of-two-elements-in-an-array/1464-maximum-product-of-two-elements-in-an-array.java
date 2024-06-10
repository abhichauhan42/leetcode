class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        
        int maxpro=0;
        
        for(int i=0;i<n-1;i++){
            int j=i+1;
            maxpro=Math.max(maxpro,(nums[i]-1)*(nums[j]-1));
        }
        return maxpro;
    }
}