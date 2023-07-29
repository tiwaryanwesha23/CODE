class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxProduct = new int[2], minProduct = new int[2];
        maxProduct[0] = nums[0];
        minProduct[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > 0) {
                maxProduct[i % 2] = Math.max(num, maxProduct[(i - 1) % 2] * num);
                minProduct[i % 2] = Math.min(num, minProduct[(i - 1) % 2] * num);
            } else {
                maxProduct[i % 2] = Math.max(num, minProduct[(i - 1) % 2] * num);
                minProduct[i % 2] = Math.min(num, maxProduct[(i - 1) % 2] * num);
            }
            max = Math.max(max, maxProduct[i % 2]);
        }
        return max;
    }
}