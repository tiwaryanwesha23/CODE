class Solution {
     public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        // Sort in ascending order.
        Arrays.sort(nums);

        // 'length' records the length of the longest subsequence possible for nums[i].
        int[] length = new int[n];
        // 'previous' records the index of the preceding integer, so that we can get the list of the subsequence.
        int[] previous = new int[n];

        // For keeping track of the maximum length, so we take note of the index of the head of the subsequence.
        int maxLength = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            // Initialize the arrays. Length is 1 because that is the shortest possible length, with 1 element.
            // Set 'previous' as -1 for when that number is the start of the subsequence (do not have any divisor).
            length[i] = 1;
            previous[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                // If we found a divisor, as the length is greater, then record in the arrays.
                if (nums[i] % nums[j] == 0 && length[j] >= length[i]) {
                    length[i] = length[j] + 1;
                    previous[i] = j;
                }
            }
            // If we successfully found a longer subsequence, then keep track of the index of the head.
            if (length[i] > maxLength) {
                maxLength = length[i];
                index = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        // Here is where we use the index (head) of the subsequence and traverse each element in the subsequence.
        // Imagine a singly linked list.
        while (index >= 0) {
            result.add(nums[index]);
            index = previous[index];
        }
        return result;
    }
}