import java.util.ArrayList;
import java.util.List;

class Solution {

    public static String[] keypad = { ".",".","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> combinations(String digits, int indx, String ans) {
        ArrayList<String> list = new ArrayList<>();
         if (digits == null || digits.length() == 0) {
        return list; 
    }

        if (indx == digits.length()) {
            list.add(ans);
            return list;
        }

        char currchar = digits.charAt(indx);
        String mapping = keypad[currchar - '0'];
        for (int i = 0; i < mapping.length(); i++) {
            list.addAll(combinations(digits, indx + 1, ans + mapping.charAt(i)));
        }
        return list;
    }

    public List<String> letterCombinations(String digits) {
        Solution obj = new Solution(); 
        return obj.combinations(digits, 0, ""); 
    }
}
