class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] acc = new int[n+1];
        for(int i=1; i<=n; i++){
            acc[i] = acc[i-1]^arr[i-1];
        }
        int[] res = new int[queries.length];
        for(int j=0; j<queries.length; j++){
            int start = queries[j][0], end = queries[j][1];
            res[j] = acc[end+1]^acc[start];
        }
        return res;
    }
}