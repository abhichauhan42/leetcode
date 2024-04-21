class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int source, int destination, boolean[] visited) {
        if (source == destination)
            return true;
        visited[source] = true;
        List<Integer> neighbors = graph.getOrDefault(source, new ArrayList<>());
        for (int neighbor : neighbors) {
            if (!visited[neighbor] && dfs(graph, neighbor, destination, visited))
                return true;
        }
        return false;
    }
}