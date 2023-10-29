class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        final int round = minutesToTest / minutesToDie;
        if (buckets != 0) {
            buckets -= 1;
        }
        int res = 0;
        while (buckets != 0) {
            buckets /= round + 1;
            res ++;
        }
        return res;
    }
}