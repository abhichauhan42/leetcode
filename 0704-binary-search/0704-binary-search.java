class Solution {
    
    public int binarysearch(int nums[],int l,int h,int x){
        if(l>h){
            return -1;
        }
        
        int mid=(l+h)/2;
        
        if(nums[mid]==x){
            return mid;
        }
        else if(x<nums[mid]){
            return binarysearch(nums,l,mid-1,x);
        }
        else{
            return binarysearch(nums,mid+1,h,x);
        }
    }
    public int search(int[] nums, int target) {
        int n=nums.length;
        return binarysearch(nums,0,nums.length-1,target);
    }
}