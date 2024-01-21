class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    
    public String reverseVowels(String s) {
        
       char[] charArray = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Find the left vowel
            while (left < right && !isVowel(charArray[left])) {
                left++;
            }

            // Find the right vowel
            while (left < right && !isVowel(charArray[right])) {
                right--;
            }

            // Swap the vowels
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return new String(charArray);
    }
}