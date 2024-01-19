class Solution {
    
    public double halfpow(double x,long n){
          if (n == 0) {
            return 1;
        }
        
        if(n<0){
            return halfpow(1/x,-n);
        }
        if(n%2==0){
            return halfpow(x*x,n/2); 
        }
        
        return x*halfpow(x*x,(n-1)/2);

      
    }
    public double myPow(double x, int n) {
        return halfpow(x,n);
      
      
    }
}
