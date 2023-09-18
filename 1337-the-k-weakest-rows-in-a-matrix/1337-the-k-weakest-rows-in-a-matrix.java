class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] counts = new int[n][2];
        for(int i=0; i<n; i++){
            counts[i][0] = i;
            int count = 0;
            for(int j=0; j<m;j++){
                count += mat[i][j];
            }
            counts[i][1] = count;
        }
        Arrays.sort(counts, (a,b)->{
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            else return a[0]-b[0];
        });
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = counts[i][0];
        }
        return res;
    }
}