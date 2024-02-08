class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][]=new int[n][n];
        int startrow=0;
        int startcol=0;
        int endrow=arr.length-1;
        int endcol=arr[0].length-1;
        
        int count=1;
        while(startrow<=endrow && startcol<=endcol){
            //top
            for(int j=startcol;j<=endcol;j++){
                arr[startrow][j]=count;
                count++;
            }
            //right
            for(int i=startrow+1;i<=endrow;i++){
                arr[i][endcol]=count;
                count++;
            }
            //bottom
            if(startrow==endrow){
                break;
            }
            for(int j=endcol-1;j>=startcol;j--){
                arr[endrow][j]=count;
                count++;
            }
            //left
            if(startcol==endcol){
                break;
            }
            for(int i=endrow-1;i>startrow;i--){
                arr[i][startcol]=count;
                count++;
            }
            startrow++;
            startcol++;
            endrow--;
            endcol--;
        }
        return arr;
    }
}