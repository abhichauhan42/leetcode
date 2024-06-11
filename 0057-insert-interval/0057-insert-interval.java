class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]>result=new ArrayList<>();
        int n=intervals.length;
        int i=0;
        
        //step1.add all intervals before nre intervals
        
        while(i<n && intervals[i][1]<newInterval[0]){
            result.add(intervals[i]);
            i++;
        }
        
        //step2. for overlaaapin interval
        
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        result.add(newInterval);
        
        //step 3 for remining intervals
        
        while(i<n){
            result.add(intervals[i]);
            i++;
        }
       return  result.toArray(new int[result.size()][]);
    }
}