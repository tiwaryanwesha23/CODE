public class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        boolean[] visited = new boolean[n];
        visited[start] = true;
        boolean newVisit = true;
        while (!visited[end] && newVisit) {
            newVisit = false;
            for (int i = edges.length - 1; i >= 0; i--) {
                if (visited[edges[i][0]]) {
                    if (!visited[edges[i][1]]) {
                        visited[edges[i][1]] = newVisit = true;
                    }
                } else if (visited[edges[i][1]]) {
                    visited[edges[i][0]] = newVisit = true;
                }
            }
        }

        return visited[end];
    }
}
