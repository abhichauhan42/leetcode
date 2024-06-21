class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n=customers.length;
        
        int maxUnsatCus=0;
        int currUnsat=0;
        
        for(int i=0;i<minutes;i++){
           currUnsat +=customers[i]*grumpy[i];
        }
        
        maxUnsatCus=currUnsat;
        
        int i=0;
        int j=minutes;
        while(j<n){
            currUnsat+=customers[j]*grumpy[j];
            currUnsat-=customers[i]*grumpy[i];
            
            maxUnsatCus=Math.max(maxUnsatCus,currUnsat);
            i++;
            j++;
        }
        
        int totalSatisfied=maxUnsatCus;
        for(int k=0;k<n;k++){
            totalSatisfied+=customers[k]*(1-grumpy[k]);
        }
        return totalSatisfied;
    }
}