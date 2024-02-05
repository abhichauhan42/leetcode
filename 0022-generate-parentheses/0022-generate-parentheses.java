class Solution {
    void printcomb(String current,int o,int c,List<String> result,int n){
        if(current.length()==2*n){
            result.add(current);
            return;
        }
        if(o<n){
            printcomb(current+"(",o+1,c,result,n);
        }
        if(c<o){
            printcomb(current+")",o,c+1,result,n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        printcomb("(",1,0,result,n);
        return result;
        
    }
}