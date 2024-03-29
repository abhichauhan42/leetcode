class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows<=1){
            return s;
        }
        
        StringBuilder result=new StringBuilder();
        for(int row=0;row<numRows;row++){
            int i=row;
            boolean up=true;
            
            while(i<s.length()){
                result=result.append(s.charAt(i));
                
                if(row==0 || row==numRows-1){
                    i+=(2*numRows-2);
                }
                else{
                    if(up){
                        i+=(2*(numRows-row)-2);
                    }
                    else{
                        i+=row*2;
                    }
                    up ^=true;      
                }
            }      
        }
        return result.toString();
        
    }
}