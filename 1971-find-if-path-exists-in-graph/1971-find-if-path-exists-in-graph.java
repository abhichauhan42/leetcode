class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
              Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current == destination)
                return true;
            visited.add(current);
            List<Integer> neighbors = graph.getOrDefault(current, new ArrayList<>());
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor))
                    stack.push(neighbor);
            }
        }

        return false;
    }
}