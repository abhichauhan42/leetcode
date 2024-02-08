class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list=new ArrayList<>();
        int startrow=0;
        int startcol=0;
        int endrow=matrix.length-1;
        int endcol=matrix[0].length-1;
        
        while(startrow<=endrow && startcol<=endcol){
            //top
            for(int j=startcol;j<=endcol;j++){
                list.add(matrix[startrow][j]);
            }
            //right
            for(int i=startrow+1;i<=endrow;i++){
                list.add(matrix[i][endcol]);   
            }
            //bottom
            if(startrow==endrow){
                break;
            }
            for(int j=endcol-1;j>=startcol;j--){
                list.add(matrix[endrow][j]);
            }
            //left
            if(startcol==endcol){
                break;
            }
            for(int i=endrow-1;i>startrow;i--){
                list.add(matrix[i][startcol]);
            }
            startrow++;
            startcol++;
            endrow--;
            endcol--;
        }
        return list;
    }
}