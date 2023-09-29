class Solution {
    public boolean isMonotonic(int[] A) {
        return verify(A, true) || verify(A, false);
    }
    
    private boolean validate(int a, int b, boolean incline) {
        if (incline) return a <= b;
        return a >= b;
    }
    
    private boolean verify(int[] A, boolean incline) {
        for (int i = 0; i < A.length - 1; i++) {
            if (!validate(A[i], A[i + 1], incline)) {
                return false;
            }
        }
        return true;
    }
}