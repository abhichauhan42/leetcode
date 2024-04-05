class Solution {
    public String makeGood(String s) {
         Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) {
                stack.pop(); // remove the last character from the stack
            } else {
                stack.push(c); // add the current character to the stack
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c); // construct the result string from characters in the stack
        }
        return result.toString();
    }
}