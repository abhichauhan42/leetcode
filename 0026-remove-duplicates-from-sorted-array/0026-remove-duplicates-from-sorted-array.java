class Solution {
    public int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[count]=nums[i];
                count++;
            }
        }
        
         // Copy the last element
        if (nums.length > 0) {
            nums[count] = nums[nums.length - 1];
            count++;
        }
        return count;
        
    }
}