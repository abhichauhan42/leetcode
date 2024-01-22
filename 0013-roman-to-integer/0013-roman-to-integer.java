class Solution {
    public int romanToInt(String s) {
        int I=1, V=5, X=10, L=50, C=100, D=500, M=1000;
        
        int sum = 0;
        int prevValue = 0;
        
        for(int i = s.length() - 1; i >= 0; i--) {
            char curr = s.charAt(i);
            int currValue = 0;
            
            switch(curr) {
                case 'I':
                    currValue = I;
                    break;
                case 'V':
                    currValue = V;
                    break;
                case 'X':
                    currValue = X;
                    break;
                case 'L':
                    currValue = L;
                    break;
                case 'C':
                    currValue = C;
                    break;
                case 'D':
                    currValue = D;
                    break;
                case 'M':
                    currValue = M;
                    break;
            }
            
            if (currValue < prevValue) {
                sum -= currValue;
            } else {
                sum += currValue;
            }
            
            prevValue = currValue;
        }
        
        return sum;
    }
}
