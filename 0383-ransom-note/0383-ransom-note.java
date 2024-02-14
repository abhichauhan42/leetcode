import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charCount = new HashMap<>();

        // Count characters in magazine
        for (char ch : magazine.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        // Check if ransomNote can be constructed
        for (char ch : ransomNote.toCharArray()) {
            if (charCount.containsKey(ch) && charCount.get(ch) > 0) {
                charCount.put(ch, charCount.get(ch) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
