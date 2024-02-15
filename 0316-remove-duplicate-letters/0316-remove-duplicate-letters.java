import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastOccurrence = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (visited[currentChar - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && currentChar < stack.peek() && i < lastOccurrence[stack.peek() - 'a']) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(currentChar);
            visited[currentChar - 'a'] = true;
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
