class Solution {
    public String reverseParentheses(String s) {
         Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == ')') {
                // When we encounter ')', we start popping from the stack until we find '('
                Queue<Character> queue = new LinkedList<>();
                while (stack.peek() != '(') {
                    queue.add(stack.pop());
                }
                // Pop the '('
                stack.pop();
                
                // Push the characters back to the stack
                while (!queue.isEmpty()) {
                    stack.push(queue.poll());
                }
            } else {
                // Push every character other than ')'
                stack.push(c);
            }
        }
        
        // Collect the result from the stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        
        return result.toString();
        
    }
}