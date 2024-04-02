class Solution {
    public String removeStars(String s) {
         Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                    // Remove the closest non-star character to the left
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            } else {
                stack.addLast(i);
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}