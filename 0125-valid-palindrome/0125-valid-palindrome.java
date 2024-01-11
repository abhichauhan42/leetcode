class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
    int h = s.length() - 1;

    while (l <= h) {
        char getl = Character.toLowerCase(s.charAt(l));
        char getr = Character.toLowerCase(s.charAt(h));

        if (!Character.isLetterOrDigit(getl)) {
            l++;
        } else if (!Character.isLetterOrDigit(getr)) {
            h--;
        } else if (getl == getr) {
            l++;
            h--;
        } else {
            return false;
        }
    }
    return true;
    }
}