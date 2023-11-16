class Solution {
    public String findDifferentBinaryString(String[] nums) {
         Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int each = Integer.parseInt(nums[i], 2); // convert to 10 decimal
            set.add(each);
        }
        
        int length = nums[0].length();
        char[] chars = new char[length];
        Arrays.fill(chars, '1'); // find the biggest number and we decrement until we find one
        String firstString = new String(chars);
        int first = Integer.parseInt(firstString, 2); // convert to 10 decimal
        
        int answer = -1;
        for (int i = first; i >= 0; i--) {
            if (!set.contains(i)) { // if we didn't see it before, then it's an answer
                answer = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(answer)); // convert back to binary string
        while (sb.length() < length) {
            sb.insert(0, 0); // append 0 beforehand to match the length
        }
        return sb.toString();
    }
}