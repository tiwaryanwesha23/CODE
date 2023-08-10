class Solution {
    public boolean search(int[] nums, int target) {
         int left = 0, right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[left] && nums[mid] == nums[right - 1]) {
                ++left;
                --right;
            } else if ((nums[mid] < nums[left] && (nums[mid] > target || nums[left] <= target)) || (nums[mid] >= nums[left] && nums[mid] > target && target >= nums[left])) {
                right = mid;
            } else left = mid + 1;
        }
        return false;
    }
}