class Solution {
    class UnionFind {
        int[] parent;
        int[] rank;
        int count;
        
        public UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            count = n;
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int u) {
            if (u != parent[u]) {
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }
        
        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            
            if (rootU == rootV) return false;
            
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            count--;
            return true;
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind uf1 = new UnionFind(n);
        UnionFind uf2 = new UnionFind(n);
        
        int edgesRequired = 0;
        
        // Process type 3 edges first
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (uf1.union(edge[1], edge[2])) {
                    uf2.union(edge[1], edge[2]);
                    edgesRequired++;
                }
            }
        }
        
        // Process type 1 edges for Alice
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (uf1.union(edge[1], edge[2])) {
                    edgesRequired++;
                }
            }
        }
        
        // Process type 2 edges for Bob
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (uf2.union(edge[1], edge[2])) {
                    edgesRequired++;
                }
            }
        }
        
        // Check if both Alice and Bob can traverse the entire graph
        if (uf1.count != 1 || uf2.count != 1) {
            return -1;
        }
        
        return edges.length - edgesRequired;
    }
}