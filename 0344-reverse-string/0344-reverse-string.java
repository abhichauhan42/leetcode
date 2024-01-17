class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        char[] reverse = new char[n];

        for (int i = n - 1; i >= 0; i--) {
            reverse[n - 1 - i] = s[i];
        }
        System.arraycopy(reverse, 0, s, 0, n);
    }
}
