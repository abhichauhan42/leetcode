import java.util.Stack;

class Solution {
    public String reverseWords(String s) {
        StringBuilder reverse = new StringBuilder();
      String[] words=s.split("\\s+");
        for(int i=words.length-1;i>=0;i--){
            reverse.append(words[i]);
            reverse.append(" ");
        }

        return reverse.toString().trim();
    }
}
