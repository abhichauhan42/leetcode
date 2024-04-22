class Solution {
    public int openLock(String[] deadends, String target) {
         Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        if (deads.contains("0000")) return -1; // Check if initial state is a deadend

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) return depth;

                for (int j = 0; j < 4; j++) {
                    for (int d = -1; d <= 1; d += 2) {
                        int digit = (current.charAt(j) - '0' + d + 10) % 10; // Handling wrap around
                        String neighbor = current.substring(0, j) + ("" + digit) + current.substring(j + 1);
                        if (!visited.contains(neighbor) && !deads.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            depth++;
        }
        return -1; 
    }
}