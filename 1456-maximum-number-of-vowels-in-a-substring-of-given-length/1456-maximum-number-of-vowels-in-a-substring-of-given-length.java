class Solution {
    public int maxVowels(String s, int k) {
        int totalVowelsInWindow = 0, 
            stringLength = s.length();
        for (int i = 0; i < k; ++i) {
            if (isVowel(s.charAt(i))) {
                ++totalVowelsInWindow;
            }
        }
        int maxVowels = totalVowelsInWindow;
        for (int i = k; i < stringLength; ++i) {
            if (isVowel(s.charAt(i))) {
                ++totalVowelsInWindow;
            }
            if (isVowel(s.charAt(i - k))) {
                --totalVowelsInWindow;
            }
            maxVowels = Math.max(maxVowels, totalVowelsInWindow);
        }
        return maxVowels;
    }

    private boolean isVowel(char character) {
        return character == 'a' || 
               character == 'e' || 
               character == 'i' || 
               character == 'o' || 
               character == 'u';
    }
}