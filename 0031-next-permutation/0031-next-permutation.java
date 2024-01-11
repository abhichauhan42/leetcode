class Solution {
    public void nextPermutation(int[] nums){
      int n = nums.length;
        int k = n - 2;
        for (k = n - 2; k >= 0; k--) {
            if (nums[k] <nums[k + 1]) {
              break;
            }
          }

        if(k==-1){
            reverse(nums,0,n-1);
            return;
        }
        // System.out.println(nums[k]);

        for(int j=n-1;j>=0;j--){
            if(nums[j]>nums[k]){
                int temp=nums[k];
                nums[k]=nums[j];
                nums[j]=temp;
                break;
            }
        }
        reverse(nums,k+1,n-1);
    }
    public static void reverse(int nums[],int start,int end){
        while(start<=end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }

    }
        
    }
