class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxarea = 0;
        int nsr[]=new int[heights.length];
        int nsl[]=new int[heights.length];
        
        //for next smaller right
        Stack<Integer> s1=new Stack<>();
        
        for(int i=heights.length-1;i>=0;i--){
        while(!s1.isEmpty() && heights[s1.peek()]>=heights[i]){
            s1.pop();
        }
            if(s1.isEmpty()){
                nsr[i]=heights.length;
            }
            else{
                nsr[i]=s1.peek();
            }
            s1.push(i);
        }
        
        //for next smaller left
       Stack<Integer> s2=new Stack<>();
        for(int i=0;i<heights.length;i++){
        while(!s2.isEmpty() && heights[s2.peek()]>=heights[i]){
            s2.pop();
        }
            if(s2.isEmpty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=s2.peek();
            }
            s2.push(i);
        }
        //current area
        for(int i=0;i<heights.length;i++){
            int h=heights[i];
            int width=nsr[i]-nsl[i]-1;
            int currarea=h*width;
            maxarea=Math.max(currarea,maxarea);
        }
        return maxarea;
     
    }
}
