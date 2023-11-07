class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
         for (int i = 0; i < dist.length; i++) {
            dist[i] = (dist[i] - 1) / speed[i] + 1;
        }
        Arrays.sort(dist);
        int ans = 1;
        int time = 1;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] > time) {
                ans++;
                time++;
            } else {
                return ans;
            }
        }
        return ans;
    }
}