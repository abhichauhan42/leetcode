class Solution {
    public int maxVowels(String s, int k) {
        int currentvowel=0;
        
        String temp="";
        
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                temp+=s.charAt(i);
                currentvowel++;
            }
            else{
                temp+=s.charAt(i);
            }
        }
        
        int maxvowel=currentvowel;
        
        for(int i=k;i<s.length();i++){
            temp+=s.charAt(i)-s.charAt(i-k);
            if(s.charAt(i-k)=='a' || s.charAt(i-k)=='e' || s.charAt(i-k)=='i' || s.charAt(i-k)=='o' || s.charAt(i-k)=='u'){
                currentvowel--;    
            }
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){ 
                currentvowel++;
        }
            maxvowel=Math.max(maxvowel,currentvowel);
        
    }
        return maxvowel;
    }
}