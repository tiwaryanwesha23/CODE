class Solution {
    public int[] findErrorNums(int[] nums) {
           int dup = -1;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[Math.abs(nums[i]) - 1] < 0)
            dup = Math.abs(nums[i]);
        else
            nums[Math.abs(nums[i]) - 1] *= -1;

        sum += i + 1 - Math.abs(nums[i]);
    }
    return new int[]{dup, dup + sum};
        
    }
}