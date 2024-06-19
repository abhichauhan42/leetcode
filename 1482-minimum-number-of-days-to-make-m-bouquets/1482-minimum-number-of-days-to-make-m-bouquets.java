class Solution {
    public int canMakeBouquet(int[] bloomDay,int mid,int k){
        int bouquetcount=0;
        int consecutivecount=0;
        
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                consecutivecount++;
            }
            else{
                consecutivecount=0;
            }
            
            if(consecutivecount==k){
                bouquetcount++;
                consecutivecount=0;
            }
        }
      return bouquetcount;
        
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
         if (m * k > n) {
            return -1;
        }
        
        int startday=0;
        int endday=0;  //maximum of the array
        for(int i=0;i<n;i++){
            endday=Math.max(endday,bloomDay[i]);
        }
        
        int minDays=-1;
        
        while(startday<=endday){
            int mid=startday+(endday-startday)/2;
            if(canMakeBouquet(bloomDay,mid,k)>=m){
                minDays=mid;
                endday=mid-1;
            }
            else{
                startday=mid+1;
            }
        }
        return minDays;
    }
}