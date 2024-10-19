class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        int len = (int) Math.pow(2, n) - 1;
        int mid = len / 2;
        if (mid + 1 == k) {
            return '1';
        }

        if (mid + 1 > k) {
            return findKthBit(n - 1, k);
        }

        int nextLen = (int) Math.pow(2, n - 1) - 1;

        char value = findKthBit(n - 1, nextLen + 1 - (k - nextLen - 1));

        return value == '0' ? '1' : '0';
    }
}