class Solution {
    public boolean isPalindrome(int x) {
        int reverse=0;
        int original=x;
        int rem;
        
        while(x>0){
            rem=x%10;
            reverse=reverse*10+rem;
            x=x/10;
        }
        if(reverse==original){
            return true;
        }
        else{
            return false;
        }
        
    }
}