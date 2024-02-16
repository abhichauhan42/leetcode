class Solution {
    public int majorityElement(int[] nums) {
       Arrays.sort(nums);
        int maxoccurence=0;
        int majorityelement=0;
        for(int i=0;i<nums.length;i++){
            int current=nums[i];
            int j=i+1;
            while(j<nums.length && nums[j]==current){
                j++;
            }
            
            int currentoccurence=j-i;
            if(currentoccurence>maxoccurence){
                majorityelement=current;
                maxoccurence=currentoccurence;
            }
            i=j-1;
            
        }
        return majorityelement;
    }
}
