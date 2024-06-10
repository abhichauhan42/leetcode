class Solution {
    public int maxProduct(int[] nums) {
//         Arrays.sort(nums);
//         int n=nums.length;
        
//         int maxpro=0;
        
//         for(int i=0;i<n-1;i++){
//             int j=i+1;
//             maxpro=Math.max(maxpro,(nums[i]-1)*(nums[j]-1));
//         }
//         return maxpro;
//     }

        // Initialize two variables to store the largest and second largest numbers
        int max1 = 0, max2 = 0;
        
        for (int num : nums) {
            // If the current number is greater than the largest number found so far
            if (num > max1) {
                // Update the second largest to be the previous largest
                max2 = max1;
                // Update the largest to be the current number
                max1 = num;
            } else if (num > max2) { // If the current number is greater than the second largest
                // Update the second largest to be the current number
                max2 = num;
            }
        }
        
        // Return the product of (max1 - 1) and (max2 - 1)
        return (max1 - 1) * (max2 - 1);
    }

}