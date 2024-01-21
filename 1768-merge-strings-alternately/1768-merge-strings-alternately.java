class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int i = 0;
        int j = 0;
        StringBuilder result = new StringBuilder();

        while (i < m && j < n) {
            result.append(word1.charAt(i++));
            result.append(word2.charAt(j++));
        }

        while (i < m) {
            result.append(word1.charAt(i++));
        }

        while (j < n) {
            result.append(word2.charAt(j++));
        }

        return result.toString();
    }
}
