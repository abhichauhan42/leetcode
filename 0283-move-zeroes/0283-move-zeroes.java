class Solution {
    public void moveZeroes(int[] nums) {
        int count=0;
        if(nums.length==1){
            return;
        }
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[k++]=nums[i];              
            }
            else{
                count++;
            }
        
        }
        while(count!=0){
            nums[k++]=0;
            count--;
        }
    }
}