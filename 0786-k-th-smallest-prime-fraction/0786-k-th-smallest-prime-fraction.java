class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                double ratioA = a[0] * 1D / a[1];
                double ratioB = b[0] * 1D / b[1];
                if(ratioA < ratioB) return -1;
                else if(ratioA > ratioB) return 1;
                return 0;
            }
        });
        int n = A.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                pq.offer(new int[]{A[i], A[j]});
            }
        }
        int i = 1;
        while(i++ < K) pq.poll();
        return pq.peek();
    }
}
