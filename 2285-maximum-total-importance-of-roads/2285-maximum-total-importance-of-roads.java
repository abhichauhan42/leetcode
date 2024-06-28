class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree=new int[n];
        
        for(int[] road:roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }
        
        Integer[] cities=new Integer[n];
        
        for(int i=0;i<n;i++){
            cities[i]=i;
        }
        
        //sort cities based on the degree in descending order
        Arrays.sort(cities,(a,b)->degree[b]-degree[a]);
        
        //Assign values to cities
        
        int[] values=new int[n];
        for(int i=0;i<n;i++){
            values[cities[i]]=n-i;
        }
        
        long total=0;
        for(int[] road:roads){
            total+=values[road[0]]+values[road[1]];
        }
        
        return total;
    }
    
}